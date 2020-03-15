package com.founder.springcloud.service;

import java.util.List;

import com.founder.springcloud.entities.BusinessInfo;

/**
 * @Descirption:接口定义方法尽量满足rest风格需求
 * @author wyl
 * @date 2020年3月9日 下午4:25:14
 * @version v1.0
 */
public interface BusinessService {
	  public boolean add(BusinessInfo businessInfo);
		 
	  public BusinessInfo get(Long id);
	 
	  public List<BusinessInfo> list();
}
