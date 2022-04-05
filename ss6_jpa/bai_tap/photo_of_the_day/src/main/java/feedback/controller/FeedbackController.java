package feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feedback.model.Feedback;
import feedback.service.IFeedbackService;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 15:59
*/
@Controller
@RequestMapping(value = "/picture")
public class FeedbackController {

    @Autowired
    private IFeedbackService iFeedbackService;

    @GetMapping(value = "")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("feedback", new Feedback());
        List<Feedback> feedbackList = iFeedbackService.findAll();
        modelAndView.addObject("feedbackList", feedbackList);
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("feedback") Feedback feedback) {
        feedback.setLikeNumber(0);
        feedback.setCommentDay(String.valueOf(java.time.LocalDate.now()));
        System.out.println(feedback);
        iFeedbackService.save(feedback);
        return "redirect:/picture";
    }


    @GetMapping(value = "/like/{id}")
    public String like(@PathVariable("id") int id) {
        Feedback feedback = iFeedbackService.findById(id);
        iFeedbackService.increateCommentLike(feedback);
        return "redirect:/picture";
    }
}
