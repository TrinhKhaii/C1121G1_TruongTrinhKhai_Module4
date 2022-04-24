package furama.controller;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 14:46
*/

import furama.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping(value = "")
    public ModelAndView showMainPage() {
        return new ModelAndView("menu");
    }

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView("/login_page");
        return modelAndView;
    }

    @GetMapping(value = "/403")
    public ModelAndView accessDenied() {
        return new ModelAndView("403Page");
    }
}
