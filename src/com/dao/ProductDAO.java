package com.dao;

import java.util.List;

import com.domain.Product;

public interface ProductDAO {
	
	/**
	 * ͨ��Id����ʵ��
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId);
	
	/**
	 * �������в�Ʒ
	 * @param message ����״̬�����в�Ʒ�����в�Ʒ
	 * @return
	 */
	public List<Product> findProduct(String message,int amount);
	
	
	/**
	 * ���Ҳ�Ʒ����
	 * @return
	 */
	public List findProductType();
	
	/**
	 * ���з���
	 * @return
	 */
	public List listProductType();
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String property,Object value);
	
	/**
	 * �ṩ�����ֶμ��ֶ�ֵ������List
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2);
	
	/**
	 * ���ҹ������Ļ�
	 * @return
	*/
	public List findMostPopularProduct();
	
	/**
	 * ��������˵Ļ�(�ʻ�����)
	 * @return
	*/
	public List findCheapestProduct();
	
	/**
	 * �������²�Ʒ
	 * @return
	 */
	public List findNewProduct();
	
	/**
	 * ��������ģ�����Ҳ�Ʒ
	 * @param keyword
	 * @return
	 */
	public List searchingProduct(String keyword);
	
}
