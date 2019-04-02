package com.example.config;

import com.example.common.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebConfig
 * @Description web Config
 * @Author hao
 * @Date 2019/3/28 10:56
 **/
@Configuration
public class WebConfig {

    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(0,0);
    }

}
