package com.example.musicstreamingservice.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Role;



    //связи
    @ManyToMany
    @JoinTable(
            name = "user_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<TrackModel> likedTracks = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<PlaylistModel> playlists = new ArrayList<>();






    public UserModel(){}

    public UserModel(String username,String password, String Email){
        this.username = username;
        this.password = password;
        this.Email = Email;
    }
}

