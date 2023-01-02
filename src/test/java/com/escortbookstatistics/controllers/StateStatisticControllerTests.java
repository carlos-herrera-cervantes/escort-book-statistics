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

import com.escortbookstatistics.models.StateStatistic;
import com.escortbookstatistics.repositories.StateStatisticRepository;

@WebMvcTest(controllers = StateStatisticController.class)
public class StateStatisticControllerTests {

    @MockBean
    private StateStatisticRepository stateStatisticRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllShouldReturn200() throws Exception {
        when(stateStatisticRepository
            .groupBy(any(Date.class), any(Date.class)))
            .thenReturn(new ArrayList<StateStatistic>());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/state")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(stateStatisticRepository, times(1))
            .groupBy(any(Date.class), any(Date.class));
    }

    @Test
    void findByStateShouldReturn404() throws Exception {
        when(stateStatisticRepository
            .groupByState(any(Date.class), any(Date.class), anyString()))
            .thenReturn(null);

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/state/guerrero")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andReturn();

        verify(stateStatisticRepository, times(1))
            .groupByState(any(Date.class), any(Date.class), anyString());
    }

    @Test
    void findByStateShouldReturn200() throws Exception {
        when(stateStatisticRepository
            .groupByState(any(Date.class), any(Date.class), anyString()))
            .thenReturn(new StateStatistic());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/state/guerrero")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(stateStatisticRepository, times(1))
            .groupByState(any(Date.class), any(Date.class), anyString());
    }
    
}
