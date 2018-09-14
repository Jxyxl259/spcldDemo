package com.spcld.demo.service;

import com.spcld.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// provider项目中 yml中配置的 spring.application.name
// 指明针对哪一个微服务
@FeignClient(value="MICROSERVICECLOUD-DEPT", fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptService {

    @RequestMapping(value="/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable(name="id") Long id);

    @RequestMapping(value="/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

}
