package com.paascloud.provider.controller.frontend;

import com.paascloud.core.web.api.R;
import com.paascloud.core.web.controller.BaseController;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.RemoteExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend/exampleConsumer")
public class ExampleConsumerController extends BaseController {

    private RemoteExampleService remoteExampleService1;

    @Autowired
    public ExampleConsumerController(RemoteExampleService remoteExampleService){
        this.remoteExampleService1 = remoteExampleService;
    }

    @PostMapping("/selectExampleById")
    R<ExampleVo> selectExampleById(@RequestParam("id") Long id){
        return remoteExampleService1.selectExampleById(id);
    }
}
