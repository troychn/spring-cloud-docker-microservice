package com.troylc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring cloud config配置服务器启动类
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigServceApplication.class, args);
    }
}
