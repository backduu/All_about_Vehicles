package com.packt.vehiclesapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    @GetMapping("/public")
    public String publicEndPoint() {
        return "Anyone can access this!";
    }
}