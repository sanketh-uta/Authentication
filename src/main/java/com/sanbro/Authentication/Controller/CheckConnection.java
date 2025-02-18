package com.sanbro.Authentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class CheckConnection {
    @GetMapping("/check")
    public String healthCheck(){
        return "200:ok";
    }
}
