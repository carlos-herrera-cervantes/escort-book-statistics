package com.escortbookstatistics.controllers;

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

import com.escortbookstatistics.models.EscortStatistic;
import com.escortbookstatistics.repositories.EscortStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/escort")
public class EscortStatisticController {

    @Autowired
    private EscortStatisticRepository escortStatisticRepository;

    @GetMapping("{id}")
    public ResponseEntity<EscortStatistic> findByEscort(
        @PathVariable(required = true) String id,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        EscortStatistic statitic = escortStatisticRepository.groupByEscort(from, to, id);

        if (statitic == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EscortStatistic>(statitic, HttpStatus.OK);
    }
    
}
