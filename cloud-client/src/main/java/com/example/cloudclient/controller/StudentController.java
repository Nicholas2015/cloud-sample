package com.example.cloudclient.controller;

import com.example.cloudclient.entity.Student;
import com.example.cloudclient.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private Integer port;

    @GetMapping
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/port")
    public String findPort() {
        return "调用服务端口号为：" + this.port;
    }
}
