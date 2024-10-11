//package com.example.musicstreamingservice.other;
//
//import com.example.musicstreamingservice.models.TrackModel;
//import com.example.musicstreamingservice.repository.TrackRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class DataInitializer {
//
//    @Bean
//    public CommandLineRunner initData(TrackRepository songsRepository) { //todo доделать логику каждого компонента
//        return args -> {
//            songsRepository.save(new TrackModel("Song 1", new Date(), "Artist 1", 100, "Album 1", "genre 1",100, "track1.mp3"));
//            songsRepository.save(new TrackModel("Song 2", new Date(), "Artist 2", 150, "Album 2", "genre 2", 200, "track2.mp3"));
//            songsRepository.save(new TrackModel("Song 3", new Date(), "Artist 3", 250, "Album 3", "genre 3", 300, "track3.mp3"));
//
//        };
//    }
//}
//
//
