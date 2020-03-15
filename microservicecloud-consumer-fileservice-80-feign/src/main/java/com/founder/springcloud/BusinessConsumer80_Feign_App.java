package com.founder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages= {"com.founder.springcloud"})//开启对feignclient的支持，面向接口编程
@ComponentScan("com.founder.springcloud")
public class BusinessConsumer80_Feign_App {

	public static void main(String[] args) {
		SpringApplication.run(BusinessConsumer80_Feign_App.class, args);
	}

}
