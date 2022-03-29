package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 05:13
*/
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "/greeting";
    }
}
