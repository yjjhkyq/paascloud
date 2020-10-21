package com.paascloud.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paascloud.core.web.page.TableDataInfo;
import com.paascloud.core.web.page.TableSupport;
import com.paascloud.provider.mapper.ExampleMapper;
import com.paascloud.provider.model.domain.Example;
import com.paascloud.provider.model.dto.ExampleSearchDto;
import com.paascloud.provider.model.vo.ExampleVo;
import com.paascloud.provider.service.IExampleService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Service
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, Example> implements IExampleService {

    @Override
    @CacheEvict(value = "Example", key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @CacheEvict(value = "Example", key = "#entity.getId()")
    public boolean updateById(Example entity) {
        return super.updateById(entity);
    }

    @Override
    @Cacheable(cacheNames = "Example", key = "#id")
    public Example getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public TableDataInfo<ExampleVo> searchExampleList(ExampleSearchDto exampleSearchDto, IPage<Example> pageDomain) {
        LambdaQueryWrapper<Example> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(exampleSearchDto.getExampleFieldVarchar())){
            lambdaQueryWrapper.likeRight(Example::getExampleFieldVarchar, exampleSearchDto.getExampleFieldVarchar());
        }
        IPage<Example> result = getBaseMapper().selectPage(pageDomain, lambdaQueryWrapper);
        return TableSupport.buildTableDataInfo(result, (t) -> {
            ExampleVo exampleVo = new ExampleVo();
            BeanUtils.copyProperties(t, exampleVo);
            return exampleVo;
        });
    }
}
