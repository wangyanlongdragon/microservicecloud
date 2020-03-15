package com.founder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BusinessConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(BusinessConsumer80_App.class, args);
	}

}
