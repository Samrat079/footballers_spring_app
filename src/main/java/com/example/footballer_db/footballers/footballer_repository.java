package com.example.footballer_db.footballers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface footballer_repository extends MongoRepository<footballer, String> {
    @Query("{ $text: { $search: ?0 } }")
    List<footballer> searchByName(String Player);
}
