package com.example.footballer_db.footballers;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class footballer_services {

    public footballer_repository footballerRepository;
    private final MongoTemplate mongoTemplate;

    public footballer_services(MongoTemplate mongoTemplate, footballer_repository footballerRepository) {
        this.mongoTemplate = mongoTemplate;
        this.footballerRepository = footballerRepository;
    }

    Optional<Footballer> getFootBallerById(String id) {
        return footballerRepository.findById(id);
    }

    List<Footballer> getAllFootBallers() {
        return footballerRepository.findAll();
    }

    List<Footballer> findByString(String query) {
        return footballerRepository.search(query);
    }

    List<String> findDistinctTeam() {
        return mongoTemplate
                .query(Footballer.class)
                .distinct("team")
                .as(String.class)
                .all();
    }

    List<String> findDistinctNation() {
        return mongoTemplate
                .query(Footballer.class)
                .distinct("nation")
                .as(String.class)
                .all();
    }

    List<String> findDistinctPositions() {
        return mongoTemplate
                .query(Footballer.class)
                .distinct("pos")
                .as(String.class)
                .all();
    }

    void addFootBaller(Footballer body) {
        footballerRepository.insert(body);
    }

    void updateFootBaller(String id, Footballer body) {
        Footballer temp = footballerRepository.findById(id).orElse(null);

        if (temp == null) return;
        body.setId(id);
        footballerRepository.save(body);
    }

    void deleteFootBaller(String id) {
        footballerRepository.deleteById(id);
    }
}
