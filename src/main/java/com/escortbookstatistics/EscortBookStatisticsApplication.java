package com.escortbookstatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EscortBookStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscortBookStatisticsApplication.class, args);
	}

}
