package com.example.musicstreamingservice.services;

import com.example.musicstreamingservice.models.ArtistModel;
import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.ArtistRepository;
import com.example.musicstreamingservice.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class MusicService {

    private final ArtistRepository artistRepository;  // ваш репозиторий для артистов
    private final TrackRepository trackRepository;    // ваш репозиторий для треков

    public MusicService(ArtistRepository artistRepository, TrackRepository trackRepository) {
        this.artistRepository = artistRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public void addTrackAndArtist(String trackName, String artistName, String album, Integer duration, String genre, String url, String releaseDate) {
        // Создаем новый трек
        TrackModel track = new TrackModel();
        track.setName(trackName);
        track.setAlbum(album);
        track.setDuration(duration);
        track.setGenre(genre);
        track.setUrl(url);
        track.setReleaseDate(Date.valueOf(releaseDate)); // Преобразуем строку в Date


        // Устанавливаем другие поля трека, если необходимо...

        // Создаем нового артиста
        ArtistModel artist = new ArtistModel();
        artist.setName(artistName);
        // Устанавливаем другие поля артиста, если необходимо...

        // Добавляем связь между треком и артистом
        artist.addTrack(track);

        // Сохраняем артиста, что автоматически сохранит и трек благодаря каскадному сохранению
        artistRepository.save(artist);
    }

}

