package com.example.cloudhystrix.controller;

import com.example.cloudhystrix.entity.Student;
import com.example.cloudhystrix.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/student")
    public Collection<Student> findAll() {
        return feignProviderClient.findAll();
    }

    @GetMapping("/student/port")
    public String findPort() {
        return feignProviderClient.port();
    }
}
