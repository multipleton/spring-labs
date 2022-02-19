package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Order(3)
public class Second implements CommandLineRunner {

    @Override
    public void run(String... args) {
    	System.out.println("Second");
    }
} 