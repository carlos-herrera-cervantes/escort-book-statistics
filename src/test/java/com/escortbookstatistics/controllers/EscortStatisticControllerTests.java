package com.escortbookstatistics.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.escortbookstatistics.models.EscortStatistic;
import com.escortbookstatistics.repositories.EscortStatisticRepository;

@WebMvcTest(controllers = EscortStatisticController.class)
public class EscortStatisticControllerTests {

    @MockBean
    private EscortStatisticRepository escortStatisticRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByEscortShouldReturn404() throws Exception {
        when(escortStatisticRepository
            .groupByEscort(any(Date.class), any(Date.class), anyString()))
            .thenReturn(null);

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/escort/63b093c2f0643ce7268a3ca0")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andReturn();

        verify(escortStatisticRepository, times(1))
            .groupByEscort(any(Date.class), any(Date.class), anyString());
    }

    @Test
    void findByEscortShouldReturn200() throws Exception {
        when(escortStatisticRepository
            .groupByEscort(any(Date.class), any(Date.class), anyString()))
            .thenReturn(new EscortStatistic());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/escort/63b093c2f0643ce7268a3ca0")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(escortStatisticRepository, times(1))
            .groupByEscort(any(Date.class), any(Date.class), anyString());
    }
    
}
