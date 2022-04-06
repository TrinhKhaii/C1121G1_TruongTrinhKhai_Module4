package blog.controller;

import blog.model.Blog;
import blog.model.Category;
import blog.service.IBlogService;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @GetMapping(value = "")
    public ModelAndView list(@RequestParam("keyword") Optional<String> keyword,
                             @PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Page<Blog> blogPage;
        String keywordValue = keyword.orElse(null);
        if (keyword.isPresent()) {
            blogPage = iBlogService.findBlogByName(keywordValue, pageable);
        } else {
            blogPage = iBlogService.findAllBlog(pageable);
        }
        modelAndView.addObject("blogPage", blogPage);
        modelAndView.addObject("keyword", keywordValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("blog") Blog blog) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        blog.setCreateDate(formatter.format(date));
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("blog/edit");
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
        ModelAndView modelAndView = new ModelAndView("blog/view");
        Blog blog = iBlogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
