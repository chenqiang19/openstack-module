package com.ict.cloud;

import cn.licoy.encryptbody.annotation.EnableEncryptBody;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableScheduling
//@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableCaching
@RestController
@EnableEncryptBody
//@EnableFeignClients
@EnableDiscoveryClient
@EnableAsync
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.ict.cloud.publicmodel.alipay.*"}))
public class OpenstackApplication {
    /**
     * 将Openstack单独作为一个服务的原因
     * 1. 减轻各个微服务之间的依赖关系
     * 2. 各个微服务之间解耦
     * 3. 为了系统更好的进行扩展，如果将openstack作为一个common模块依赖到各个服务中，那么对于将来分库分表的结构设计是致命的
     * 4. 可以单独给出controller界面
     * 5. 减轻内存负载
     * 6. 对于paas对于底层的操纵一般和其他的操作规模相近，所以用dubbo取代openFeign作为RPC通信的架构
     * 7. 为别的微服务分流，可单独将openstack部署到一台机器，或openstack和cloud部署到一台服务器，从而减轻机器的负载
     * */
    public static void main(String[] args) { SpringApplication.run(OpenstackApplication.class, args); }
}
