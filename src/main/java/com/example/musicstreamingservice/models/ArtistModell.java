package com.example.musicstreamingservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "ArtistName")
@Entity
public class ArtistModell {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public ArtistModell(){}

    public ArtistModell(String name){
        this.name = name;
    }
}
