package com.paascloud.provider.web.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/example")
public class ExampleController {


    @Value("${test}")
    private String test;

    @GetMapping("/testReadConfiguration")
    public String testReadConfiguration(){
        return test;
    }

    @GetMapping("/hello")
    public String hello(){
        return "sddddddddddddddd";
    }
}
