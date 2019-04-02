package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author hao
 * @Date 2019/4/2 15:45
 **/
@Configuration
public class MybatisConfig {

    /**
     * 分页插件
     * 使用Mybatis - plus的分页插件 得加载
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
