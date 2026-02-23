package com.example.footballer_db.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class test_services {

    @Autowired
    private test_repository testRepository;

    List<test> getTests() {
        return testRepository.findAll();
    }

    void addTests(test body) {
        testRepository.insert(body);
    }

    void deleteTest(String id) {
        testRepository.deleteById(id);
    }
}
