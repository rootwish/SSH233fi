package com.dao;

import java.util.List;

import com.domain.Product;

public interface ProductDAO {
	
	/**
	 * 通过Id查找实例
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId);
	
	/**
	 * 查找所有产品
	 * @param message 在售状态的所有产品或所有产品
	 * @return
	 */
	public List<Product> findProduct(String message,int amount);
	
	
	/**
	 * 查找产品类型
	 * @return
	 */
	public List findProductType();
	
	/**
	 * 所有分类
	 * @return
	 */
	public List listProductType();
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String property,Object value);
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2);
	
	/**
	 * 查找购买最多的花
	 * @return
	*/
	public List findMostPopularProduct();
	
	/**
	 * 查找最便宜的花(鲜花哄抢)
	 * @return
	*/
	public List findCheapestProduct();
	
	/**
	 * 查找最新产品
	 * @return
	 */
	public List findNewProduct();
	
	/**
	 * 根据输入模糊查找产品
	 * @param keyword
	 * @return
	 */
	public List searchingProduct(String keyword);
	
}
