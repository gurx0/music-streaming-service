package com.example.musicstreamingservice.controllers;


import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SiteController {

    private final TrackRepository trackRepository;

    @GetMapping("/")
    public String home(Model model){
        List<TrackModel> track = trackRepository.findAll();
        model.addAttribute("track",track);
        return "home";
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<TrackModel> getTrackById(@PathVariable Long id) {
        return trackRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
