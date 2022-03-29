package com.controller;

import com.model.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 05:53
*/
@Controller
public class ConverterController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping(value = "/showForm")
    public String showForm() {
        return "converter";
    }

    @GetMapping(value = "/convert")
    public String convertVNDToUSD(@RequestParam(name = "num1") Double num1,
                                  @RequestParam(name = "exchange_rate") Double exchangeRate,
                                  Model model) {
        Double num2 = currencyService.converterToUSD(num1, exchangeRate);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("mess", "ố kề");
        return "converter";
    }
}
