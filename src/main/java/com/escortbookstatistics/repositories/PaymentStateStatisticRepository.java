package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.PaymentStateStatistic;

@Repository
public interface PaymentStateStatisticRepository extends MongoRepository<PaymentStateStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: { state: $state, name: $name },"
        + "services: { $sum: $services }"
        + "}}"
    })
    public List<PaymentStateStatistic> groupBy(Date from, Date to);

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, state: ?2 } }",
        "{ $group: {"
        + "_id: { state: $state, name: $name },"
        + "services: { $sum: $services }"
        + "}}"
    })
    public List<PaymentStateStatistic> groupByState(Date from, Date to, String state);
    
}
