package com.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.domain.Customer;


public interface CustomerDAO {
	
	/**
	 * ���ӹ˿�
	 * @param customer
	 * @throws DataAccessException
	 */
	public void save(Customer customer);
	
	/**
	 * ���¹˿�
	 * @param customer
	 */
	public void update(Customer customer);
	
	/**
	 * ��ѯ�˿ͣ����ع˿͵�ʵ��
	 * ���ҹ˿����Ƿ����
	 * @param customerName
	 * @return
	 */
	public List findByCustomerId(Object customerName);
	
	/**
	 * ���ҹ˿�����
	 * @return
	 */
	public List findByCustomerTypeId(Object typeName);
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * �ṩ�����ֶμ��ֶ�ֵ������List
	 */
	public List findByTwoProperty(String property1,String property2,Object value1,Object value2);
	
	/**
	 * ���ҹ˿���������
	 * @param customerName
	 * @param password
	 * @return
	 */
	public List findByCustomerIdPwd(Object customerName,Object pwd);
}
