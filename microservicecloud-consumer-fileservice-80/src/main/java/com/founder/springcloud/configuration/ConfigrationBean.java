package com.founder.springcloud.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigrationBean {
	@LoadBalanced	//开启对服务的负载均衡
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean			//自定义负载均衡算法
	public IRule myRule() {
		//return new RoundRobinRule();//默认的轮询算法
		return new RetryRule(new RoundRobinRule(), 3);//按照某个轮询算法进行连接，若某服务器发生失败次数超过限制，就会舍弃这个服务器不再使用；
		//return new RandomRule();//随机算法
		//这里也可以自己实现自己的自定义轮询规则，可以模仿轮询或者其他轮询算法编写即可
	}

}
