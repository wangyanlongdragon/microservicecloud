package com.founder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy//微服务对网关zuul的支持
public class Zuul_9999_App {
	
	
	public static void main(String[] args) {
		System.out.println("网关启动...");
		SpringApplication.run(Zuul_9999_App.class, args);
	}

}
