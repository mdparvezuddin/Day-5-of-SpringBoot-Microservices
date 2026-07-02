package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BankPaymentService;

@RestController
public class BankPaymentController {

    @Autowired
    private BankPaymentService service;

    @GetMapping("/bank/payment")
    public String payment() {

        return service.makePayment();

    }
}