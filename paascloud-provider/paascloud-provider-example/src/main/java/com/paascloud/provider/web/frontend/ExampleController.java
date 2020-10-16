package com.paascloud.provider.web.frontend;

import com.paascloud.core.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/header")
    public String header(){
        return ServletUtils.getRequest().getHeader("Authorization");
    }
}

