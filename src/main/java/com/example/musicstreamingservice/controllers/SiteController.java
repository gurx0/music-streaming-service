package com.example.musicstreamingservice.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class SiteController {
    @GetMapping("/")
    public String home(){
        return "home.html";
    }
}
