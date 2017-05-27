package com.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.domain.Customer;


public interface CustomerDAO {
	
	/**
	 * 增加顾客
	 * @param customer
	 * @throws DataAccessException
	 */
	public void save(Customer customer);
	
	/**
	 * 更新顾客
	 * @param customer
	 */
	public void update(Customer customer);
	
	/**
	 * 查询顾客，返回顾客的实例
	 * 查找顾客名是否存在
	 * @param customerName
	 * @return
	 */
	public List findByCustomerId(Object customerName);
	
	/**
	 * 查找顾客类型
	 * @return
	 */
	public List findByCustomerTypeId(Object typeName);
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByTwoProperty(String property1,String property2,Object value1,Object value2);
	
	/**
	 * 查找顾客名和密码
	 * @param customerName
	 * @param password
	 * @return
	 */
	public List findByCustomerIdPwd(Object customerName,Object pwd);
}
