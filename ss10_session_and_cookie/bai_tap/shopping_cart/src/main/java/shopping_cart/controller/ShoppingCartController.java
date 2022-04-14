package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shopping_cart.model.Cart;
import shopping_cart.model.Product;
import shopping_cart.service.IProductService;

/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 15:41
*/
@Controller
@RequestMapping(value = "/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public String deleteProductFromCart(@RequestParam("idDelete") Integer idDelete,
                                        @SessionAttribute(value = "cart", required = false) Cart cart) {
        Product product = iProductService.findById(idDelete);
        cart.delete(product);
        return "redirect:/shopping-cart";
    }
}
