package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<TrackModel,Long> {
    @Override
    Optional<TrackModel> findById(Long id);

    Optional<TrackModel> findByName (String name);
}
