package com.escortbookstatistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.TopCity;
import com.escortbookstatistics.repositories.TopCityRepository;

@RestController
@RequestMapping("/api/v1/statistics/top-cities")
public class TopCityController {

    @Autowired
    private TopCityRepository topCityRepository;

    @GetMapping
    public ResponseEntity<List<TopCity>> findAll() {
        List<TopCity> cities = topCityRepository.findTop();
        return new ResponseEntity<List<TopCity>>(cities, HttpStatus.OK);
    }
    
}
