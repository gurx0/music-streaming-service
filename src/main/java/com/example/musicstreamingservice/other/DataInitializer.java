//package com.example.musicstreamingservice.other;
//
//import com.example.musicstreamingservice.models.ArtistModel;
//import com.example.musicstreamingservice.models.TrackModel;
//import com.example.musicstreamingservice.repository.ArtistRepository;
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
//    public CommandLineRunner initData(TrackRepository trackRepository, ArtistRepository artistRepository) { //todo доделать логику каждого компонента
//        return args -> {
//            trackRepository.save(new TrackModel("Song 1", new Date(), 0 , "album 1", "genre", 100,"track1.mp3" ));
//            trackRepository.save(new TrackModel("Song 2", new Date(), 0 , "album 2", "genre", 200,"track2.mp3" ));
//            trackRepository.save(new TrackModel("Song 3", new Date(), 0 , "album 3", "genre", 300,"track3.mp3" ));
//
//            artistRepository.save(new ArtistModel("artist 1"));
//            artistRepository.save(new ArtistModel("artist 2"));
//            artistRepository.save(new ArtistModel("artist 3"));
//        };
//    }
//
//}
//
//
