package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.CityStatistic;

@Repository
public interface CityStatisticRepository extends MongoRepository<CityStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: $city,"
        + "total_customers: { $sum: $total_customers },"
        + "total_escorts: { $sum: $total_escorts },"
        + "earnings: { $sum: $earnings },"
        + "}}"
    })
    List<CityStatistic> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, city: ?2 } }",
        "{ $group: {"
        + "_id: $city,"
        + "total_customers: { $sum: $total_customers },"
        + "total_escorts: { $sum: $total_escorts },"
        + "earnings: { $sum: $earnings },"
        + "}}"
    })
    CityStatistic groupByCity(Date from, Date to, String city);

}
