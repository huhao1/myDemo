package com.example.common.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @ClassName CodeGenerator
 * @Description mybatis - plus 代码生成器
 * @Author hao
 * @Date 2019/3/27 15:52
 **/
public class CodeGenerator implements Serializable {

    private static final long serialVersionUID = 6522190477240129950L;

    private static String outputDir = "D:/IdeaProjects/myDemo/src/main/java";

    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useLocalSessionState=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

    private static String driverName = "com.mysql.jdbc.Driver";

    private static String username = "root";

    private static String password = "root";

    private static GlobalConfig setGlobalConfig(){

        GlobalConfig gc = new GlobalConfig();

        // 生成文件的输出目录
        gc.setOutputDir(outputDir);
        // 开发人员
        gc.setAuthor("hao");
        // 是否打开输出目录
        gc.setOpen(false);
        // 开启 BaseResultMap
        gc.setBaseResultMap(true);
        // 开启 baseColumnList
        gc.setBaseColumnList(true);
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 生成文件的命名方式
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setControllerName("%sController");

        return gc;
    }

    private static DataSourceConfig setDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);

        return dsc;
    }

    private static PackageConfig setPackageConfig(){
        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.example");
        pc.setEntity("domain");
//        pc.setController("web.api");
//        pc.setMapper("mapper");
//        pc.setXml("mapper.xml");
//        pc.setService("service");
//        pc.setServiceImpl("service.impl");

        return pc;
    }

    private static StrategyConfig setStrategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok
        strategy.setEntityLombokModel(true);
        // 生成 @RestController 控制器
//        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        return strategy;
    }

    public static void main(String[] args) {

        //配置参考 : https://mp.baomidou.com/config/generator-config.html

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        mpg.setGlobalConfig(setGlobalConfig());

        // 2.数据源配置
        mpg.setDataSource(setDataSourceConfig());

        // 3.包配置
        mpg.setPackageInfo(setPackageConfig());

        // 4.表策略配置
        mpg.setStrategy(setStrategyConfig());

        // 5.配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);
        //模板引擎(默认 velocity)
        mpg.setTemplateEngine(new VelocityTemplateEngine());

        // 6.执行
        mpg.execute();
    }

}
