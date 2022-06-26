package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.CityUserActivity;

@Repository
public interface CityUserActivityRepository extends MongoRepository<CityUserActivity, String> {
    
    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: { city: $city, type: $type },"
        + "active: { $sum: $active },"
        + "inactive: { $sum: $inactive }"
        + "}}"
    })
    List<CityUserActivity> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, city: ?2 } }",
        "{ $group: {"
        + "_id: { city: $city, type: $type },"
        + "active: { $sum: $active },"
        + "inactive: { $sum: $inactive }"
        + "}}"
    })
    List<CityUserActivity> groupByCity(Date from, Date to, String city);

}
