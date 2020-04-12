/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/10 9:41
 */
public class GeneratorSqlMap {
    public void generator() throws Exception{
        //warnings集合用于放置生成过程中生成的警告信息
        List<String> warnings = new ArrayList<String>();
        //定义是否覆盖重名文件
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("E:\\repo\\Java1014\\Mybatis\\Day04\\Lesson\\com\\ychs\\util\\generatorConfig.xml");
        //配置解析类
        ConfigurationParser cp = new ConfigurationParser(warnings);
        //配置解析类解析配置文件并生成Configuration对象
        Configuration config = cp.parseConfiguration(configFile);
        //覆盖重名文件
        ShellCallback callback = new DefaultShellCallback(overwrite);
        //逆向工程对象
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        //执行
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {

        GeneratorSqlMap generatorSqlmap = new GeneratorSqlMap();
        generatorSqlmap.generator();
    }
}
