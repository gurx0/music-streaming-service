package com.example.musicstreamingservice.controllers;

import com.example.musicstreamingservice.models.ArtistModel;
import com.example.musicstreamingservice.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/artist/{id}")
    public String getArtistPage(@PathVariable Long id, Model model) {
        ArtistModel artist = artistService.findArtistById(id);
        model.addAttribute("artist", artist);
        return "artist-page";
    }

    // Метод для добавления нового артиста
    @PostMapping // Обрабатывает POST-запросы
    public ResponseEntity<ArtistModel> createArtist(@RequestBody ArtistModel artist) {
        ArtistModel newArtist = artistService.saveArtist(artist); // Сохраняем артиста через сервис
        return ResponseEntity.status(HttpStatus.CREATED).body(newArtist); // Возвращаем 201 статус и сохраненного артиста
    }
}
