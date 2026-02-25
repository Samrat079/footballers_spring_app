package com.example.footballer_db.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/test")
public class test_controller {
    @Autowired
    public test_services testServices;

    @GetMapping
    List<test> getAll() {
        return testServices.getTests();
    }

    @PostMapping
    test addTest(@RequestBody test body){
        testServices.addTests(body);
        return body;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTest(@PathVariable String id) {
        testServices.deleteTest(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    ResponseEntity<test> updateTest(@PathVariable String id, @RequestBody test body) {
        testServices.updateTest(id, body);
        return ResponseEntity.ok(body);
    }
}
