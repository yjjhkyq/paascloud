package com.paascloud.provider.controller.frontend;

import com.paascloud.core.aspects.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend/logExample")
public class LogExampleFrontendController {
    private static final Logger log = LoggerFactory.getLogger(LogExampleFrontendController.class);

    @GetMapping("/logTest")
    public void logTest(){
        log.debug(".............debug............");
        log.info("..............info............");
        log.warn("..............warn............");
        log.error("..............error............");
    }

}
