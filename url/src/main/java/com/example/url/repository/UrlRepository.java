package com.example.url.repository;
import java.util.Optional;

import com.example.url.model.ShortUrl;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<ShortUrl, Long> {
    // Custom query methods can be defined here if needed.
    Optional<ShortUrl> findByShortCode(String shortCode); 
}
