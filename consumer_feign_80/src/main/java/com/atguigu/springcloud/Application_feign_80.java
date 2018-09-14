package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.spcld.demo"})
@ComponentScan(basePackages = {"com.spcld.demo","com.atguigu.springcloud"})
public class Application_feign_80
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application_feign_80.class, args);
	}
}
