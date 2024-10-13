package com.example.musicstreamingservice.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@Table(name = "playlist")
public class PlaylistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlist_id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;





    @ManyToMany
    @JoinTable(
            name = "playlist_tracks",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<TrackModel> tracks = new HashSet<>();




    public PlaylistModel(){};

    public PlaylistModel(String name, UserModel user){
        this.name = name;
        this.user = user;
    }
}
