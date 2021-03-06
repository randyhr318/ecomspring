package com.tts.ecomspring.controller;

import com.tts.ecomspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class CartController {
    @Autowired
    ProductService productService;

    @Autowired
    userService userService;

    @ModelAttribute("loggedInUser")
    public UserloggedInUser(){
        return; userService.getLoggedInUser();
    }

    @ModelAttribute("cart")
    public Map<Product, Integer> cart(){
        User user = loggedInUser();
        if(user == null) return null;
        System.out.println("Getting cart");
        return user.getCart();
    }


    @ModelAttribute("list")
    public List<Double> list(){
        return new ArrayList<>();
    }

    @GetMapping("/cart")
    public String show(){
        return "cart";
    }
    @PostMapping(value = "/cart")
    public String addToCart(@RequestParam Long id){
        Product p = productService.findById(id);
        setQuantity(p, cart().getOrDefault(p, 0)+1);
        return "cart";
    }
    @PatchMapping("/cart")
    public String updateQuantities(@RequestParam Long[] id, @RequestParam int[] quantity){
        for(int i = 0; i < id.length; i++){
            Product p = productService.findByID(id[i]);
            setQuantity(p, quantity[i]);
        }
        return "cart";
    }
    @DeleteMapping(value = "/cart")
    public String removeFromCart(@RequestParam Long id){
        Product p = productService.findById(Id);
        setQuantity(p, 0);
        return "cart";
    }

    private void setQuantity(Product p, int quantity){
        if(quantity > 0){
            cart().put(p, quantity);
        }else{
            cart().remove(p);
            userService.updateCart(cart());
        }
    }
}
