package customer.controller;

import customer.model.Customer;
import customer.model.Province;
import customer.service.customer.ICustomerService;
import customer.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

//    @GetMapping("/customers")
//    public ModelAndView listCustomers() {
//        Iterable<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

//    @GetMapping("/customers")
//    public ModelAndView listCustomers(Pageable pageable){
//        Page<Customer> customers = customerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,
                                      @PageableDefault(value = 1) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        Page<Customer> customers;
//        if(search.isPresent()){
////            modelAndView.addObject("search", search);
//            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
//        } else {
//            customers = customerService.findAll(pageable);
//        }
        String searchValue = search.orElse("");
        Page<Customer> customers = this.customerService.findAllByFirstNameContaining(searchValue, pageable);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

}
