package com.spcld.spcld_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigServer
public class SpringCloud_ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_ConfigApplication.class, args);
    }
}
