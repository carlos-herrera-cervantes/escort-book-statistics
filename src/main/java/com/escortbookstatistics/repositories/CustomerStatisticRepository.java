package com.escortbookstatistics.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.CustomerStatistic;

@Repository
public interface CustomerStatisticRepository extends MongoRepository<CustomerStatistic, String> {
    
    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, customer_id: ObjectId(?2) } }",
        "{ $group: {"
        + "_id: $customer_id,"
        + "hired_services: { $sum: $hired_services },"
        + "spent_money: { $sum: $spent_money },"
        + "emitted_claims: { $sum: $emitted_claims },"
        + "received_claims: { $sum: $received_claims }"
        + "}}"
    })
    public CustomerStatistic groupByCustomer(Date from, Date to, String customerId);

}
