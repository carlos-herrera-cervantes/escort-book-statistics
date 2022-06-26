package com.escortbookstatistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.TopCityEscort;
import com.escortbookstatistics.repositories.TopCityEscortRepository;

@RestController
@RequestMapping("/api/v1/statistics/top-city-escorts")
public class TopCityEscortController {

    @Autowired
    private TopCityEscortRepository topCityEscortRepository;

    @GetMapping
    public ResponseEntity<List<TopCityEscort>> findAll() {
        List<TopCityEscort> escorts = topCityEscortRepository.findTop();
        return new ResponseEntity<List<TopCityEscort>>(escorts, HttpStatus.OK);
    }
    
}
