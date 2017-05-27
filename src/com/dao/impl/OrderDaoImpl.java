package com.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.OrderDAO;
import com.domain.Order;
//import com.domain.PaymentType;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDAO{
	private static final Log log = LogFactory.getLog(OrderDaoImpl.class);   //��־
	
	

	/**
	 * �������
	 */
	public void save(Object object){
		getSessionFactory().getCurrentSession().saveOrUpdate(object);
		getSessionFactory().getCurrentSession().flush();
	}
	/**
	 * ���¶���
	 * @param object
	 */
	public void update(Object object){
		getSessionFactory().getCurrentSession().update(object);
	}
	
	/**
	 * ɾ������
	 * @param object
	 */
	public void delete(Object object){
		getSessionFactory().getCurrentSession().delete(object);
	}
	
	/**
	 * ͨ��Id����ʵ��
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId){
		Object object = getSessionFactory().getCurrentSession().get(className,objId);
		return object;
	}
	
	/**
	 * ����ʡ
	 * @return
	 */
	public List findProvince(){
		log.info("������ʡ");
		String queryString = "from Province as model where model.objId>0";
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value){
		String queryString = "From " + className + " as model where model." + property
		+ "= '" + value + "'";
		List results = getSessionFactory().getCurrentSession().createQuery(queryString).list();
		return results;
	}
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property1
	 * @param property2
	 * @param value1
	 * @param value2
	 * @return
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2){
		String queryString = "From " + className + " as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "'";
		List<Order> results = getSessionFactory().getCurrentSession().createQuery(queryString).list();
		//List results = getSessionFactory().getCurrentSession().createQuery("from"+className+"")
		return results;
	}
	
	/**
	 * ��ѯ����֧����ʽ
	 * @return
	 */
	public List findAllPaymentType(){
		String queryString = "From PaymentType as model where model.objId>0";
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * ����֧����ʽ����ѯ�ø�֧����ʽ����
	 * @param typeName
	 * @return
	 */
	public Object findAPaymentType(String typename){
		String queryString = "From PaymentType as model where model.typeName='"+typename+"'";
		Object object = getHibernateTemplate().find(queryString).get(0);
		return object;
	}
	
	/**
	 * ���ݸ��������޸Ķ�����״̬
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId){
		String queryString = "update [order] set orderState=2 from [order] where thePayment="+paymentId;
		int i =getSessionFactory().openSession().createSQLQuery(queryString).executeUpdate();
	}
}
