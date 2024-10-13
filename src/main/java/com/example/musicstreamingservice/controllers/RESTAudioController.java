package com.example.musicstreamingservice.controllers;

import com.example.musicstreamingservice.services.MusicService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/audio") // Опционально, вы можете установить базовый путь
public class RESTAudioController {

    private final ResourceLoader resourceLoader;
    private final MusicService musicService;

    // Внедрение сервисов через конструктор
    public RESTAudioController(ResourceLoader resourceLoader, MusicService musicService) {
        this.resourceLoader = resourceLoader;
        this.musicService = musicService;
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getAudioFile(@PathVariable String filename) {
        try {
            Resource resource = resourceLoader.getResource("classpath:static/audio/" + filename);
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add")
    public void addTrack(@RequestBody Map<String, String> requestData) {

        String trackName = requestData.get("trackName");
        String artistName = requestData.get("artistName");
        String album = requestData.get("album");
        Integer duration = Integer.valueOf(requestData.get("duration"));
        String genre = requestData.get("genre");
        String url = requestData.get("url");
        String releaseDate = requestData.get("releaseDate");


        musicService.addTrackAndArtist(trackName, artistName, album, duration, genre, url, releaseDate);
    }

}
