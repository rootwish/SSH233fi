package com.dao;

import java.util.List;

public interface OrderDAO {
	
	/**
	 * �������
	 */
	public void save(Object object);
	/**
	 * ���¶���
	 * @param object
	 */
	public void update(Object object);
	/**
	 * ɾ������
	 * @param object
	 */
	public void delete(Object object);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId);
	
	/**
	 * ����ʡ
	 * @return
	 */
	public List findProvince();
	
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property1
	 * @param property2
	 * @param value1
	 * @param value2
	 * @return
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2);

	/**
	 * ��ѯ����֧����ʽ
	 * @return
	 */
	public List findAllPaymentType();
	
	/**
	 * ����֧����ʽ����ѯ�ø�֧����ʽ����
	 * @param typeName
	 * @return
	 */
	public Object findAPaymentType(String typeName);
	
	/**
	 * ���ݸ��������޸Ķ�����״̬
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId);
}
