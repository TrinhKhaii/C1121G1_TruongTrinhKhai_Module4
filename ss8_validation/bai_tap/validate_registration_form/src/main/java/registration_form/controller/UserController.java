package registration_form.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import registration_form.dto.UserDto;
import registration_form.model.User;
import registration_form.service.IUserService;

import javax.validation.Valid;

/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 23:20
*/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView checlValidation(@Valid @ModelAttribute("userDto") UserDto userDto,
                                        BindingResult bindingResult) {
        ModelAndView modelAndView;
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        modelAndView = new ModelAndView("result");
        return modelAndView;

    }
}
