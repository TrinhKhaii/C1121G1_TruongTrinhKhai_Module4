package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 11:36
*/
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping(value = "/info")
    public String getInfoCustomer(@RequestParam(name = "id") Long id,
                                  Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "info";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@RequestParam(name = "id") Long id,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "address") String address,
                                 Model model) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.save(customer);
        model.addAttribute("customer", customer);
        return "info";
    }
}
