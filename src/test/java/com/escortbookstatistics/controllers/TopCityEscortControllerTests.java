package com.escortbookstatistics.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.escortbookstatistics.models.TopCityEscort;
import com.escortbookstatistics.repositories.TopCityEscortRepository;

@WebMvcTest(controllers = TopCityEscortController.class)
public class TopCityEscortControllerTests {

    @MockBean
    private TopCityEscortRepository topCityEscortRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(topCityEscortRepository.findTop())
            .thenReturn(new ArrayList<TopCityEscort>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/top-city-escorts"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(topCityEscortRepository, times(1))
            .findTop();
    }
    
}
