package com.escortbookstatistics.controllers;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.escortbookstatistics.models.CityStatistic;
import com.escortbookstatistics.repositories.CityStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/city")
public class CityStatisticController {

    @Autowired
    private CityStatisticRepository cityStatisticRepository;

    @GetMapping
    public ResponseEntity<List<CityStatistic>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<CityStatistic> statistics = cityStatisticRepository.groupBy(from, to);
        return new ResponseEntity<List<CityStatistic>>(statistics, HttpStatus.OK);
    }

    @GetMapping("{city}")
    public ResponseEntity<CityStatistic> findByCity(
        @PathVariable(required = true) String city,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        CityStatistic statistics = cityStatisticRepository.groupByCity(from, to, city);

        if (statistics == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CityStatistic>(statistics, HttpStatus.OK);
    }
    
}
