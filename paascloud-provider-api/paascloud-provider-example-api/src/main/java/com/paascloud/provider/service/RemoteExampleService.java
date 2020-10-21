package com.paascloud.provider.service;

import com.paascloud.core.web.api.R;
import com.paascloud.provider.constant.ServiceNameConstants;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.factory.ExampleFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "exampleService", value = ServiceNameConstants.EXAMPLE_SERVICE, fallbackFactory = ExampleFallbackFactory.class)
public interface RemoteExampleService {
    @PostMapping("/rpc/example/selectExampleById")
    R<ExampleVo> selectExampleById(@RequestParam("id") Long id);
}
