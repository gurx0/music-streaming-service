package com.example.musicstreamingservice.models;

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
    private Long id;

    @Column(name = "name")
    private String name;




    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "artist_tracks",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<TrackModel> tracks = new HashSet<>();

    public void addTrack(TrackModel track) {
        tracks.add(track);
        track.getArtists().add(this); // Добавляем трек к артисту
    }

    public ArtistModel(){}

    public ArtistModel(String name){
        this.name = name;
    }
}
