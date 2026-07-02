package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BankPaymentService {

    public String makePayment() {

        return "Payment Successfully Processed by Bank.";
    }

}