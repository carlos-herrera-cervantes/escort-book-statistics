package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.StateStatistic;

@Repository
public interface StateStatisticRepository extends MongoRepository<StateStatistic, String> {
    
    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: $state,"
        + "total_customers: { $sum: $total_customers },"
        + "total_escorts: { $sum: $total_escorts },"
        + "earnings: { $sum: $earnings },"
        + "claims: { $sum: $claims }"
        + "}}"
    })
    List<StateStatistic> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, state: ?2 } }",
        "{ $group: {"
        + "_id: $state,"
        + "total_customers: { $sum: $total_customers },"
        + "total_escorts: { $sum: $total_escorts },"
        + "earnings: { $sum: $earnings },"
        + "claims: { $sum: $claims }"
        + "}}"
    })
    StateStatistic groupByState(Date from, Date to, String state);

}
