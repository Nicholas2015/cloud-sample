package com.example.cloudfeign.feign;

import com.example.cloudfeign.entity.Student;
import com.example.cloudfeign.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("/student")
    Collection<Student> findAll();

    @GetMapping("/student/port")
    String port();
}
