package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "general_user_activity")
public class GeneralUserActivity {
    
    @Field("_id")
    String type;

    @Field("active")
    int active;

    @Field("inactive")
    int inactive;

}
