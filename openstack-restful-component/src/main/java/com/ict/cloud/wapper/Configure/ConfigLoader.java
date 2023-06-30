package com.ict.cloud.wapper.Configure;

import com.ict.cloud.configure.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "login")
@PropertySource(value = {"classpath:config.yml"}, factory = YamlPropertySourceFactory.class)
public class ConfigLoader {
    @Value("${login.tenantName}")
    private String name;

    @Value("${login.user}")
    private String user;

    @Value("${login.password}")
    private String password;
}
