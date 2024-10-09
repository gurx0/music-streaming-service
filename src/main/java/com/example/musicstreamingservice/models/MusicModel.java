package com.example.musicstreamingservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "music")
public class MusicModel {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "release"  , nullable = false)
    private Date date;

    @Column(name = "views"  , nullable = false)
    private Integer views;

    public MusicModel(){}

    public MusicModel(String name, Date date, Integer views){
        this.name = name;
        this.date = date;
        this.views = views;
    }

}
