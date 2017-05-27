package com.dao;

import java.util.List;

public interface OrderDAO {
	
	/**
	 * 保存对象
	 */
	public void save(Object object);
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
	 * 通过Id查找实例
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId);
	
	/**
	 * 查找省
	 * @return
	 */
	public List findProvince();
	
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property1
	 * @param property2
	 * @param value1
	 * @param value2
	 * @return
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2);

	/**
	 * 查询所有支付方式
	 * @return
	 */
	public List findAllPaymentType();
	
	/**
	 * 根据支付方式名查询该个支付方式对象
	 * @param typeName
	 * @return
	 */
	public Object findAPaymentType(String typeName);
	
	/**
	 * 根据付款对象号修改订单的状态
	 * @param paymnet
	 * @return
	 */
	public void updateOrderState(int paymentId);
}
