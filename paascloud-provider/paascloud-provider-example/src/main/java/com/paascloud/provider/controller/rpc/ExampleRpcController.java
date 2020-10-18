package com.paascloud.provider.controller.rpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc/example")
public class ExampleRpcController {

    @GetMapping("/example")
    public String example(){
        return "rpc example";
    }
}
