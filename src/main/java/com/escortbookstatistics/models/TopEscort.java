package com.escortbookstatistics.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "top_escort")
public class TopEscort {

    @Field("escort_id")
    String escortId;

    @Field("name")
    String name;

    @Field("services")
    int services;

    @Field("created_at")
    LocalDateTime createdAt;
    
}
