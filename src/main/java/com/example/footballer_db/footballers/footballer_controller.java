package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/footballer")
public class footballer_controller {

    @Autowired
    private footballer_services footballerServices;

    @GetMapping
    public List<Footballer> searchFootballers(@RequestParam(required = false) Map<String, String> params) {
        return footballerServices.advanced_search(params);
    }

    @PostMapping
    ResponseEntity<Footballer> addFootBaller(@RequestBody Footballer body) {
        footballerServices.addFootBaller(body);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    ResponseEntity<Footballer> updateFootBaller(@PathVariable String id, @RequestBody Footballer body) {
        Optional<Footballer> temp = footballerServices.getFootBallerById(id);
        if (temp.isEmpty()) return ResponseEntity.notFound().build();
        footballerServices.updateFootBaller(id, body);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<Footballer>> deleteFootBaller(@PathVariable String id) {
        Optional<Footballer> temp = footballerServices.getFootBallerById(id);
        if (temp.isEmpty()) return ResponseEntity.notFound().build();
        footballerServices.deleteFootBaller(id);
        return ResponseEntity.ok(temp);
    }
}
