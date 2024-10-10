package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long>{
    Optional<UserModel> findByName(String username);
}
