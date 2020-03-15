package com.founder.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Descirption:仅做businessInfo演示，并无文件与其关联
 * @author wyl
 * @date 2020年3月9日 下午3:17:44
 * @version v1.0
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class BusinessInfo implements Serializable //微服务实体类要实现序列号接口
{
	private Long business_id;//交易编号
	private String sys_no;//系统编号
	private String db_source;//来自数据库名称，微服务架构可以一个服务对应一个数据库，同一个信息可能会被存储到不同库
	private String cust_no;//客户号
	

}
