package io.jittakal.config.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

//@DefaultProperties(defaultFallback="defaultFallback")
@RestController
public class DemoServiceController {

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private LoadBalancerClient loadBalancer;

    @HystrixCommand(fallbackMethod = "fallbackGetData")
    @RequestMapping("/client")
    public String getData(@RequestHeader(value="Authorization") String authorizationHeader,
                          Principal currentUser){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance=loadBalancer.choose("demo-service");
        System.out.println(serviceInstance.getUri().toString());
        System.out.println(currentUser.getName());
        //String url = "http://demo-service/service";
        String url = serviceInstance.getUri().toString()+"/service";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackGetData(@RequestHeader(value="Authorization") String authorizationHeader,
                                  Principal currentUser, Throwable hystrixError){
        return "Fallback Method Called.";
    }

    /*public String defaultFallback(){
        return "Default Fallback";
    }*/
}
