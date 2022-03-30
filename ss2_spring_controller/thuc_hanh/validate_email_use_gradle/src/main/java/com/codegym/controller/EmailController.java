package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 05:09
*/
@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping(value = "/")
    private String getIndex() {
        return "index";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    @PostMapping(value = "/validate")
    private String validateEmail(@RequestParam("email") String email,
                                 Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";

    }
}
