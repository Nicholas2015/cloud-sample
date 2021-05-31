package com.example.cloudhystrix.feign;

import com.example.cloudhystrix.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider")
public interface FeignProviderClient {

    @GetMapping("/student")
    Collection<Student> findAll();

    @GetMapping("/student/port")
    String port();
}
