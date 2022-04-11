package com.santander.banco811.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health-check")
    public String heathCheck(){
        return "Servidor rodando!!";
    }
}
