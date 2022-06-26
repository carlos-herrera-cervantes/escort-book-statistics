package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "general_statistic")
public class GeneralStatistic {

    @Field("total_customers")
    int totalCustomers;

    @Field("total_escorts")
    int totalEscorts;

    @Field("earnings")
    long earnings;

}
