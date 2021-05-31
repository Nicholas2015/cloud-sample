package com.example.cloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeController {

    @Value("${server.port}")
    private String port;

    @Value("#{foo.content}")
    private String fooc;

    @GetMapping("/index")
    public String index() {
        return this.port + "=" + this.fooc;
    }
}
