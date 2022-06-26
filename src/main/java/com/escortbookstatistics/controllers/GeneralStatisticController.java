package com.escortbookstatistics.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.GeneralStatistic;
import com.escortbookstatistics.repositories.GeneralStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/general")
public class GeneralStatisticController {
    
    @Autowired
    private GeneralStatisticRepository generalStatisticRepository;

    @GetMapping
    public ResponseEntity<GeneralStatistic> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        GeneralStatistic statistics = generalStatisticRepository.groupBy(from, to);
        return new ResponseEntity<GeneralStatistic>(statistics, HttpStatus.OK);
    }

}
