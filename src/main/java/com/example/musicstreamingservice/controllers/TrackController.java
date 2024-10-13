package com.example.musicstreamingservice.controllers;


import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class TrackController {

    private final TrackRepository trackRepository;
    private final ResourceLoader resourceLoader;

    @GetMapping("/")
    public String home(Model model){
        List<TrackModel> track = trackRepository.findAllOrderedById(); // Измените на новый метод
        model.addAttribute("track", track);
        return "home";
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<TrackModel> getTrackById(@PathVariable Long trackId) {
        return trackRepository.findById(trackId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/track/{trackId}")
    public String postSong(){
        return "redirect:/";
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<Object> deleteTrack(@PathVariable Long trackId) {
        return trackRepository.findById(trackId)
                .map(track -> {
                    trackRepository.delete(track);
                    return ResponseEntity.<Void>ok().build();  // Явное указание типа Void
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/track/{trackId}/increment-play-count")
    public ResponseEntity<Object> incrementPlayCount(@PathVariable Long trackId) {
        return trackRepository.findById(trackId)
                .map(track -> {
                    track.setPlayCount(track.getPlayCount() + 1); // Увеличиваем счетчик
                    trackRepository.save(track); // Сохраняем изменения
                    return ResponseEntity.ok().build(); // Возвращаем 200 OK
                })
                .orElse(ResponseEntity.notFound().build()); // Если трек не найден, возвращаем 404
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



}
