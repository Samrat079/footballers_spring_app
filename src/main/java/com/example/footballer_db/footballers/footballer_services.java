package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class footballer_services {

    @Autowired
    public footballer_repository footballerRepository;

    Optional<Footballer> getFootBallerById(String id) {
        return footballerRepository.findById(id);
    }

    List<Footballer> getAllFootBallers() {
        return footballerRepository.findAll();
    }

    List<Footballer> findByString(String query) {
        return footballerRepository.search(query);
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
