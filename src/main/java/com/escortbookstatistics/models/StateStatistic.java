package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "state_statistic")
public class StateStatistic {
    
    @Field("_id")
    String id;

    @Field("total_customers")
    int totalCustomers;

    @Field("total_escorts")
    int totalEscorts;

    @Field("earnings")
    long earnings;

    @Field("claims")
    int claims;

}
