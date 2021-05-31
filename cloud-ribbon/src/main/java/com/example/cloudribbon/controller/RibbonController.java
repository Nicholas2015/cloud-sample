package com.example.cloudribbon.controller;

import com.example.cloudribbon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://provider/student", Collection.class).getBody();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) {
        return restTemplate.getForEntity("http://provider/student/{id}", Student.class, id).getBody();
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        restTemplate.postForEntity("http://provider/student", student, Void.class);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        restTemplate.put("http://provider/student", student, Void.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        restTemplate.delete("http://provider/student/{id}", id);
    }

    @GetMapping("/student/port")
    public String findPort() {
        return restTemplate.getForEntity("http://provider/student/port", String.class).getBody();
    }
}
