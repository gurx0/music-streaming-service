package com.example.musicstreamingservice.controllers;


import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.SongsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SiteController {

    private final SongsRepository songsRepository;

    @GetMapping("/")
    public String home(Model model){
        List<TrackModel> track = songsRepository.findAll();
        model.addAttribute("track",track);
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
