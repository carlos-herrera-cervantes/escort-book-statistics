package com.escortbookstatistics.controllers;

import static org.mockito.ArgumentMatchers.any;
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

import com.escortbookstatistics.models.GeneralUserActivity;
import com.escortbookstatistics.repositories.GeneralUserActivityRepository;

@WebMvcTest(controllers = GeneralUserActivityController.class)
public class GeneralUserActivityControllerTests {

    @MockBean
    private GeneralUserActivityRepository generalUserActivityRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(generalUserActivityRepository
            .groupBy(any(Date.class), any(Date.class)))
            .thenReturn(new ArrayList<GeneralUserActivity>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/general-user-activity")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(generalUserActivityRepository, times(1))
            .groupBy(any(Date.class), any(Date.class));
    }
    
}
