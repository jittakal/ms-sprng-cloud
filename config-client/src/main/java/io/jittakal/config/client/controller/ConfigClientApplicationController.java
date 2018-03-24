package io.jittakal.config.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientApplicationController {

    @Value("${config.client.msg}")
    private String configClientMsg;

    @HystrixCommand( fallbackMethod = "fallbackHello")
    @RequestMapping("/")
    public String hello() {
        return "Using [" + configClientMsg + "] from config server";
    }

    public String fallbackHello(Throwable hystrixError){
        return "Fallback from config server";
    }
}