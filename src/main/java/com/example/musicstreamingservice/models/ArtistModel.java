package com.example.musicstreamingservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "ArtistName")
@Entity
public class ArtistModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public ArtistModel(){}

    public ArtistModel(String name){
        this.name = name;
    }
}
