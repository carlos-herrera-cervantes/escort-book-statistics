package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "payment_city_statistic")
public class PaymentCityStatistic {

    @Data
    private class PaymentCityStatisticGroup {

        @Field("name")
        String name;

        @Field("city")
        String city;

    }

    @Field("_id")
    PaymentCityStatisticGroup group;

    @Field("services")
    int services;
    
}
