package com.escortbookstatistics.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escortbookstatistics.models.GeneralUserActivity;
import com.escortbookstatistics.repositories.GeneralUserActivityRepository;

@RestController
@RequestMapping("/api/v1/statistics/general-user-activity")
public class GeneralUserActivityController {

    @Autowired
    private GeneralUserActivityRepository generalUserActivityRepository;

    @GetMapping
    public ResponseEntity<List<GeneralUserActivity>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<GeneralUserActivity> activity = generalUserActivityRepository.groupBy(from, to);
        return new ResponseEntity<List<GeneralUserActivity>>(activity, HttpStatus.OK);
    }
    
}
