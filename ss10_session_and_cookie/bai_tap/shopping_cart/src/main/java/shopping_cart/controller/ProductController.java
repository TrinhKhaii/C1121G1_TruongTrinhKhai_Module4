package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shopping_cart.model.Cart;
import shopping_cart.model.Product;
import shopping_cart.service.IProductService;

import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 14:32
*/
@Controller
@SessionAttributes("cart")
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping(value = "")
    public ModelAndView showProductList() {
        Iterable<Product> products = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping(value = "/buy/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") Integer id) {
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping(value = "/buy")
    public String productDetail(@ModelAttribute("product") Product product,
                                @SessionAttribute("cart") Cart cart) {

        cart.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/add/{id}")
    public String addProductAmount(@PathVariable("id") Integer id,
                                   @RequestParam("action") Optional<String> action,
                                   @SessionAttribute("cart") Cart cart) {
        Product product = iProductService.findById(id);
        if (action.isPresent()) {
            if (action.get().equals("add")) {
                cart.addProduct(product);
                return "redirect:/shopping-cart";
            } else if (action.get().equals("reduce")) {
                cart.reduceProduct(product);
                return "redirect:/shopping-cart";
            }
        }
        cart.addProduct(product);
        return "redirect:/product";
    }
}
