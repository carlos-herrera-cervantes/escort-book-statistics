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

import com.escortbookstatistics.models.CustomerStatistic;
import com.escortbookstatistics.repositories.CustomerStatisticRepository;

@WebMvcTest(controllers = CustomerStatisticController.class)
public class CustomerStatisticControllerTests {

    @MockBean
    private CustomerStatisticRepository customerStatisticRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByCustomerShouldReturn404() throws Exception {
        when(customerStatisticRepository
            .groupByCustomer(any(Date.class), any(Date.class), anyString()))
            .thenReturn(null);

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/customer/63b08c633a9ff2171fc9126e")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andReturn();

        verify(customerStatisticRepository, times(1))
            .groupByCustomer(any(Date.class), any(Date.class), anyString());
    }

    @Test
    void findByCustomerShouldReturn200() throws Exception {
        when(customerStatisticRepository
            .groupByCustomer(any(Date.class), any(Date.class), anyString()))
            .thenReturn(new CustomerStatistic());

        mockMvc
            .perform(MockMvcRequestBuilders
            .get("/api/v1/statistics/customer/63b08c633a9ff2171fc9126e")
            .param("from", "2023-01-01")
            .param("to", "2023-01-01"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        verify(customerStatisticRepository, times(1))
            .groupByCustomer(any(Date.class), any(Date.class), anyString());
    }
    
}
