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
import org.springframework.web.server.ResponseStatusException;

import com.escortbookstatistics.models.StateStatistic;
import com.escortbookstatistics.repositories.StateStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/state")
public class StateStatisticController {

    @Autowired
    private StateStatisticRepository stateStatisticRepository;

    @GetMapping
    public ResponseEntity<List<StateStatistic>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<StateStatistic> statistics = stateStatisticRepository.groupBy(from, to);
        return new ResponseEntity<List<StateStatistic>>(statistics, HttpStatus.OK);
    }

    @GetMapping("{state}")
    public ResponseEntity<StateStatistic> findByState(
        @PathVariable(required = true) String state,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        StateStatistic statistic = stateStatisticRepository.groupByState(from, to, state);

        if (statistic == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<StateStatistic>(statistic, HttpStatus.OK);
    }
    
}
