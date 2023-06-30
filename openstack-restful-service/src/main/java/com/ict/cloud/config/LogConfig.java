package com.ict.cloud.config;

import feign.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    @ConditionalOnProperty(prefix = "logging", name = "enable", havingValue = "true")
    Logger.Level feignLoggerLeave() {
        return Logger.Level.FULL;
    }
}
