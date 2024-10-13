package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.ArtistModel;
import com.example.musicstreamingservice.models.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistModel, Long> {
    List<ArtistModel> findByArtistName(String artistName);}

