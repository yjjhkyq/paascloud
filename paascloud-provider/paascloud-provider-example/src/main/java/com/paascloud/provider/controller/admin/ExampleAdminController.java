package com.paascloud.provider.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/example")
public class ExampleAdminController {

    @GetMapping("/example")
    public String example(){
        return "admin example";
    }
}
