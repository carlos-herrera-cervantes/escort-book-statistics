package com.escortbookstatistics.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "top_city")
public class TopCity {

    @Field("name")
    String name;

    @Field("state")
    String state;

    @Field("services")
    int services;

    @Field("created_at")
    LocalDateTime createdAt;
    
}
