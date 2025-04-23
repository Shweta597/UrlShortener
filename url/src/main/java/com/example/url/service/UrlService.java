package com.example.url.service;

import com.example.url.model.ShortUrl;
import com.example.url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public ShortUrl shortenUrl(String originalUrl) {
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(generateShortCode());
       
        return repository.save(shortUrl);
    }

    public String getOriginalUrl(String shortCode) {
        ShortUrl shortUrl = repository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException("Short URL not found"));
        shortUrl.setVisitCount(shortUrl.getVisitCount() + 1);
        repository.save(shortUrl);

        return shortUrl.getOriginalUrl();
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
