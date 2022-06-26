package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.PaymentCityStatistic;

@Repository
public interface PaymentCityStatisticRepository extends MongoRepository<PaymentCityStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: { city: $city, name: $name },"
        + "services: { $sum: $services }"
        + "}}"
    })
    public List<PaymentCityStatistic> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, city: ?2 } }",
        "{ $group: {"
        + "_id: { city: $city, name: $name },"
        + "services: { $sum: $services }"
        + "}}"
    })
    public List<PaymentCityStatistic> groupByCity(Date from, Date to, String city);

}
