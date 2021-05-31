package com.example.cloudfeign.feign.impl;

import com.example.cloudfeign.entity.Student;
import com.example.cloudfeign.feign.FeignProviderClient;

import java.util.Collection;

public class FeignError implements FeignProviderClient  {

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String port() {
        return "服务器维护中......";
    }
}
