package com.paascloud.provider.web.frontend;

import com.paascloud.provider.domain.CacheObj;
import com.paascloud.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redisExample")
public class RedisExampleController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/getBy")
    public String getBy(String key){
        return redisService.getCacheObject(key);
    }

    @GetMapping("/set")
    public void set(String key, String value){
        redisService.setCacheObject(key, value);
    }

    @GetMapping("/selectCacheAnno")
    @Cacheable(cacheNames = "CacheTest", key = "#id")
    public String selectCacheAnno(Integer id){
        System.out.println("select data from db");
        return id.toString();
    }

    @GetMapping("/deleleCacheAnno")
    @CacheEvict(value = "CacheTest", key = "#id")
    public void deleleCacheAnno(Integer id){

    }

    @Cacheable(cacheNames = "CacheObj", key = "#obj.getId()")
    @PostMapping("/selectCacheObj")
    public  CacheObj selectCacheObj(@RequestBody CacheObj obj){
        return obj;
    }

}
