package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "payment_statistic")
public class PaymentStatistic {

    @Field("_id")
    String name;

    @Field("services")
    int services;
    
}
