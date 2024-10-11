package com.example.musicstreamingservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "track")
public class TrackModel {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "artist" , nullable = false)
    private String artist;

    @Column(name = "release"  , nullable = false)
    private Date release;

    @Column(name = "playCount"  , nullable = false)
    private Integer playCount;

    @Column(name = "album"  , nullable = false)
    private String album;

    @Column(name = "duration"  , nullable = false)
    private Integer duration;

    @Column(name = "genre"  , nullable = false)
    private String genre;

    @Column(name = "url"  , nullable = false)
    private String url;

    public TrackModel(){}

    public TrackModel(String name, Date release,String artist, Integer playCount, String album, String genre, Integer duration, String url){
        this.name = name;
        this.release = release;
        this.artist = artist;
        this.playCount = playCount;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
        this.url = url;
    }

}
