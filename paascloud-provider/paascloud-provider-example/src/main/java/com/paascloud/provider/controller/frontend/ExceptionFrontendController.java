package com.paascloud.provider.controller.frontend;

import com.paascloud.core.exception.CheckedException;
import com.paascloud.core.exception.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend/exception")
public class ExceptionFrontendController {

    @GetMapping("/throwApiException")
    public void throwApiException(){
        throw new ApiException(12, "api exception");
    }

    @GetMapping("/throwCheckedException")
    public void throwCheckedException(){
        throw new CheckedException("checked excpetion");
    }
}
