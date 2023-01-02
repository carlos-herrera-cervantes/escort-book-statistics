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

import com.escortbookstatistics.models.TopEscort;
import com.escortbookstatistics.repositories.TopEscortRepository;

@WebMvcTest(controllers = TopEscortController.class)
public class TopEscortControllerTests {

    @MockBean
    private TopEscortRepository topEscortRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(topEscortRepository.findTop()).thenReturn(new ArrayList<TopEscort>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/top-escorts"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(topEscortRepository, times(1)).findTop();
    }
    
}
