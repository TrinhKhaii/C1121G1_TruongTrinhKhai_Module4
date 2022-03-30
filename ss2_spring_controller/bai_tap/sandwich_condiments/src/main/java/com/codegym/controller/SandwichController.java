package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 11:44
*/
@Controller
public class SandwichController {

    @GetMapping(value = "")
    public String showList() {
        return "index";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam(value = "condiments",  defaultValue = "Hổng có gì") String[] condiment,
                       Model model) {
        model.addAttribute("condiment", condiment);
        return "result";
    }

}
