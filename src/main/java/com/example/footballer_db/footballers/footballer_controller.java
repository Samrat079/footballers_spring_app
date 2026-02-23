package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/footballer")
public class footballer_controller {

    @Autowired
    private footballer_services footballerServices;

    @GetMapping
    List<footballer> getAll() {
        return footballerServices.getAllFootBallers();
    }

    @GetMapping("/search")
    List<footballer> searchByName(@RequestParam String Player) {
        return footballerServices.searchByName(Player);
    }

    @PostMapping
    ResponseEntity<footballer> addFootBaller(@RequestBody footballer body) {
        footballerServices.addFootBaller(body);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    ResponseEntity<footballer> updateFootBaller(@PathVariable String id, @RequestBody footballer body) {
        footballer temp = footballerServices.getFootBallerById(id);
        if (temp == null) return ResponseEntity.notFound().build();
        footballerServices.updateFootBaller(id, body);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<footballer> deleteFootBaller(@PathVariable String id) {
        footballer temp = footballerServices.getFootBallerById(id);
        if (temp == null) return ResponseEntity.notFound().build();
        footballerServices.deleteFootBaller(id);
        return ResponseEntity.ok(temp);
    }
}
