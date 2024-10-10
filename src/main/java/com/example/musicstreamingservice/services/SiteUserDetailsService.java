package com.example.musicstreamingservice.services;

import com.example.musicstreamingservice.config.SiteUserDetails;
import com.example.musicstreamingservice.models.UserModel;
import com.example.musicstreamingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SiteUserDetailsService implements UserDetailsService  {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = repository.findByName(username);
        return user.map(SiteUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
