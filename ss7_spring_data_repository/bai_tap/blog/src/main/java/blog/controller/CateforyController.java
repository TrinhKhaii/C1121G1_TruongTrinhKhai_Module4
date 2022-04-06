package blog.controller;

import blog.model.Category;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 13:43
*/
@Controller
@RequestMapping(value = "/category")
public class CateforyController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", iCategoryService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer idDelete) {
        iCategoryService.remove(idDelete);
        return "redirect:/category";
    }


}
