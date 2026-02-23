package com.example.footballer_db.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Test")
public class test {
    @Id
    String id;

    String name;
    int rollNo;

    public test(int rollNo, String name, String id) {
        this.rollNo = rollNo;
        this.name = name;
        this.id = id;
    }

    public test() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
