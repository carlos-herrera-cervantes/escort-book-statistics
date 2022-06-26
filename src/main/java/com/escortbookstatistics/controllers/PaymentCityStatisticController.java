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

import com.escortbookstatistics.models.PaymentCityStatistic;
import com.escortbookstatistics.repositories.PaymentCityStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/payment-city")
public class PaymentCityStatisticController {

    @Autowired
    private PaymentCityStatisticRepository paymentCityStatisticRepository;

    @GetMapping
    public ResponseEntity<List<PaymentCityStatistic>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<PaymentCityStatistic> statistic = paymentCityStatisticRepository.groupBy(from, to);
        return new ResponseEntity<List<PaymentCityStatistic>>(statistic, HttpStatus.OK);
    }

    @GetMapping("{city}")
    public ResponseEntity<List<PaymentCityStatistic>> findByCity(
        @PathVariable(required = true) String city,
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<PaymentCityStatistic> statistic = paymentCityStatisticRepository.groupByCity(from, to, city);
        return new ResponseEntity<List<PaymentCityStatistic>>(statistic, HttpStatus.OK);
    }
    
}
