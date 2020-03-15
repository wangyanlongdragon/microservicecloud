package com.founder.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.founder.springcloud.entities.BusinessInfo;

import feign.hystrix.FallbackFactory;

@Component
public class BusinessFeignClientServiceFallBackFactory implements FallbackFactory<BusinessFeignClientService>{

	@Override
	public BusinessFeignClientService create(Throwable cause) {
		return new BusinessFeignClientService() {

			@Override
			public BusinessInfo get(long id) {
				 return new BusinessInfo().setBusiness_id(id)
						 .setDb_source("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");

			}
			@Override
			public boolean add(BusinessInfo businessInfo) {
				// TODO Auto-generated method stub
				return false;
			}


			@Override
			public List<BusinessInfo> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object discovery() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
