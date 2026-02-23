package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class footballer_services {

    @Autowired
    public footballer_repository footballerRepository;

    footballer getFootBallerById(String id) {
        return footballerRepository.findById(id).orElse(null);
    }

    List<footballer> getAllFootBallers() {
        return footballerRepository.findAll();
    }

    List<footballer> searchByName(String Player) {
        return footballerRepository.searchByName(Player);
    }

    void addFootBaller(footballer body) {
        footballerRepository.insert(body);
    }

    void updateFootBaller(String id, footballer body) {
        footballer temp = footballerRepository.findById(id).orElse(null);

        if (temp == null) return;
        body.setId(id);
        footballerRepository.save(body);
    }

    void deleteFootBaller(String id) {
        footballerRepository.deleteById(id);
    }
}
