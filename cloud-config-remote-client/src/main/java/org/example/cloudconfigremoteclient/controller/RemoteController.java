package org.example.cloudconfigremoteclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote")
public class RemoteController {

    @Value("${server.port}")
    private String port;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String defaultZone;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/index")
    public String index() {
        return this.port + "-" + this.defaultZone + "-" + this.name;
    }
}
