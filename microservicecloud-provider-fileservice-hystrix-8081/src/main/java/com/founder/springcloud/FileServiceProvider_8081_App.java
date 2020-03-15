package com.founder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient//服务发现
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@SpringBootApplication
@EnableCircuitBreaker//对hystrix熔断机制的支持
public class FileServiceProvider_8081_App {
	
	
	public static void main(String[] args) {
		SpringApplication.run(FileServiceProvider_8081_App.class, args);
	}

}
