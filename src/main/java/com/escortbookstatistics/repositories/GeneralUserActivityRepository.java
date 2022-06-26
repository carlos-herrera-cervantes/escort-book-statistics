package com.escortbookstatistics.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.GeneralUserActivity;

@Repository
public interface GeneralUserActivityRepository extends MongoRepository<GeneralUserActivity, String> {

    @Aggregation(pipeline = {
        "{ $match: { created_at: { $gte: ?0, $lte: ?1 } } }",
        "{ $group: {"
        + "_id: $type,"
        + "active: { $sum: $active },"
        + "inactive: { $sum: $inactive }"
        + "}}"
    })
    public List<GeneralUserActivity> groupBy(Date from, Date to);
    
}
