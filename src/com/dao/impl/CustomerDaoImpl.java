package com.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.CustomerDAO;
import com.domain.Customer;
import com.opensymphony.xwork2.ActionContext;


public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDAO{
	
//	private static final Log log = LogFactory.getLog(CustomerDaoImpl.class);   //��־
	public static final String customerClassName = "Customer";
	public static final String customerTypeClassName = "CustomerType";
	public static final String TypeName = "typeName";
	public static final String customerId = "customerId";
	public static final String password = "password";
	public static final String theCustomerType = "theCustomerType";
	
	/**
	 * ���ӹ˿�
	 */
	public void save(Customer customer) {
		//log.info("�����˹˿�" + customer.getCustomerId());
		Session session =super.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(customer);
		session.flush();
	}
	
	/**
	 * ���¹˿�
	 * @param customer
	 */
	public void update(Customer customer){
		//log.info("�����˹˿�" + customer.getCustomerId());
		Session session =super.getSessionFactory().getCurrentSession();
		session.update(customer);
		session.flush();
	}
	
	/**
	 * ���ҹ˿���
	 */
	public List findByCustomerId(Object customerName){
		//log.info("���ҹ˿���" + customerName);
		List results = findByOneProperty(customerClassName,customerId,customerName);
		return results;
	}
	
	/**
	 * ���ҹ˿�����
	 * @return
	 */
	public List findByCustomerTypeId(Object typeName){
		//log.info("���ҹ˿�����" + typeName);
		List results = findByOneProperty(customerTypeClassName,TypeName,typeName);
		return results;
	}
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 */
	public List findByOneProperty(String className,String property,Object value){
		String queryString = "From " + className + " as model where model." + property
		+ "= '" + value + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results = session.createQuery(queryString).list();
		return results;
	}
	
	/**
	 * �ṩ�����ֶμ��ֶ�ֵ������List
	 */
	public List findByTwoProperty(String property1,String property2,Object value1,Object value2){
		System.out.println("****datebase list****");
		
		String queryString = "From Customer as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results = session.createQuery(queryString).list();
		//for(int i=0;i<results.size();i++){    System.out.println(results.get(i));}
		return results;
	}
	
	/**
	 * ���ҹ˿���������
	 * @param customerName
	 * @param password
	 * @return
	 */
	public List findByCustomerIdPwd(Object customerName,Object pwd){
		System.out.println("****findByCustomerIdPwd****");
		List results = findByTwoProperty(customerId,password,customerName,pwd);
		return results;
	}
	
	
}
