package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping({ "/hello", "/hw", "/hola" })
    public String helloWorld() {
        return "Hello World";
    }

}
