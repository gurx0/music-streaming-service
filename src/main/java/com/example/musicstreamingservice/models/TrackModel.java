package com.example.musicstreamingservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "track")
public class TrackModel {

    @Id
    @Column(name = "track_id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long track_id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "releaseDate"  , nullable = false)
    private Date releaseDate;

    @Column(name = "playCount"  , nullable = false)
    private Integer playCount = 0;

    @Column(name = "album"  , nullable = false)
    private String album;

    @Column(name = "duration"  , nullable = false)
    private Integer duration;

    @Column(name = "genre"  , nullable = false)
    private String genre;

    @Column(name = "url"  , nullable = false)
    private String url;





    @ManyToMany(mappedBy = "tracks")
    private Set<ArtistModel> artists = new HashSet<>();

    public void addArtist(ArtistModel artist) {
        artists.add(artist);
        artist.getTracks().add(this); // Добавляем артиста к треку
    }





    public TrackModel(){}

    public TrackModel(String name, Date releaseDate, Integer playCount, String album, String genre, Integer duration, String url){
        this.name = name;
        this.releaseDate = releaseDate;
        this.playCount = playCount;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
        this.url = url;
    }

}
