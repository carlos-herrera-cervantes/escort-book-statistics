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

import com.escortbookstatistics.models.PaymentStateStatistic;
import com.escortbookstatistics.repositories.PaymentStateStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/payment-state")
public class PaymentStateStatisticController {

    @Autowired
    private PaymentStateStatisticRepository paymentStateStatisticRepository;

    @GetMapping
    public ResponseEntity<List<PaymentStateStatistic>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<PaymentStateStatistic> statistic = paymentStateStatisticRepository.groupBy(from, to);
        return new ResponseEntity<List<PaymentStateStatistic>>(statistic, HttpStatus.OK);
    }

    @GetMapping("{state}")
    public ResponseEntity<List<PaymentStateStatistic>> findByState(
        @PathVariable(required = true) String state,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<PaymentStateStatistic> statistic = paymentStateStatisticRepository.groupByState(from, to, state);
        return new ResponseEntity<List<PaymentStateStatistic>>(statistic, HttpStatus.OK);
    }
    
}
