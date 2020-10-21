package com.paascloud.generator.service;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorService {
    public void generateMybatis() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        String path = ResourceUtils.getURL("classpath:").getPath();
        File configFile = new File(path, "mybatisgenerator_config.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        //小心,这里是覆盖以前生成的,如果你有修改以前的,注意换路径生成
        boolean overwrite = true;
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(new ProgressCallback(){

            @Override
            public void introspectionStarted(int i) {

            }

            @Override
            public void generationStarted(int i) {

            }

            @Override
            public void saveStarted(int i) {

            }

            @Override
            public void startTask(String s) {

            }

            @Override
            public void done() {

            }

            @Override
            public void checkCancel() throws InterruptedException {

            }
        });
    }
}
