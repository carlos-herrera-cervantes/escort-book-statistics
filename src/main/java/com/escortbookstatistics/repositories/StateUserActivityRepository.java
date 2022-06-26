package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.StateUserActivity;

@Repository
public interface StateUserActivityRepository extends MongoRepository<StateUserActivity, String> {
    
    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: { state: $state, type: $type },"
        + "active: { $sum: $active },"
        + "inactive: { $sum: $inactive }"
        + "}}"
    })
    List<StateUserActivity> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, state: ?2 } }",
        "{ $group: {"
        + "_id: { state: $state, type: $type },"
        + "active: { $sum: $active },"
        + "inactive: { $sum: $inactive }"
        + "}}"
    })
    List<StateUserActivity> groupByCity(Date from, Date to, String state);

}
