package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        List<Footballer> temp = footballerRepository.findAll();
        Collections.shuffle(temp);
        return temp;
    }

    List<Footballer> findByPlayer(String player) {
        return footballerRepository.findByPlayerContainingIgnoreCase(player);
    }

//    List<Footballer> findByTeam(String team) {
//        return footballerRepository.findByTeamContainingIgnoreCase(team);
//    }

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
