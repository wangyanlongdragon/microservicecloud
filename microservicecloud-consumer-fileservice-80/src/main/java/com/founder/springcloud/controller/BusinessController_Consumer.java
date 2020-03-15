package com.founder.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.founder.springcloud.entities.BusinessInfo;

/**
 * @Descirption
 * @author wyl
 * @date 2020年3月9日 下午7:35:17
 * @version v1.0
 */
@RestController
public class BusinessController_Consumer {
	//https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
	@Autowired
	private RestTemplate restTemplate;//用于访问Rest服务的客户端模板工具
	//private static final String REST_SERVICE_URL_PREFIX = "http://localhost:8081";
	//通过服务名直接调用微服务
	private static final String REST_SERVICE_URL_PREFIX = "http://MICROSERVICECLOUD-PROVIDER-FILESERVICE";
	@GetMapping(value="/consumer/business/add")
	public boolean add(BusinessInfo businessInfo) {
		return restTemplate.postForObject(REST_SERVICE_URL_PREFIX+"/business/add", businessInfo, Boolean.class);
	}
	
	@GetMapping(value="/consumer/business/get/{id}")
	public BusinessInfo get(@PathVariable("id")long id) {
		return restTemplate.getForObject(REST_SERVICE_URL_PREFIX+"/business/get/"+id, BusinessInfo.class);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value="/consumer/business/list")
	public List<BusinessInfo> list() {
		return restTemplate.getForObject(REST_SERVICE_URL_PREFIX+"/business/list", List.class);
	}
	
	@GetMapping(value="/consumer/service/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_SERVICE_URL_PREFIX+"/service/discovery", Object.class);
	}
}
