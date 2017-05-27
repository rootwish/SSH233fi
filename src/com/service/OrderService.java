package com.service;

import java.util.List;

import com.domain.Customer;
import com.domain.Consignee;
import com.domain.Order;
//import com.domain.Payment;
//import com.domain.PaymentType;

public interface OrderService {
	
	/**
	 * ���Ӷ���
	 * @param object
	 */
	public void add(Object object);
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
	 * ����ʡ
	 * @return
	 */
	public List findProvince();
	
	/**
	 * ������
	 * @return
	 */
	public List findCity(String province);
	
	/**
	 * ������
	 * @return
	 */
	public List findArea(String city);
	
	/**
	 * ����ĳ����
	 * @return
	 */
	public List findOneArea(String area);
	
	/**
	 * ���Ҷ���(���ݶ���ID)
	 * @param customerId  �˿�ID
	 * @param orderId     ����ID
	 * @return
	 */
	public List findOrderById(Integer customerId,Integer orderId);
	
	/**
	 * ��ѯ����(���ݹ˿�ID)
	 * @param customer_Id �˿�ID
	 * @return
	 */
	public List<Order> findOrderBytheCustomer(Integer customer_Id);
	
	/**
	 * ��ѯ����(���ݶ���״̬�͹˿�ID)
	 * @param orderState  ����״̬
	 * @param customer_Id �˿�ID
	 * @return
	 */
	public List<Order> findOrderByOrderState(Integer orderState,Integer customer_Id);
	
	/**
	 * ����paymentֵ��ѯδ�����
	 * @param orderState  ����״̬
	 * @param customer_Id �˿�ID
	 * @param payment paymentֵ
	 * @return
	 */
	
	/**
	 * ͨ��Id�����ջ���
	 * @param objId
	 * @return
	 */
	public Consignee findAConsigneeById(int objId);
	
	/**
	 * ��ѯ����֧����ʽ
	 * @return
	 */
	//public List<PaymentType> findAllPaymentType();
		
	/**
	 * ����֧����ʽ����ѯ�ø�֧����ʽ����
	 * @param typeName
	 * @return
	 */
	//public PaymentType findAPaymentType(String typeName);
	
	/**
	 * ���ݸ��������޸Ķ�����״̬
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId);
	
	/**
	 * ����PaymentID��ѯPayment����
	 */
	//public Payment findPaymentById(int objId);
	/**
	 * ��ѯ����(����֧��ID)
	 * @param payment_Id ֧��ID
	 * @return
	 */
	public List<Order> findOrderBythePayment(Integer payment_Id);
}

