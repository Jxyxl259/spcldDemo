package com.spcld.spcld_config_client.controller;

/**
 * @ClassName ConfigClientRest
 * @Description
 * @Author jiangxy
 * @Date 2018\9\25 0025 16:01
 * @Version 1.0.0
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigClientRest {


    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String defaultZone;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/config")
    @ResponseBody
    public String getConfig(){
        String config = "applicationName: " + applicationName + "\t eurekaServers: " + defaultZone + "\t port: " + port;
        System.out.println("*********从 Spcld-config-server:3344获取到的 gitHub上的配置信息: \t" + config);
        return config;
    }

}
