package com.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

import com.dao.CustomerDAO;
import com.domain.Customer;
import com.service.CustomerService;
//import com.dao.OrderDAO;
//import com.service.impl.OrderServiceImpl;

public class CustomerServiceImpl implements CustomerService{
	//private static final Log log = LogFactory.getLog(OrderServiceImpl.class);   //日志
	private static final String customerClassName="Customer";
	private static final String customerColumnName="mobilePhone";
	CustomerDAO customerDao;
	
	public CustomerDAO getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	
	/**
	 * 增加顾客
	 */
	public void add(Customer customer){
		customerDao.save(customer);
	}
	/**
	 * 更新顾客信息
	 */
	public void update(Customer customer){
		customerDao.update(customer);
	}
	
	/**
	 *传一个字符串，经过MD5经过加密后返回一个加密后的字符串
	 */
	public String EncoderByMd5(String password) //throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		 try{
		//确定计算方法
		         MessageDigest md5=MessageDigest.getInstance("MD5");
		         BASE64Encoder base64en = new BASE64Encoder();
		 //加密后的字符串
		         String newpassword=base64en.encode(md5.digest(password.getBytes("utf-8")));
		         return newpassword;
		 	}catch(Exception ex){  
		               ex.printStackTrace();  
		           				}  
		 		 return null;
	}
	
	/**
	 * 传顾客名，查找此顾客名是否存在
	 */
	public boolean checkCustomerId(String customerName){
		List list = customerDao.findByCustomerId(customerName);
		if(list.isEmpty())
			return true;      //顾客名不存在
		else return false;    //顾客名存在
	}
	
	/**
	 * 检查登陆，传一个包含登陆名和密码的实例，查询数据库
	 * 是否存在此实例
	 * @param instance
	 * @return 
	 */
	public boolean checklogin(Object value1,Object value2){
		
		System.out.println("****checklogin****");
		
		List list = customerDao.findByCustomerIdPwd(value1,value2);
		if(list.isEmpty())
			return false;             //登陆失败
		else return true;             //登陆成功
	}
	
	/**
	 * 传一个顾客名，返回此顾客名的实例
	 * @param name
	 * @return
	 */
	public Customer getCustomerExample(String name){
		Customer customer = (Customer)customerDao.findByCustomerId(name).get(0);
		return customer;
	}
//	
//	public CustomerType getCustomerTypeExample(String name){
//		CustomerType customerType = (CustomerType)customerDao.findByCustomerTypeId(name).get(0);
//		return customerType;
//	}
//	
	/**
	 * 查找顾客(根据手机号码)
	 * @param mobilePhone 手机号码
	 * @return
	 */
	public List<Customer> findCustomerByMobilePhone(String mobilePhone) {
		//log.info("查找手机号码是"+mobilePhone+"的顾客");
		List<Customer> list= customerDao.findByOneProperty(customerClassName, customerColumnName, mobilePhone);
		return list;
	}
public String encoderByMd5(String password) {
	// TODO Auto-generated method stub
	return null;
}

}
