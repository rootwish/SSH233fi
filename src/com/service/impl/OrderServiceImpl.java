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
	//private static final Log log = LogFactory.getLog(OrderServiceImpl.class);   //��־
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
	 * ���Ӷ���
	 * @param object
	 */
	public void add(Object object){
		orderDao.save(object);
	}
	/**
	 * ���¶���
	 * @param object
	 */
	public void update(Object object){
		orderDao.update(object);
	}
	/**
	 * ɾ������
	 * @param object
	 */
	public void delete(Object object){
		orderDao.delete(object);
	}
	/**
	 * ��������ʡ
	 * @return
	 */
	public List findProvince(){
		List list = orderDao.findProvince();
		return list;
	}

	/**
	 * ����������
	 * @return
	 */
	public List findCity(String province){
		//log.info("����" + province + "���е���");
		List list = orderDao.findByOneProperty(provinceClassName,provinceColumnName,province);
		return list;
	}
	
	/**
	 * ����������
	 * @return
	 */
	public List findArea(String city){
	//	log.info("����" + city + "���е���");
		List list = orderDao.findByOneProperty(cityClassName,cityColumnName,city);
		return list;
	}
	
	/**
	 * ����ĳ����
	 * @return
	 */
	public List findOneArea(String area){
		//log.info("����" + area + "���е���");
		List list = orderDao.findByOneProperty(areaClassName,areaColumnName,area);
		return list;
	}
	
	/**
	 * ���Ҷ���(���ݶ���ID�͹˿�ID)
	 * @param customerId  �˿�ID
	 * @param orderId     ����ID
	 * @return
	 */
	public List findOrderById(Integer customerId,Integer orderId){
		//log.info("���ҹ˿�IDΪ"+customerId+"��"+orderClassName+"."+orderColumnName2+"=" + orderId + "�Ķ���");
		List <Order>list = orderDao.findByTwoProperty(orderClassName,orderColumnName1,orderColumnName2,customerId,orderId);
		return list;
	}
	
	/**
	 * ��ѯ����(���ݹ˿�ID)
	 * @param customer_Id �˿�ID
	 * @return
	 */
	public List<Order> findOrderBytheCustomer(Integer customer_Id){
		List<Order> list = orderDao.findByOneProperty(orderClassName,orderColumnName1,customer_Id);
		return list;
	}
	
	/**
	 * ��ѯ����(���ݶ���״̬�͹˿�ID)
	 * @param orderState  ����״̬
	 * @param customer_Id �˿�ID
	 * @return
	 */
	public List<Order> findOrderByOrderState(Integer orderState,Integer customer_Id){
		List<Order> list = orderDao.findByTwoProperty(orderClassName,orderColumnName1,orderColumnName3,customer_Id,orderState);
		return list;
	}
	
	/**
	 * ��ѯ����֧����ʽ
	 * @return
	 */
//	public List<PaymentType> findAllPaymentType(){
//		List<PaymentType> list = orderDao.findAllPaymentType();
//		return list;
//	}
	
	/**
	 * ����֧����ʽ����ѯ�ø�֧����ʽ����
	 * @param typeName
	 * @return
	 */
//	public PaymentType findAPaymentType(String typeName){
//		PaymentType paymentType = (PaymentType)orderDao.findAPaymentType(typeName);
//		return paymentType;
//	}
	
	/**
	 * ͨ��Id�����ջ���
	 * @param objId
	 * @return
	 */
	public Consignee findAConsigneeById(int objId){
		Consignee consignee = (Consignee)orderDao.findTemplateByid(consigneeClassName, objId);
		return consignee;
	}
	
	/**
	 * ���ݸ��������޸Ķ�����״̬
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId){
		orderDao.updateOrderState(paymentId);
	}
	
	/**
	 * ����PaymentID��ѯPayment����
	 */
//	public Payment findPaymentById(int objId){
//		Payment payment = (Payment)orderDao.findTemplateByid(paymentClassName, objId);
//		return payment;
//	}
	/**
	 * ��ѯ����(����֧��ID)
	 * @param payment_Id ֧��ID
	 * @return
	 */
	public List<Order> findOrderBythePayment(Integer payment_Id){
		List<Order> list = orderDao.findByOneProperty(orderClassName,orderColumnName4,payment_Id);
		return list;
	}
}
