package com.escortbookstatistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.TopEscort;
import com.escortbookstatistics.repositories.TopEscortRepository;

@RestController
@RequestMapping("/api/v1/statistics/top-escorts")
public class TopEscortController {

    @Autowired
    private TopEscortRepository topEscortRepository;

    @GetMapping
    public ResponseEntity<List<TopEscort>> findAll() {
        List<TopEscort> escorts = topEscortRepository.findTop();
        return new ResponseEntity<List<TopEscort>>(escorts, HttpStatus.OK);
    }
    
}
