package com.escortbookstatistics.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "city_user_activity")
public class CityUserActivity {

    @Data
    private class CityUserActivityGroup {

        @Field("city")
        String city;

        @Field("type")
        String type;
    }

    @Field("_id")
    CityUserActivityGroup group;

    @Field("active")
    int active;

    @Field("inactive")
    int inactive;

}
