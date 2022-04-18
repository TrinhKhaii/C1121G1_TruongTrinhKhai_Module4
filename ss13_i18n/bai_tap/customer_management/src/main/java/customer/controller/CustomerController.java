package customer.controller;

import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Created by Trinh Khai
    Date: 18/04/2022
    Time: 11:15
*/
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", iCustomerService.findAll());
        return modelAndView;
    }
}
