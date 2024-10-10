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
    private Date date;

    @Column(name = "views"  , nullable = false)
    private Integer views;

    public TrackModel(){}

    public TrackModel(String name, Date date,String artist, Integer views){
        this.name = name;
        this.date = date;
        this.artist = artist;
        this.views = views;
    }

}
