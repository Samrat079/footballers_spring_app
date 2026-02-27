package com.example.footballer_db.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/q")
    List<Footballer> searchByName(@RequestParam String query) {
        return footballerServices.findByString(query);
    }

    @GetMapping("/all_teams")
    List<String> findDistinctTeams() { return footballerServices.findDistinctTeam();}

    @GetMapping("/all_nations")
    List<String> findDistinctNation() { return footballerServices.findDistinctNation();}

    @GetMapping("/all_pos")
    List<String> findDistinctPositions() { return footballerServices.findDistinctPositions();}

    @GetMapping("/data_set")
    ResponseEntity<Resource> downloadDataSet() throws IOException {
        Path path = Paths.get("footballer_dataset.csv");
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=footballer_dataset.csv")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
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
