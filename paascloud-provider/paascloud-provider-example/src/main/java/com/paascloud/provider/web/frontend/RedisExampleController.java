package com.paascloud.provider.web.frontend;

import com.paascloud.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisExample")
public class RedisExampleController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/getBy")
    public String getBy(String key){
        return redisService.getCacheObject(key);
    }

    @RequestMapping("/set")
    public void set(String key, String value){
        redisService.setCacheObject(key, value);
    }


}
