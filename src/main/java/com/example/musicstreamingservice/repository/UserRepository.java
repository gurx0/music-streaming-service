package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser,Long>{
    Optional<SiteUser> findByName(String username);
}
