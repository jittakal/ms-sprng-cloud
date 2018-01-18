package io.jittakal.config.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@DefaultProperties(defaultFallback="defaultFallback")
@RestController
public class DemoServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetData")
    @RequestMapping("/client")
    public String getData(){
        String url = "http://demo-service/service";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackGetData(Throwable hystrixError){
        return "Fallback Method Called.";
    }

    /*public String defaultFallback(){
        return "Default Fallback";
    }*/
}
