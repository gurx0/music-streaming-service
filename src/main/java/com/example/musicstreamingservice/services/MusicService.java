package com.example.musicstreamingservice.services;

import com.example.musicstreamingservice.models.ArtistModel;
import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.ArtistRepository;
import com.example.musicstreamingservice.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate; // Импортируем LocalDate
import java.util.List;

@Service
public class MusicService {

    private final ArtistRepository artistRepository;  // ваш репозиторий для артистов
    private final TrackRepository trackRepository;    // ваш репозиторий для треков

    public MusicService(ArtistRepository artistRepository, TrackRepository trackRepository) {
        this.artistRepository = artistRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public void addTrackAndArtist(String track_name, String artist_name, String album, Integer duration, String genre, String url, String releaseDate) {

        // Создаем новый трек
        TrackModel track = new TrackModel();
        track.setName(track_name);
        track.setAlbum(album);
        track.setDuration(duration);
        track.setGenre(genre);
        track.setUrl(url);

        // Преобразуем строку в LocalDate
        LocalDate localReleaseDate = LocalDate.parse(releaseDate);
        track.setReleaseDate(localReleaseDate);

        // Пытаемся найти существующих артистов
        List<ArtistModel> artists = artistRepository.findByArtistName(artist_name);
        if (artists.isEmpty()) {
            // Если артистов нет, создаем нового
            ArtistModel newArtist = new ArtistModel();
            newArtist.setArtistName(artist_name);
            artistRepository.save(newArtist); // Сохраняем нового артиста
            newArtist.addTrack(track); // Добавляем трек новому артисту
        } else {
            // Если артисты найдены, добавляем трек к каждому из них
            for (ArtistModel artist : artists) {
                artist.addTrack(track); // Добавляем трек к существующему артисту
                artistRepository.save(artist); // Сохраняем изменения для артиста
            }
        }

        // Сохраняем трек, если это необходимо
        trackRepository.save(track);
    }


}
