package com.example.musicstreamingservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Table(name = "artist")
@Entity
public class ArtistModel {

    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artist_id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "avatar_url")
    @Nullable
    private String avatarUrl;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "artist_tracks",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    @JsonIgnoreProperties("artist")  // Избегаем рекурсивной зависимости
    private Set<TrackModel> tracks = new HashSet<>();

    public void addTrack(TrackModel track) {
        tracks.add(track);
        track.getArtists().add(this); // Добавляем трек к артисту
    }

    public ArtistModel(){}

    public ArtistModel(String artist_name){
        this.artistName = artist_name;
    }
}
