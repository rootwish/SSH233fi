package com.service;

import java.util.List;

import com.domain.Customer;
import com.domain.Consignee;
import com.domain.Order;
//import com.domain.Payment;
//import com.domain.PaymentType;

public interface OrderService {
	
	/**
	 * 增加对象
	 * @param object
	 */
	public void add(Object object);
	/**
	 * 更新对象
	 * @param object
	 */
	public void update(Object object);
	/**
	 * 删除对象
	 * @param object
	 */
	public void delete(Object object);
	
	/**
	 * 查找省
	 * @return
	 */
	public List findProvince();
	
	/**
	 * 查找市
	 * @return
	 */
	public List findCity(String province);
	
	/**
	 * 查找区
	 * @return
	 */
	public List findArea(String city);
	
	/**
	 * 查找某个区
	 * @return
	 */
	public List findOneArea(String area);
	
	/**
	 * 查找订单(根据订单ID)
	 * @param customerId  顾客ID
	 * @param orderId     订单ID
	 * @return
	 */
	public List findOrderById(Integer customerId,Integer orderId);
	
	/**
	 * 查询订单(根据顾客ID)
	 * @param customer_Id 顾客ID
	 * @return
	 */
	public List<Order> findOrderBytheCustomer(Integer customer_Id);
	
	/**
	 * 查询订单(根据订单状态和顾客ID)
	 * @param orderState  订单状态
	 * @param customer_Id 顾客ID
	 * @return
	 */
	public List<Order> findOrderByOrderState(Integer orderState,Integer customer_Id);
	
	/**
	 * 根据payment值查询未付款订单
	 * @param orderState  订单状态
	 * @param customer_Id 顾客ID
	 * @param payment payment值
	 * @return
	 */
	
	/**
	 * 通过Id查找收花人
	 * @param objId
	 * @return
	 */
	public Consignee findAConsigneeById(int objId);
	
	/**
	 * 查询所有支付方式
	 * @return
	 */
	//public List<PaymentType> findAllPaymentType();
		
	/**
	 * 根据支付方式名查询该个支付方式对象
	 * @param typeName
	 * @return
	 */
	//public PaymentType findAPaymentType(String typeName);
	
	/**
	 * 根据付款对象号修改订单的状态
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId);
	
	/**
	 * 根据PaymentID查询Payment对象
	 */
	//public Payment findPaymentById(int objId);
	/**
	 * 查询订单(根据支付ID)
	 * @param payment_Id 支付ID
	 * @return
	 */
	public List<Order> findOrderBythePayment(Integer payment_Id);
}

