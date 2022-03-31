package com.codegym.controller;

import com.codegym.model.EmailConfiguration;
import com.codegym.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 10:35
*/
@Controller
public class EmailConfigurationController {

    @Autowired
    private IEmailConfigurationService iEmailConfigurationService;

    @GetMapping(value = "/list")
    public String showList(Model model) {
        List<EmailConfiguration> emailConfigurationList = iEmailConfigurationService.emailConfigurationList();
        model.addAttribute("emailConfigurationList", emailConfigurationList);
        return "list";
    }
    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        EmailConfiguration emailConfiguration = new EmailConfiguration();
        List<String> languages = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSize = Arrays.asList(5, 10, 15, 25, 50, 100);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("emailConfiguration", emailConfiguration);
        return "create";
    }

    @PostMapping(value = "/create")
    public String createEmailConfiguration(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration) {
        iEmailConfigurationService.save(emailConfiguration);
        return "redirect:/list";
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdateEmailConfigurationForm(@PathVariable("id") Integer id,
                                                   Model model) {
        EmailConfiguration emailConfiguration1 =  iEmailConfigurationService.getEmailConfigurationById(id);
        model.addAttribute("emailConfiguration", emailConfiguration1);
        List<String> languages = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSize = Arrays.asList(5, 10, 15, 25, 50, 100);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        return "update-form";
    }

    @PostMapping(value = "/save")
    public String updateEmailConfigurationForm(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration) {
        iEmailConfigurationService.updateEmailConfiguration(emailConfiguration);
        return "redirect:/list";
    }
}
