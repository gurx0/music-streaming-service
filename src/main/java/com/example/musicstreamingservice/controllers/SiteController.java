package com.example.musicstreamingservice.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class SiteController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/track/{id}")
    public String getSong(){
        return "home";
    }

    @PostMapping("/track/{id}")
    public String postSong(){
        return "redirect:/";
    }

    @GetMapping("/playlist/{id}")
    public String getPlaylist(){
        return "playlist.html";
    }
    @PostMapping("/playlist/{id}")
    public String postPlaylist(){
        return "playlist.html";
    }



}
