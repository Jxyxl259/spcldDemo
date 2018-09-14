package com.spcld.controller;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spcld.entity.Dept;
import com.spcld.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	// 服务发现
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@HystrixCommand(fallbackMethod = "processHystrix_get")
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		Dept d = service.get(id);
		if( d == null ){
			throw new RuntimeException("查询不到 id 为 "+ id +" 的相关部门信息");
		}
		return d;
	}

	// 一旦服务调用出现异常之后，通过@HystrixCommand(fallbackMethod = "[出现异常处理的方法名]")注解
	// 交由该方法进行处理
	public Dept processHystrix_get(@PathVariable("id") Long id){
		return new Dept("查询不到 id 为 "+ id +" 的相关部门信息， null -- @HystrixCommand");
	}


	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

	
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {

		// 盘点注册进 eureka 中的所有微服务
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		// spring.application.name
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			// 打印本微服务的服务id 本服务所在的主机 对外暴露服务的端口 服务的uri地址
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
