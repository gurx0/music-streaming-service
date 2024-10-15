package com.example.musicstreamingservice.controllers;

import com.example.musicstreamingservice.services.TrackService;
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
    private final TrackService trackService;

    // Внедрение сервисов через конструктор
    public RESTAudioController(ResourceLoader resourceLoader, TrackService trackService) {
        this.resourceLoader = resourceLoader;
        this.trackService = trackService;
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
    public ResponseEntity<String> addTrack(@RequestBody Map<String, String> requestData) {
        String track_name = requestData.get("track_name");
        String artist_name = requestData.get("artist_name");
        String album = requestData.get("album");
        Integer duration = Integer.valueOf(requestData.get("duration"));
        String genre = requestData.get("genre");
        String track_url = requestData.get("track_url");
        String releaseDate = requestData.get("releaseDate");

        trackService.addTrackAndArtist(track_name, artist_name, album, duration, genre, track_url, releaseDate);

        return ResponseEntity.ok("Трек добавлен успешно");
    }

}
