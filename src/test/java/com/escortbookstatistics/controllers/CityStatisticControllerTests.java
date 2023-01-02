package com.escortbookstatistics.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.escortbookstatistics.models.CityStatistic;
import com.escortbookstatistics.repositories.CityStatisticRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CityStatisticController.class)
public class CityStatisticControllerTests {

    @MockBean
    private CityStatisticRepository cityStatisticRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(cityStatisticRepository.groupBy(any(Date.class), any(Date.class)))
            .thenReturn(new ArrayList<CityStatistic>());

        MvcResult httpResponse = mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/city")
            .param("from", "2023-01-01")
            .param("to", "2023-01-30"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(cityStatisticRepository, times(1))
            .groupBy(any(Date.class), any(Date.class));

        String stringContent = httpResponse.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<CityStatistic> statistics = mapper.readValue(stringContent, new TypeReference<List<CityStatistic>>(){});

        assertTrue(statistics.isEmpty());
    }

    @Test
    void findByCityShouldReturn404() throws Exception {
        when(cityStatisticRepository.groupByCity(any(Date.class), any(Date.class), anyString()))
            .thenReturn(null);

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/city/quito")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andReturn();

        verify(cityStatisticRepository, times(1))
            .groupByCity(any(Date.class), any(Date.class), anyString());
    }

    @Test
    void findByCityShouldReturn200() throws Exception {
        when(cityStatisticRepository.groupByCity(any(Date.class), any(Date.class), anyString()))
            .thenReturn(new CityStatistic());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/city/quito")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(cityStatisticRepository, times(1))
            .groupByCity(any(Date.class), any(Date.class), anyString());
    }
    
}
