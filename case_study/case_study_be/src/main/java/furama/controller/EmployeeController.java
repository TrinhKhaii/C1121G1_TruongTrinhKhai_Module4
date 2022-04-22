package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.dto.employee_dto.EmployeeDTO;
import furama.dto.employee_dto.UserDTO;
import furama.model.customer_entity.Customer;
import furama.model.employee_entity.Division;
import furama.model.employee_entity.EducationDegree;
import furama.model.employee_entity.Employee;
import furama.model.employee_entity.Position;
import furama.model.user_role_entity.User;
import furama.service.IEmployeeService;
import furama.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 22:51
*/
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IUserService iUserService;

    @ModelAttribute("positions")
    public Iterable<Position> sendPositionList() {
        return iEmployeeService.findAllPosition();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> sendEducationDegreeList() {
        return iEmployeeService.findAllEducationDegree();
    }

    @ModelAttribute("divitions")
    public Iterable<Division> sendDivisionList() {
        return iEmployeeService.findAllDivision();
    }

    @GetMapping(value = {"", "/search"})
    public ModelAndView showList(@RequestParam("searchValue") Optional<String> search,
                                 @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        String searchValue = search.orElse("");
        Page<Employee> employees = iEmployeeService.findAllByName(searchValue, pageable);

        modelAndView.addObject("employees", employees);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDTO", new EmployeeDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        Employee employee = new Employee();
        User user = new User();
        BeanUtils.copyProperties(employeeDTO, employee);
        BeanUtils.copyProperties(employeeDTO.getUserDTO(), user);
        employee.setUser(user);
        iUserService.save(user);
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        Employee employee = iEmployeeService.findById(id).orElse(null);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (employee != null) {
            employeeDTO.setUserDTO(new UserDTO());
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTO.setDivision(employee.getDivision());
            employeeDTO.setEducationDegree(employee.getEducationDegree());
            employeeDTO.setPosition(employee.getPosition());
            BeanUtils.copyProperties(employee.getUser(), employeeDTO.getUserDTO());
            modelAndView.addObject("employeeDTO", employeeDTO);
        }
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                         BindingResult bindingResult) {
        UserDTO userDTO = new UserDTO();
        userDTO.setiUserService(this.iUserService);
        userDTO.validate(employeeDTO.getUserDTO(), bindingResult);
        if (bindingResult.hasErrors()) {
            return "/employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setUser(new User());
        employee.setEducationDegree(employeeDTO.getEducationDegree());
        employee.setDivision(employeeDTO.getDivision());
        employee.setPosition(employeeDTO.getPosition());
        BeanUtils.copyProperties(employeeDTO.getUserDTO(), employee.getUser());
        iUserService.save(employee.getUser());
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }
}
