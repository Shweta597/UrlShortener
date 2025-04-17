package com.example.url.controller;
import com.example.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
    
@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public String shorten(@RequestBody String originalUrl) {
        return service.shortenUrl(originalUrl).getShortCode();
    }

    @GetMapping("/s/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}

