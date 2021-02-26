package com.tts.ecomspring.controller;

import lombok.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class CheckoutController {
    @Value("STRIPE_PUBLIC_KEY")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("amout", 50*100); // in cents
        model.addAttribute()
    }
}
