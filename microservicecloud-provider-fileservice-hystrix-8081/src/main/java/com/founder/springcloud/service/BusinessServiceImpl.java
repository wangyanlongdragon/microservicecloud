package com.founder.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.springcloud.dao.BusinessInfoDao;
import com.founder.springcloud.entities.BusinessInfo;

/**
 * @Descirption：这里实现文件信息添加只是向数据库存储信息
 * @author wyl
 * @date 2020年3月9日 下午4:22:24
 * @version v1.0
 */
@Service
public class BusinessServiceImpl implements BusinessService {
	@Autowired
	private BusinessInfoDao businessInfoDao;
	
	@Override
	public boolean add(BusinessInfo businessInfo) {
		return businessInfoDao.addBusinessInfo(businessInfo);
	}

	@Override
	public BusinessInfo get(Long id) {
		BusinessInfo business = businessInfoDao.findById(id);
		return business;
	}

	@Override
	public List<BusinessInfo> list() {
		return businessInfoDao.findAll();
	}

}
