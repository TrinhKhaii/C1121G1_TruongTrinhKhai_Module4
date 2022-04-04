package photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import photo.model.Feedback;
import photo.service.IFeedbackService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        modelAndView.addObject("now", java.time.LocalDate.now());
        List<Feedback> feedbackList = iFeedbackService.findAll();
        modelAndView.addObject("feedbackList", feedbackList);
        return modelAndView;
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute("feedback")Feedback feedback, Model model) {
        feedback.setLikeNumber(0);
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
