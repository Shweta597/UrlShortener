package com.example.url.controller;

import com.example.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.url.model.*;

import java.net.URI;

@Controller
public class PageController {

    @Autowired
    private UrlService service;

    @GetMapping("/")
    public String home() {
        return "index";  // This is the template that will be displayed on the home page
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String originalUrl, Model model) {
        ShortUrl shortUrl = service.shortenUrl(originalUrl);
        model.addAttribute("shortUrl", shortUrl.getShortCode()); // Add short URL to the model
        return "index"; // Redirect back to index page
    }

    // Redirect request handler for shortened URLs
    @GetMapping("/s/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code); // Get the original URL from the service
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));  // Set the Location header to original URL
        return new ResponseEntity<>(headers, HttpStatus.FOUND);  // Return the HTTP status 302 with headers
    }
}
