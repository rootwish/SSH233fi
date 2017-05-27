package com.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dao.OrderDAO;
import com.domain.Customer;
import com.domain.Consignee;
import com.domain.Order;
//import com.domain.Payment;
//import com.domain.PaymentType;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
	//private static final Log log = LogFactory.getLog(OrderServiceImpl.class);   //日志
	private static final String provinceClassName = "Province";
	private static final String provinceColumnName = "name";
	private static final String cityClassName = "City";
	private static final String cityColumnName = "name";
	private static final String areaClassName = "Area";
	private static final String areaColumnName = "name";
	private static final String orderClassName = "Orders";
	private static final String orderColumnName1 = "theCustomer";	
	private static final String orderColumnName2 = "objId";
	private static final String orderColumnName3 = "orderState";
	private static final String orderColumnName4 = "thePayment";
	private static final String consigneeClassName = "com.domain.Consignee";
	private static final String paymentClassName = "com.domain.Payment";
	
	private OrderDAO orderDao;
	
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
	
	/**
	 * 增加对象
	 * @param object
	 */
	public void add(Object object){
		orderDao.save(object);
	}
	/**
	 * 更新对象
	 * @param object
	 */
	public void update(Object object){
		orderDao.update(object);
	}
	/**
	 * 删除对象
	 * @param object
	 */
	public void delete(Object object){
		orderDao.delete(object);
	}
	/**
	 * 查找所有省
	 * @return
	 */
	public List findProvince(){
		List list = orderDao.findProvince();
		return list;
	}

	/**
	 * 查找所有市
	 * @return
	 */
	public List findCity(String province){
		//log.info("查找" + province + "所有的市");
		List list = orderDao.findByOneProperty(provinceClassName,provinceColumnName,province);
		return list;
	}
	
	/**
	 * 查找所有区
	 * @return
	 */
	public List findArea(String city){
	//	log.info("查找" + city + "所有的区");
		List list = orderDao.findByOneProperty(cityClassName,cityColumnName,city);
		return list;
	}
	
	/**
	 * 查找某个区
	 * @return
	 */
	public List findOneArea(String area){
		//log.info("查找" + area + "所有的区");
		List list = orderDao.findByOneProperty(areaClassName,areaColumnName,area);
		return list;
	}
	
	/**
	 * 查找订单(根据订单ID和顾客ID)
	 * @param customerId  顾客ID
	 * @param orderId     订单ID
	 * @return
	 */
	public List findOrderById(Integer customerId,Integer orderId){
		//log.info("查找顾客ID为"+customerId+"的"+orderClassName+"."+orderColumnName2+"=" + orderId + "的订单");
		List <Order>list = orderDao.findByTwoProperty(orderClassName,orderColumnName1,orderColumnName2,customerId,orderId);
		return list;
	}
	
	/**
	 * 查询订单(根据顾客ID)
	 * @param customer_Id 顾客ID
	 * @return
	 */
	public List<Order> findOrderBytheCustomer(Integer customer_Id){
		List<Order> list = orderDao.findByOneProperty(orderClassName,orderColumnName1,customer_Id);
		return list;
	}
	
	/**
	 * 查询订单(根据订单状态和顾客ID)
	 * @param orderState  订单状态
	 * @param customer_Id 顾客ID
	 * @return
	 */
	public List<Order> findOrderByOrderState(Integer orderState,Integer customer_Id){
		List<Order> list = orderDao.findByTwoProperty(orderClassName,orderColumnName1,orderColumnName3,customer_Id,orderState);
		return list;
	}
	
	/**
	 * 查询所有支付方式
	 * @return
	 */
//	public List<PaymentType> findAllPaymentType(){
//		List<PaymentType> list = orderDao.findAllPaymentType();
//		return list;
//	}
	
	/**
	 * 根据支付方式名查询该个支付方式对象
	 * @param typeName
	 * @return
	 */
//	public PaymentType findAPaymentType(String typeName){
//		PaymentType paymentType = (PaymentType)orderDao.findAPaymentType(typeName);
//		return paymentType;
//	}
	
	/**
	 * 通过Id查找收花人
	 * @param objId
	 * @return
	 */
	public Consignee findAConsigneeById(int objId){
		Consignee consignee = (Consignee)orderDao.findTemplateByid(consigneeClassName, objId);
		return consignee;
	}
	
	/**
	 * 根据付款对象号修改订单的状态
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId){
		orderDao.updateOrderState(paymentId);
	}
	
	/**
	 * 根据PaymentID查询Payment对象
	 */
//	public Payment findPaymentById(int objId){
//		Payment payment = (Payment)orderDao.findTemplateByid(paymentClassName, objId);
//		return payment;
//	}
	/**
	 * 查询订单(根据支付ID)
	 * @param payment_Id 支付ID
	 * @return
	 */
	public List<Order> findOrderBythePayment(Integer payment_Id){
		List<Order> list = orderDao.findByOneProperty(orderClassName,orderColumnName4,payment_Id);
		return list;
	}
}
