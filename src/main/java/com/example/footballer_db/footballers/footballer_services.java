package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class footballer_services {

    @Autowired
    public footballer_repository footballerRepository;

    Footballer getFootBallerById(String id) {
        return footballerRepository.findById(id).orElse(null);
    }

    List<Footballer> getAllFootBallers() {
        return footballerRepository.findAll();
    }

    List<Footballer> searchByName(String Player) {
        return footballerRepository.searchByName(Player);
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
