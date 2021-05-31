package com.example.cloudfeign.controller;

import com.example.cloudfeign.entity.Student;
import com.example.cloudfeign.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/student")
    public Collection<Student> findAll() {
        return feignProviderClient.findAll();
    }

    @GetMapping("/student/port")
    public String port() {
        return feignProviderClient.port();
    }
}
