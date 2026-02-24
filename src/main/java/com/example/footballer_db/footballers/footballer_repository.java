package com.example.footballer_db.footballers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface footballer_repository extends MongoRepository<Footballer, String> {
    @Query("{ 'Player' : { $regex: ?0, $options: 'i' } }")
    List<Footballer> searchByName(String Player);
}
