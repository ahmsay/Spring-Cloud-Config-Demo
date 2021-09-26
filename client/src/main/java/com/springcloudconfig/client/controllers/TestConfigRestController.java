package com.springcloudconfig.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestConfigRestController {

    @Value("${home.message}")
    private String message;

    @GetMapping
    public String getMessage() {
        return message;
    }
}
