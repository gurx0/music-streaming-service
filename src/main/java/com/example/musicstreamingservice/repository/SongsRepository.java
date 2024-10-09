package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.MusicModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongsRepository extends JpaRepository<MusicModel,Long> {
    @Override
    Optional<MusicModel> findById(Long id);

    Optional<MusicModel> findByName (String name);
}
