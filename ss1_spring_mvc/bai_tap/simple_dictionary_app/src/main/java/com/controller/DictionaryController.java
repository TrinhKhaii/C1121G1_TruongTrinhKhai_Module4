package com.controller;

import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 15:22
*/
@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping(value = "/")
    public String showForm() {
        return "main";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam(name = "vi") String vi,
                            Model model) {
        String english = dictionaryService.convertToEnglish(vi);
        model.addAttribute("vi", vi);
        model.addAttribute("en", english);
        return "main";
    }
}
