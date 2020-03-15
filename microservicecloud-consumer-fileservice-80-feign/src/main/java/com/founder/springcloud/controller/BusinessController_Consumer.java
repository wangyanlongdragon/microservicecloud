package com.founder.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.founder.springcloud.entities.BusinessInfo;
import com.founder.springcloud.service.BusinessFeignClientService;

/**
 * @Descirption
 * @author wyl
 * @date 2020年3月9日 下午7:35:17
 * @version v1.0
 */
@RestController
public class BusinessController_Consumer {
	@Autowired
	private BusinessFeignClientService service;
	
	@GetMapping(value="/consumer/business/add")
	public boolean add(BusinessInfo businessInfo) {
		return service.add(businessInfo);
	}
	
	@GetMapping(value="/consumer/business/get/{id}")
	public BusinessInfo get(@PathVariable("id")long id) {
		return service.get(id);
	}
	@GetMapping(value="/consumer/business/list")
	public List<BusinessInfo> list() {
		return service.list();
	}
	
	@GetMapping(value="/consumer/service/discovery")
	public Object discovery() {
		return service.discovery();
	}
}
