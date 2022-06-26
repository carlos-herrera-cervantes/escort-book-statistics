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

import com.escortbookstatistics.models.PaymentStatistic;
import com.escortbookstatistics.repositories.PaymentStatisticRepository;

@RestController
@RequestMapping("/api/v1/statistics/payment")
public class PaymentStatisticController {

    @Autowired
    private PaymentStatisticRepository paymentStatisticRepository;
    
    @GetMapping
    public ResponseEntity<List<PaymentStatistic>> findAll(
        @RequestParam(required = true, name = "from")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
        @RequestParam(required = true, name = "to")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        List<PaymentStatistic> statistic = paymentStatisticRepository.groupBy(from, to);
        return new ResponseEntity<List<PaymentStatistic>>(statistic, HttpStatus.OK);
    }

}
