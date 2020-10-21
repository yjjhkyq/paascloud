package com.paascloud.provider.service.factory;

import com.paascloud.core.web.api.R;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.RemoteExampleService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExampleFallbackFactory implements FallbackFactory<RemoteExampleService> {
    private static final Logger log = LoggerFactory.getLogger(ExampleFallbackFactory.class);
    @Override
    public RemoteExampleService create(Throwable throwable) {
        log.error("Example服务调用失败:{}", throwable.getMessage());
        return new RemoteExampleService() {
            @Override
            public R<ExampleVo> selectExampleById(Long id) {
                return null;
            }
        };
    }
}
