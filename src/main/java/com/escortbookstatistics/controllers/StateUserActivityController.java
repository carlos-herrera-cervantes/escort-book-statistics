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

import com.escortbookstatistics.models.StateUserActivity;
import com.escortbookstatistics.repositories.StateUserActivityRepository;

@RestController
@RequestMapping("/api/v1/statistics/state-user-activity")
public class StateUserActivityController {
    
    @Autowired
    private StateUserActivityRepository stateUserActivityRepository;

    @GetMapping
    public ResponseEntity<List<StateUserActivity>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<StateUserActivity> activity = stateUserActivityRepository.groupBy(from, to);
        return new ResponseEntity<List<StateUserActivity>>(activity, HttpStatus.OK);
    }

    @GetMapping("{state}")
    public ResponseEntity<List<StateUserActivity>> findByState(
        @PathVariable(required = true) String state,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<StateUserActivity> activity = stateUserActivityRepository.groupByCity(from, to, state);
        return new ResponseEntity<List<StateUserActivity>>(activity, HttpStatus.OK);
    }

}
