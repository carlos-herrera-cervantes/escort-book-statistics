package com.escortbookstatistics.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.GeneralStatistic;

@Repository
public interface GeneralStatisticRepository extends MongoRepository<GeneralStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: null,"
        + "total_customers: { $sum: $total_customers },"
        + "total_escorts: { $sum: $total_escorts },"
        + "earnings: { $sum: $earnings },"
        + "claims: { $sum: $claims }"
        + "}}"
    })
    GeneralStatistic groupBy(Date from, Date to);

}
