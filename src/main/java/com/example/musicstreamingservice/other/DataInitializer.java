package com.example.musicstreamingservice.other;

import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.SongsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(SongsRepository songsRepository) {
        return args -> {
            songsRepository.save(new TrackModel("Song 1", new Date(), "Artist 1", 100));
            songsRepository.save(new TrackModel("Song 2", new Date(), "Artist 2", 200));
            songsRepository.save(new TrackModel("Song 3", new Date(), "Artist 3", 300));
        };
    }
}
