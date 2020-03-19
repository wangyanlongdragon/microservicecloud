package com.founder.springcloud.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.founder.springcloud.entities.BusinessInfo;
import com.founder.springcloud.service.BusinessService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @Descirption：服务熔断机制，当服务调用出现异常快速返回"错误"的响应信息，避免浪费资源，
 * 这里用在服务端，需要为每一个需要熔断的服务些对应的方法处理异常，代码耦合度高，不推荐，推荐
 * 使用服务降级，推荐在使用feign的暴露接口的公共端实现服务降级处理，类似aop切面
 * @author wyl
 * @date 2020年3月10日 下午4:14:11
 * @version v1.0
 */
@RestController
public class BusinessController {
	@Autowired
	private BusinessService service;
	@Autowired
	private DataSource dataSource;

	@PostMapping(value = "/business/add")
	public boolean add(@RequestBody BusinessInfo businessInfo) {
		boolean add;
		try {
			add = service.add(businessInfo);
		} catch (Exception e) {
			throw new RuntimeException(businessInfo+"插入失败");
		}
		return add;
	}
	@HystrixCommand(fallbackMethod = "businessHystrix_Get")
	@GetMapping(value = "/business/get/{id}")
	public BusinessInfo get(@PathVariable("id") Long id) {
		BusinessInfo businessInfo = service.get(id);
		if(businessInfo==null) {
			throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		}
			
		return businessInfo;
	}

	@GetMapping(value = "/business/list")
	public List<BusinessInfo> list() {
		return service.list();
	}

	@GetMapping(value = "/business/test")
	public String testDataSource() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection!=null) {
		return dataSource.getClass().toString();
		}else {
			return "get dataSource fali";
		}
	}
	public BusinessInfo businessHystrix_Get(@PathVariable("id") Long id) {
		return new BusinessInfo().setBusiness_id(id).setDb_source("该ID："+id+"没有没有对应的信息,null in db_source--@HystrixCommand");
	}
	public boolean businessHystrix_Add(@RequestBody BusinessInfo businessInfo) {
		return false;
	}

}
