package com.escortbookstatistics.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.escortbookstatistics.models.TopState;

@Repository
public interface TopStateRepository extends MongoRepository<TopState, String> {

    @Aggregation(pipeline = {
        "{ $sort: { services: -1 } }",
        "{ $limit: 10 }"
    })
    public List<TopState> findTop();
    
}
