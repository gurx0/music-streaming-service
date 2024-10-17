package com.example.musicstreamingservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate; // Используем LocalDate
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track")
public class TrackModel {

    @Id
    @Column(name = "track_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate; //  LocalDate вместо Date

    @Column(name = "playCount", nullable = false)
    private Integer playCount = 0;

    @Column(name = "album", nullable = false)
    private String album;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "photoUrl", nullable = false)
    private String photoUrl;


    @ManyToMany(mappedBy = "tracks" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tracks")
    private Set<ArtistModel> artists = new HashSet<>();

    public synchronized void addArtist(ArtistModel artist) {
        artists.add(artist);
        artist.getTracks().add(this);
    }


    public TrackModel() {}

        public TrackModel(String name, LocalDate releaseDate, Integer playCount, String album, String genre, Integer duration, String url, String photoUrl) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.playCount = playCount;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
        this.url = url;
        this.photoUrl = photoUrl;
    }
}
