package com.escortbookstatistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.TopStateEscort;
import com.escortbookstatistics.repositories.TopStateEscortRepository;

@RestController
@RequestMapping("/api/v1/statistics/top-state-escorts")
public class TopStateEscortController {

    @Autowired
    private TopStateEscortRepository topStateEscortRepository;

    @GetMapping
    public ResponseEntity<List<TopStateEscort>> findAll() {
        List<TopStateEscort> escorts = topStateEscortRepository.findTop();
        return new ResponseEntity<List<TopStateEscort>>(escorts, HttpStatus.OK);
    }
    
}
