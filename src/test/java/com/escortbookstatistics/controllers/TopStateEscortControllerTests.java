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

import com.escortbookstatistics.models.TopStateEscort;
import com.escortbookstatistics.repositories.TopStateEscortRepository;

@WebMvcTest(controllers = TopStateEscortController.class)
public class TopStateEscortControllerTests {

    @MockBean
    private TopStateEscortRepository topStateEscortRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(topStateEscortRepository.findTop()).thenReturn(new ArrayList<TopStateEscort>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/top-state-escorts"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(topStateEscortRepository, times(1)).findTop();
    }
    
}
