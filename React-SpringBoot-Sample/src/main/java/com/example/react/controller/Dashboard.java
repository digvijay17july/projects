package com.example.react.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @project React-SpringBoot-Sample
 * @author Digvijay Singh
 */
@Controller
public class Dashboard {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
