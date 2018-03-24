package io.jittakal.msproducer.controller;


import io.jittakal.msproducer.model.TestData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/service")
    public TestData getTestData(){
        TestData test = new TestData();
        test.setTestData1("Hello");
        test.setTestData2("World");
        test.setTestData3("!!!");
        return test;
    }
}
