package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "customer_statistic")
public class CustomerStatistic {
    
    @Field("_id")
    String customerId;

    @Field("hired_services")
    int hiredServices;

    @Field("spent_money")
    long spentMoney;

}
