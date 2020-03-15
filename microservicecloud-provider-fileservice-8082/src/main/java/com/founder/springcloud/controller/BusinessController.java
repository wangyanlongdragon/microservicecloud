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

@RestController
public class BusinessController {
	@Autowired
	private BusinessService service;
	@Autowired
	private DataSource dataSource;

	@PostMapping(value = "/business/add")
	public boolean add(@RequestBody BusinessInfo businessInfo) {
		return service.add(businessInfo);
	}

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

}
