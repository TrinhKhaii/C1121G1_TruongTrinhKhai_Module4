package furama.controller;

import furama.dto.contract_dto.ContractDTO;
import furama.model.contract_entity.Contract;
import furama.model.customer_entity.Customer;
import furama.model.employee_entity.Employee;
import furama.model.service_entity.Service;
import furama.service.IContractService;
import furama.service.ICustomerService;
import furama.service.IEmployeeService;
import furama.service.IServiceService;
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
    Date: 22/04/2022
    Time: 16:15
*/
@Controller
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IServiceService iServiceService;

    @ModelAttribute("customers")
    public Iterable<Customer> sendCustomerList() {
        return iCustomerService.findAll();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> sendEmployeeList() {
        return iEmployeeService.findAll();
    }

    @ModelAttribute("services")
    public Iterable<Service> sendServiceList() {
        return iServiceService.findAllByServiceTypeId();
    }

    @GetMapping(value = {"", "/search"})
    public ModelAndView showList(@RequestParam("searchValue") Optional<String> search,
                                 @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        String searchValue = search.orElse("");
        Page<Contract> contracts = iContractService.findAllByName(searchValue, pageable);

        modelAndView.addObject("contracts", contracts);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDTO", new ContractDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("contractDTO") ContractDTO contractDTO,
                       BindingResult bindingResult) {
        ContractDTO contractDTOError = new ContractDTO();
        contractDTOError.setiContractService(iContractService);
        contractDTOError.validate(contractDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO, contract);
        contract.setCustomer(contractDTO.getCustomer());
        contract.setEmployee(contractDTO.getEmployee());
        contract.setService(contractDTO.getService());
        contract.setContractTotalMoney(contract.getService().getServiceCost() + contract.getService().getRentType().getRentTypeCost());
        iContractService.save(contract);
        return "redirect:/contract";
    }
}
