package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankPaymentApplication.class, args);
		System.out.println("Bank Payment Service Started");
	}

}
