package com.spcld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServer
 * @Description
 * @Author jiangxy
 * @Date 2018\9\12 0012 9:47
 * @Version 1.0.
 */
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类，接受其他微服务注册进来
public class EurekaServer_7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }

}
