package com.escortbookstatistics.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "top_city_escort")
public class TopCityEscort {

    @Field("escort_id")
    String escortId;

    @Field("name")
    String name;

    @Field("city")
    String city;

    @Field("state")
    String state;

    @Field("services")
    int services;

    @Field("created_at")
    LocalDateTime createdAt;
    
}
