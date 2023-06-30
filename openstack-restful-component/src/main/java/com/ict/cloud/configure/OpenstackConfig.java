package com.ict.cloud.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "controller")
@PropertySource(value = {"classpath:config.yml"}, factory = YamlPropertySourceFactory.class)
public class OpenstackConfig {

    @Value("${controller.url}")
    private String url;

    @Value("${controller.ip}")
    private String ip;
}