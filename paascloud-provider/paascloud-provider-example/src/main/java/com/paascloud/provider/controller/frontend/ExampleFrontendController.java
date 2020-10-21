package com.paascloud.provider.controller.frontend;

import com.paascloud.core.utils.ServletUtils;
import com.paascloud.core.web.controller.BaseController;
import com.paascloud.core.web.page.TableDataInfo;
import com.paascloud.core.web.page.TableSupport;
import com.paascloud.provider.model.domain.Example;
import com.paascloud.provider.model.dto.ExampleDto;
import com.paascloud.provider.model.dto.ExampleSearchDto;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.IExampleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frontend/example")
public class ExampleFrontendController extends BaseController {
    @Autowired
    private IExampleService exampleService;

    @Value("${test}")
    private String test;

    @GetMapping("/testReadConfiguration")
    public String testReadConfiguration(){
        return test;
    }

    @GetMapping("/hello")
    public String hello(){
        return "sddddddddddddddd";
    }
    
    @GetMapping("/header")
    public String header(){
        return ServletUtils.getRequest().getHeader("Authorization");
    }

    @PostMapping("/insertExample")
    public void insertExample(@RequestBody @Validated ExampleDto exampleDto){
        Example example = new Example();
        BeanUtils.copyProperties(exampleDto, example);
        exampleService.save(example);
    }

    @PostMapping("/selectExampleById")
    public ExampleVo selectExampleById(Long id){
        ExampleVo exampleVo = new ExampleVo();
        Example example = exampleService.getById(id);
        BeanUtils.copyProperties(example, exampleVo);
        return exampleVo;
    }

    @PostMapping("/updateExample")
    public void updateExample(@RequestBody @Validated ExampleDto exampleDto){
        Example example = exampleService.getById(exampleDto.getId());
        example.setExampleFieldInt(exampleDto.getExampleFieldInt());
        example.setExampleFieldVarchar(exampleDto.getExampleFieldVarchar());
        exampleService.updateById(example);
    }

    @PostMapping("/deleteExampleById")
    public void deleteExampleByIds(Long id){
        exampleService.removeById(id);
    }

    @PostMapping("/searchExampleList")
    public TableDataInfo<ExampleVo> searchExampleList(int pageNum, int pageSize, @RequestBody ExampleSearchDto exampleSearchDto){
        return exampleService.searchExampleList(exampleSearchDto, buildIPageRequest());
    }

}

