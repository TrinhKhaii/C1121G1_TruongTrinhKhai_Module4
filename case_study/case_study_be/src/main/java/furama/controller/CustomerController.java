package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import furama.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
                                 @PageableDefault(value = 3) Pageable pageable) {
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
}
