package phone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 22:05
*/
@Controller
public class PhoneController {
    @GetMapping(value = "")
    public String showIndex() {
        return "/index";
    }
}
