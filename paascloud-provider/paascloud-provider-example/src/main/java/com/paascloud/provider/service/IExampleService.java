package com.paascloud.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paascloud.core.web.page.PageDomain;
import com.paascloud.core.web.page.TableDataInfo;
import com.paascloud.provider.model.domain.Example;
import com.paascloud.provider.model.dto.ExampleSearchDto;
import com.paascloud.provider.model.vo.ExampleVo;

public interface IExampleService extends IService<Example> {
    TableDataInfo<ExampleVo> searchExampleList(ExampleSearchDto exampleSearchDto, IPage<Example> pageDomain);
}
