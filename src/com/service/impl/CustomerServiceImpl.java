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
	//private static final Log log = LogFactory.getLog(OrderServiceImpl.class);   //��־
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
	 * ���ӹ˿�
	 */
	public void add(Customer customer){
		customerDao.save(customer);
	}
	/**
	 * ���¹˿���Ϣ
	 */
	public void update(Customer customer){
		customerDao.update(customer);
	}
	
	/**
	 *��һ���ַ���������MD5�������ܺ󷵻�һ�����ܺ���ַ���
	 */
	public String EncoderByMd5(String password) //throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		 try{
		//ȷ�����㷽��
		         MessageDigest md5=MessageDigest.getInstance("MD5");
		         BASE64Encoder base64en = new BASE64Encoder();
		 //���ܺ���ַ���
		         String newpassword=base64en.encode(md5.digest(password.getBytes("utf-8")));
		         return newpassword;
		 	}catch(Exception ex){  
		               ex.printStackTrace();  
		           				}  
		 		 return null;
	}
	
	/**
	 * ���˿��������Ҵ˹˿����Ƿ����
	 */
	public boolean checkCustomerId(String customerName){
		List list = customerDao.findByCustomerId(customerName);
		if(list.isEmpty())
			return true;      //�˿���������
		else return false;    //�˿�������
	}
	
	/**
	 * ����½����һ��������½���������ʵ������ѯ���ݿ�
	 * �Ƿ���ڴ�ʵ��
	 * @param instance
	 * @return 
	 */
	public boolean checklogin(Object value1,Object value2){
		
		System.out.println("****checklogin****");
		
		List list = customerDao.findByCustomerIdPwd(value1,value2);
		if(list.isEmpty())
			return false;             //��½ʧ��
		else return true;             //��½�ɹ�
	}
	
	/**
	 * ��һ���˿��������ش˹˿�����ʵ��
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
	 * ���ҹ˿�(�����ֻ�����)
	 * @param mobilePhone �ֻ�����
	 * @return
	 */
	public List<Customer> findCustomerByMobilePhone(String mobilePhone) {
		//log.info("�����ֻ�������"+mobilePhone+"�Ĺ˿�");
		List<Customer> list= customerDao.findByOneProperty(customerClassName, customerColumnName, mobilePhone);
		return list;
	}
public String encoderByMd5(String password) {
	// TODO Auto-generated method stub
	return null;
}

}
