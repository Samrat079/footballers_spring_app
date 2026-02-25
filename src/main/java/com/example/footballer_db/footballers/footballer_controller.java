package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/footballer")
public class footballer_controller {

    @Autowired
    private footballer_services footballerServices;

    @GetMapping
    List<Footballer> getAll() {
        return footballerServices.getAllFootBallers();
    }

    @GetMapping("/search")
    List<Footballer> searchByName(@RequestParam String player) {
        return footballerServices.findByPlayer(player);
    }

//    @GetMapping("/team")
//    List<Footballer> searchByTeam(@RequestParam String team) {
//        return footballerServices.findByTeam(team);
//    }

    @PostMapping
    ResponseEntity<Footballer> addFootBaller(@RequestBody Footballer body) {
        footballerServices.addFootBaller(body);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    ResponseEntity<Footballer> updateFootBaller(@PathVariable String id, @RequestBody Footballer body) {
        Footballer temp = footballerServices.getFootBallerById(id);
        if (temp == null) return ResponseEntity.notFound().build();
        footballerServices.updateFootBaller(id, body);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Footballer> deleteFootBaller(@PathVariable String id) {
        Footballer temp = footballerServices.getFootBallerById(id);
        if (temp == null) return ResponseEntity.notFound().build();
        footballerServices.deleteFootBaller(id);
        return ResponseEntity.ok(temp);
    }
}
