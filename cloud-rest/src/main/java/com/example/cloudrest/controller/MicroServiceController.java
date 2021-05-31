package com.example.cloudrest.controller;

import com.example.cloudrest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/micro")
public class MicroServiceController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://localhost:8010/student", Collection.class).getBody();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) {
        return restTemplate.getForEntity("http://localhost:8010/student/{id}", Student.class, id).getBody();
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        restTemplate.postForEntity("http://localhost:8010/student", student, Void.class);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        restTemplate.put("http://localhost:8010/student", student, Void.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        restTemplate.delete("http://localhost:8010/student/{id}", id);
    }

    @GetMapping("/port")
    public String findPort() {
        return restTemplate.getForEntity("http://localhost:8010/student/port", String.class).getBody();
    }
}
