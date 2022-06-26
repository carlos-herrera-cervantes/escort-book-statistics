package com.escortbookstatistics.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "top_state")
public class TopState {

    @Field("name")
    String name;

    @Field("services")
    int services;

    @Field("created_at")
    LocalDateTime createdAt;
    
}
