package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 10:22
*/

@Controller
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "")
    public String list(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("product") Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("product") Product product) {
        iProductService.update( product);
        return "redirect:/product";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/view/{id}")
    public String showViewForm(@PathVariable("id") Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam("search") String name, Model model) {
        List<Product> productList = iProductService.productListSearchByName(name);
        if (productList.isEmpty()) {
            model.addAttribute("message", "Not found any product");
        } else {
            model.addAttribute("productList", productList);
        }
        return "/search";
    }
}
