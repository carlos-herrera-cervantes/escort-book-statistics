package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.PaymentStatistic;

@Repository
public interface PaymentStatisticRepository extends MongoRepository<PaymentStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: $name,"
        + "services: { $sum: $services }"
        + "}}"
    })
    public List<PaymentStatistic> groupBy(Date from, Date to);
    
}
