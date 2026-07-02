package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.PaymentRestConsumer;

@RestController
public class CartRestController {

    @Autowired
    private PaymentRestConsumer consumer;

    @GetMapping("/cart/getData")
    public String getCartData() {

        return "FROM CART-SERVICE : " + consumer.getPaymentData();

    }

}