package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.ArtistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistModel, Long> {
}
