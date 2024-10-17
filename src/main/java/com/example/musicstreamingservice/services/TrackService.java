package com.example.musicstreamingservice.services;

import com.example.musicstreamingservice.models.ArtistModel;
import com.example.musicstreamingservice.models.TrackModel;
import com.example.musicstreamingservice.repository.ArtistRepository;
import com.example.musicstreamingservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate; // Импортируем LocalDate
import java.util.List;
@Service
public class TrackService {

    private final ArtistRepository artistRepository;
    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(ArtistRepository artistRepository, TrackRepository trackRepository) {
        this.artistRepository = artistRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public void addTrackAndArtist(String trackName, String artistName,
                                  String album, Integer duration,
                                  String genre, String url,
                                  String releaseDate, String photoUrl) {
        // новый трек
        TrackModel track = new TrackModel();
        track.setName(trackName);
        track.setAlbum(album);
        track.setDuration(duration);
        track.setGenre(genre);
        track.setUrl(url);
        track.setPhotoUrl(photoUrl);

        LocalDate localReleaseDate = LocalDate.parse(releaseDate);
        track.setReleaseDate(localReleaseDate);

        List<ArtistModel> artists = artistRepository.findByArtistName(artistName);
        ArtistModel artist;

        if (artists.isEmpty()) {
            artist = new ArtistModel();
            artist.setArtistName(artistName);
            artistRepository.save(artist);
        } else {
            artist = artists.get(0);
        }

        artist.addTrack(track);
        trackRepository.save(track);
    }
}

