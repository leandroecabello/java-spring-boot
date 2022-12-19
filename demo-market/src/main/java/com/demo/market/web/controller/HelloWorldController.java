package com.demo.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sayHi")
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHi() {
        return "Never stop learning!!";
    }
}
