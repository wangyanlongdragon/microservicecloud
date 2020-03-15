package com.founder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient//服务发现
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@SpringBootApplication
public class FileServiceProvider_8083_App {
	
	
	public static void main(String[] args) {
		SpringApplication.run(FileServiceProvider_8083_App.class, args);
	}

}
