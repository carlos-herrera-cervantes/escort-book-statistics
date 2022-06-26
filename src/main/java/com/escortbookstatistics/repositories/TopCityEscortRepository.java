package com.escortbookstatistics.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.TopCityEscort;

@Repository
public interface TopCityEscortRepository extends MongoRepository<TopCityEscort, String> {

    @Aggregation(pipeline = {
        "{ $sort: { services: -1 } }",
        "{ $limit: 10 }"
    })
    public List<TopCityEscort> findTop();
    
}
