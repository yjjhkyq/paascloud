package com.paascloud.generator.controller;

import com.paascloud.generator.service.GeneratorService;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @GetMapping("/genernateMybatis")
    public void genernateMybatis() throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        generatorService.generateMybatis();
    }
}
