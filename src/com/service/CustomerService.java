package com.service;

import java.util.List;

import com.domain.Customer;


public interface CustomerService {

	/**
	 * ���ӹ˿�
	 * @param customer �˿Ͷ���
	 */
	public void add(Customer customer);
	/**
	 * ���¹˿���Ϣ
	 * @param customer �˿Ͷ���
	 */
	public void update(Customer customer);
	
	/**
	 * ��һ���ַ���������MD5�������ܺ󷵻�һ�����ܺ���ַ���
	 * @param password ����
	 * @return
	 */
	public String encoderByMd5(String password);
	
	/**
	 * ���˿��������Ҵ˹˿����Ƿ����
	 * @param customerName ��¼��
	 * @return �ַ���
	 */
	public boolean checkCustomerId(String customerName);
	
	/**
	 * ���˿͵�½
	 * @param instance
	 * @return bool
	 */
	public boolean checklogin(Object value1,Object value2);
	
	/**
	 * ��һ���˿��������ش˹˿�����ʵ��
	 * @param name ��¼��
	 * @return �˿Ͷ���
	 */
	public Customer getCustomerExample(String name);
	
	/**
	 * ��һ���˿����ͣ����ش˹˿����͵�ʵ��
	 * @param name ��¼��
	 * @return �˿����Ͷ���
	 */
	//public CustomerType getCustomerTypeExample(String name);
	
	/**
	 * ���ҹ˿�(�����ֻ�����)
	 * @param customerId  �˿�ID
	 * @return �˿Ͷ���list
	 */
	public List<Customer> findCustomerByMobilePhone(String mobilePhone);
}
