package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrackRepository extends JpaRepository<TrackModel,Long> {
    @Override
    Optional<TrackModel> findById(Long id);

    TrackModel findByName (String name);

    @Query("SELECT t FROM TrackModel t ORDER BY t.id ASC") // или
    List<TrackModel> findAllOrderedById();

}


