package com.paascloud.provider.service;

import com.paascloud.core.web.api.R;

import com.paascloud.provider.model.vo.ExampleVo1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "exampleService", value = "paascloud-provider-example")
public interface RemoteExampleService1 {
    @PostMapping("/rpc/example/selectExampleById")
    R<ExampleVo1> selectExampleById(@RequestParam("id") Long id);
}