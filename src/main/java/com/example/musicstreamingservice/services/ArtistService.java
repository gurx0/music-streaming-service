package com.example.musicstreamingservice.services;

import com.example.musicstreamingservice.other.ResourceNotFoundException; // Импортируйте ваш класс исключения
import com.example.musicstreamingservice.models.ArtistModel; // Импортируйте правильный класс
import com.example.musicstreamingservice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public ArtistModel findArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Артист не найден"));
    }

    public ArtistModel saveArtist(ArtistModel artist) {
        return artistRepository.save(artist);
    }

}
