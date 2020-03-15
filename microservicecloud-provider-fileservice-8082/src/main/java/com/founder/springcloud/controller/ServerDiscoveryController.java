package com.founder.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServerDiscoveryController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value = "/service/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		System.out.println("eureka注册服务有："+services);
		//获取服务名称为microservicecloud-provider-fileservice的微服务集合
		List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud-provider-fileservice");
		for (ServiceInstance instance : instances) {
			System.out.println("服务名称为microservicecloud-provider-fileservice的微服务：");
			System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
		
		}
		return discoveryClient;
	}
}
