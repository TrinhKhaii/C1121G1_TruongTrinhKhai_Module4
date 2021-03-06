package furama.controller;

import furama.dto.ICustomerUseService;
import furama.dto.customer_dto.CustomerDTO;
import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import furama.model.customer_entity.CustomerUseService;
import furama.service.ICustomerService;
import furama.service.ICustomerUseServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 20/04/2022
    Time: 08:48
*/
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerUseServiceService iCustomerUseServiceService;

    @ModelAttribute("genders")
    public Iterable<String> sendGenderList() {
        return Arrays.asList("Nam", "Nữ", "Khác");
    }

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> sendCustomerTypeList() {
        return iCustomerService.findAllCustomerType();
    }

    @GetMapping(value = {"", "/search"})
    public ModelAndView showList(@RequestParam("searchValue") Optional<String> search,
                                 @PageableDefault(value = 3) Pageable pageable,
                                 Principal principal) {
//        if (principal != null) {
//            User user = (User) ((Authentication)principal).getPrincipal();
//        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        String searchValue = search.orElse("");
        Page<Customer> customers = iCustomerService.findAllByName(searchValue, pageable);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDTO", new CustomerDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                       BindingResult bindingResult) {
        CustomerDTO customerDTOError = new CustomerDTO();
        customerDTOError.setiCustomerService(iCustomerService);
        customerDTOError.validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setCustomerType(customerDTO.getCustomerType());
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Customer customer = iCustomerService.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO();
        if (customer != null) {
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTO.setCustomerType(customer.getCustomerType());
            modelAndView.addObject("customerDTO", customerDTO);
        }
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setCustomerType(customerDTO.getCustomerType());
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (customerOptional.isPresent()) {
            Customer customerDelete = customerOptional.get();
            customerDelete.setDeleteFlag(true);
            iCustomerService.save(customerDelete);
        }
        return "redirect:/customer";
    }

    @GetMapping(value = {"/customer-list-use-service", "/customer-list-use-service/search"})
    public ModelAndView showCustomerUseServiceList(@RequestParam("searchValue") Optional<String> search,
                                                   @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView  = new ModelAndView("/customer/customer_use_service_list");
        String searchValue = search.orElse("");
//        Page<CustomerUseService> customerUseServices = iCustomerUseServiceService.findAllByCustomerNameContaining(searchValue, pageable);
//        List<CustomerUseService> customerUseServices = iCustomerUseServiceService.findAllCustomerUseService();
        Page<ICustomerUseService> customerUseServices = iCustomerUseServiceService.findAllCustomerUseServicePage(PageRequest.of(pageable.getPageNumber(), 10));
        modelAndView.addObject("customerUseServices", customerUseServices);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }
}
