package io.jittakal.ms.demo.controller;


import io.jittakal.ms.demo.model.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/service")
    public Demo getTestData(){
        Demo test = new Demo();
        test.setTestData1("Hello");
        test.setTestData2("World");
        test.setTestData3("!!!");
        return test;
    }
}
