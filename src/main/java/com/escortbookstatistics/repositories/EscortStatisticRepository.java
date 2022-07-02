package com.escortbookstatistics.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.EscortStatistic;

@Repository
public interface EscortStatisticRepository extends MongoRepository<EscortStatistic, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 }, escort_id: ObjectId(?2) } }",
        "{ $group: {"
        + "_id: $escort_id,"
        + "services_provided: { $sum: $services_provided },"
        + "earned_money: { $sum: $earned_money },"
        + "emitted_claims: { $sum: $emitted_claims },"
        + "received_claims: { $sum: $received_claims }"
        + "}}"
    })
    public EscortStatistic groupByEscort(Date from, Date to, String escortId);
    
}
