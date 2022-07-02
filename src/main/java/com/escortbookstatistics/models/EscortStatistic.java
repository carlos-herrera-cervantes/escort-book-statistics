package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "escort_statistic")
public class EscortStatistic {

    @Field("_id")
    String escortId;

    @Field("services_provided")
    int servicesProvided;

    @Field("earned_money")
    long earnedMoney;

    @Field("emitted_claims")
    int emittedClaims;

    @Field("received_claims")
    int receivedClaims;
    
}
