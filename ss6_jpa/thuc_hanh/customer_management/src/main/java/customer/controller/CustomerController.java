package customer.controller;

import customer.model.Customer;
import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:43
*/
@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customerList = iCustomerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("customer") Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", iCustomerService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("customer") Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer idDelete) {
        iCustomerService.remove(idDelete);
        return "redirect:/customers";
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateFormBySP() {
        ModelAndView modelAndView = new ModelAndView("create-with-sp");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        iCustomerService.insertWithStoredProcedure(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "New customer created successfully");
        return "redirect:/customers";
    }
}
