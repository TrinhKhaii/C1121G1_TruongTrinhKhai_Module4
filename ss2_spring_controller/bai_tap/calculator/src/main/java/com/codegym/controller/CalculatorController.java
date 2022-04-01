package com.codegym.controller;

import com.codegym.repository.ICalculatorRepository;
import com.codegym.service.impl.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 15:01
*/
@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping(value = "")
    public String showForm() {
        return "index";
    }

    @GetMapping(value = "/calculator")
    public String calculator(@RequestParam(name = "num1") Double num1,
                             @RequestParam(name = "num2") Double num2,
                             @RequestParam(name = "submit") String calculator,
                             Model model) {
        Double result = 0.0;
        if (calculator.equals("Addition")) {
            result = iCalculatorService.addition(num1, num2);
        } else if (calculator.equals("Substraction")) {
            result = iCalculatorService.subtraction(num1, num2);
        } else if (calculator.equals("Multiplication")) {
            result = iCalculatorService.multiplication(num1, num2);
        } else if (calculator.equals("Division")) {
            result = iCalculatorService.division(num1, num2);
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }
}
