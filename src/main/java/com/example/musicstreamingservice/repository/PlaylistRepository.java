package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.PlaylistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistModel, Long> {
}
