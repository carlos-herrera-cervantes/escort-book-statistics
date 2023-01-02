package com.escortbookstatistics.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.escortbookstatistics.models.PaymentCityStatistic;
import com.escortbookstatistics.repositories.PaymentCityStatisticRepository;

@WebMvcTest(controllers = PaymentCityStatisticController.class)
public class PaymentCityStatisticControllerTests {

    @MockBean
    private PaymentCityStatisticRepository paymentCityStatisticRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(paymentCityStatisticRepository
            .groupBy(any(Date.class), any(Date.class)))
            .thenReturn(new ArrayList<PaymentCityStatistic>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/payment-city")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(paymentCityStatisticRepository, times(1))
            .groupBy(any(Date.class), any(Date.class));
    }

    @Test
    void findByCityShouldReturn200() throws Exception {
        when(paymentCityStatisticRepository
            .groupByCity(any(Date.class), any(Date.class), anyString()))
            .thenReturn(new ArrayList<PaymentCityStatistic>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/payment-city/quito")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(paymentCityStatisticRepository, times(1))
            .groupByCity(any(Date.class), any(Date.class), anyString());
    }
    
}
