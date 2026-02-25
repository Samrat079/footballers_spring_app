package com.example.footballer_db.footballers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface footballer_repository extends MongoRepository<Footballer, String> {
//    List<Footballer> findByPlayer(String player);
//    List<Footballer> findByPlayerContaining(String player);
    List<Footballer> findByPlayerContainingIgnoreCase(String player);

//    List<Footballer> findByTeamContainingIgnoreCase(String team);
}
