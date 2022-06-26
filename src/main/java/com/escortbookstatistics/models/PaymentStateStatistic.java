package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "payment_state_statistic")
public class PaymentStateStatistic {

    @Data
    private class PaymentStateStatisticGroup {

        @Field("name")
        String name;

        @Field("state")
        String state;

    }

    @Field("_id")
    PaymentStateStatisticGroup group;

    @Field("services")
    int services;
    
}
