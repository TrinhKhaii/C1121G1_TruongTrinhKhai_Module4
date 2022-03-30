package com.codegym.controller;
/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 05:31
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
@Controller
public class TimeController {

    @GetMapping(value = "/world-clock")
    public String getTimeByTimeZone(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city,
                                    Model model) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long localTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(localTime);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
