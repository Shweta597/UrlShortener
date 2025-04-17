package com.example.url.service; // Adjust this to your actual package name

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.url.repository.*;
import com.example.url.model.*;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public ShortUrl shortenUrl(String originalUrl) {
        String code = generateShortCode();
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(code);
        return repository.save(shortUrl);
    }

    public String getOriginalUrl(String shortCode) {
        ShortUrl shortUrl = repository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException("Not found"));
        shortUrl.setVisitCount(shortUrl.getVisitCount() + 1);
        repository.save(shortUrl);
        return shortUrl.getOriginalUrl();
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
