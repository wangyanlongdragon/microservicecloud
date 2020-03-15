package com.founder.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.founder.springcloud.entities.BusinessInfo;

@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-FILESERVICE",fallbackFactory =BusinessFeignClientServiceFallBackFactory.class )// 通过服务名直接调用微服务
public interface BusinessFeignClientService {

	
	@GetMapping(value = "/business/add")
	public boolean add(BusinessInfo businessInfo);

	@GetMapping(value = "/business/get/{id}")
	public BusinessInfo get(@PathVariable("id") long id);

	@GetMapping(value = "/business/list")
	public List<BusinessInfo> list();

	@GetMapping(value = "/service/discovery")
	public Object discovery();

}
