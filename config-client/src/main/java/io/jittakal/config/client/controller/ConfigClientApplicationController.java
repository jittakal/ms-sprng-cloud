package io.jittakal.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientApplicationController {

    @Value("${config.client.msg}")
    private String configClientMsg;

    @RequestMapping("/")
    public String hello() {
        return "Using [" + configClientMsg + "] from config server";
    }

}