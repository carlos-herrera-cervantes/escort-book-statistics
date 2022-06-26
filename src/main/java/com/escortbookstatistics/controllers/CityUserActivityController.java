package com.escortbookstatistics.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.CityUserActivity;
import com.escortbookstatistics.repositories.CityUserActivityRepository;

@RestController
@RequestMapping("/api/v1/statistics/city-user-activity")
public class CityUserActivityController {

    @Autowired
    private CityUserActivityRepository cityUserActivityRepository;

    @GetMapping
    public ResponseEntity<List<CityUserActivity>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<CityUserActivity> activity = cityUserActivityRepository.groupBy(from, to);
        return new ResponseEntity<List<CityUserActivity>>(activity, HttpStatus.OK);
    }

    @GetMapping("{city}")
    public ResponseEntity<List<CityUserActivity>> findByCity(
        @PathVariable(required = true) String city,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<CityUserActivity> activity = cityUserActivityRepository.groupByCity(from, to, city);
        return new ResponseEntity<List<CityUserActivity>>(activity, HttpStatus.OK);
    }
    
}
