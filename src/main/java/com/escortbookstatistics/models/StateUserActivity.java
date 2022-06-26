package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "state_user_activity")
public class StateUserActivity {

    @Data
    private class StateUserActivityGroup {

        @Field("state")
        String state;

        @Field("type")
        String type;

    }

    @Field("_id")
    StateUserActivityGroup group;

    @Field("active")
    int active;

    @Field("inactive")
    int inactive;

}
