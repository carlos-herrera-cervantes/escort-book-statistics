package com.escortbookstatistics.controllers;

import static org.mockito.Mockito.timeout;
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

import com.escortbookstatistics.models.TopCity;
import com.escortbookstatistics.repositories.TopCityRepository;

@WebMvcTest(controllers = TopCityController.class)
public class TopCityControllerTests {

    @MockBean
    private TopCityRepository topCityRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(topCityRepository.findTop()).thenReturn(new ArrayList<TopCity>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/top-cities"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(topCityRepository, timeout(1)).findTop();
    }
    
}
