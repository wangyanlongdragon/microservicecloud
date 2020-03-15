package com.founder.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.founder.springcloud.entities.BusinessInfo;

@Mapper
public interface BusinessInfoDao {
	  public boolean addBusinessInfo(BusinessInfo businessInfo);
	 
	  public BusinessInfo findById(Long id);
	 
	  public List<BusinessInfo> findAll();

}
