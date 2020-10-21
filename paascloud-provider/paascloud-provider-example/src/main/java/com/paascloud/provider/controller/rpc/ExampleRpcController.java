package com.paascloud.provider.controller.rpc;

import com.paascloud.core.web.api.R;
import com.paascloud.provider.model.domain.Example;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.IExampleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc/example")
public class ExampleRpcController {

    @Autowired
    private IExampleService exampleService;

    @GetMapping("/example")
    public String example(){
        return "rpc example";
    }

    @PostMapping("/selectExampleById")
    public R<ExampleVo> selectExampleById(Long id){
        ExampleVo exampleVo = new ExampleVo();
        Example example = exampleService.getById(id);
        BeanUtils.copyProperties(example, exampleVo);
        return R.ok(exampleVo);
    }
}
