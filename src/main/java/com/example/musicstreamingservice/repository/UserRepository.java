package com.example.musicstreamingservice.repository;

import com.example.musicstreamingservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);  // Измените 'name' на 'username'

    Optional<UserModel> findById(Long id);
}