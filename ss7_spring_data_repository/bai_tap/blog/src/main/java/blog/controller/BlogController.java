package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:43
*/
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> blogList = iBlogService.findAll();
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", iBlogService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer idDelete) {
        iBlogService.remove(idDelete);
        return "redirect:/blog";
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable("id") Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView("view");
        Blog blog = iBlogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
