package com.service;

import java.util.List;

import com.domain.Customer;


public interface CustomerService {

	/**
	 * 增加顾客
	 * @param customer 顾客对象
	 */
	public void add(Customer customer);
	/**
	 * 更新顾客信息
	 * @param customer 顾客对象
	 */
	public void update(Customer customer);
	
	/**
	 * 传一个字符串，经过MD5经过加密后返回一个加密后的字符串
	 * @param password 密码
	 * @return
	 */
	public String encoderByMd5(String password);
	
	/**
	 * 传顾客名，查找此顾客名是否存在
	 * @param customerName 登录名
	 * @return 字符串
	 */
	public boolean checkCustomerId(String customerName);
	
	/**
	 * 检查顾客登陆
	 * @param instance
	 * @return bool
	 */
	public boolean checklogin(Object value1,Object value2);
	
	/**
	 * 传一个顾客名，返回此顾客名的实例
	 * @param name 登录名
	 * @return 顾客对象
	 */
	public Customer getCustomerExample(String name);
	
	/**
	 * 传一个顾客类型，返回此顾客类型的实例
	 * @param name 登录名
	 * @return 顾客类型对象
	 */
	//public CustomerType getCustomerTypeExample(String name);
	
	/**
	 * 查找顾客(根据手机号码)
	 * @param customerId  顾客ID
	 * @return 顾客对象list
	 */
	public List<Customer> findCustomerByMobilePhone(String mobilePhone);
}
