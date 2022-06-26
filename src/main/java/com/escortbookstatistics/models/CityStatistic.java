package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "city_statistic")
public class CityStatistic {

    @Field("_id")
    String id;
    
    @Field("total_customers")
    int totalCustomers;

    @Field("total_escorts")
    int totalEscorts;

    @Field("earnings")
    long earnings;

}
