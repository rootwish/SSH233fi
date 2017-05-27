package com.service;

import java.util.List;
import java.util.Map;

import com.domain.Product;
import com.domain.ProductType;

public interface ProductService {
	
	/**
	 * 查找所有产品
	 * @param message 在售的所有产品或所有产品
	 * @return
	 */
	public List<Product> findProduct(String message,int amount);
	
	/**
	 * 查找一个产品
	 * @param value
	 * @return
	 */
	public Product findAProduct(String value);
	
	/**
	 * 获取产品类别
	 */
	public List findAllProductClassifyType();
	
	/**
	 * 获取某类别里的子类
	 */
	public List findTypeNameByProductClassifyType(String ClassifyType);
	
	/**
	 * 通过objId查找某分类
	 * @param objId
	 * @return
	 */
	public ProductType findProductTypeByObjId(int objId);
	
	/**
	 * 查找产品分类
	 * @return
	 */
	public Map findProductType();
	
	/**
	 * 所有分类
	 * @return
	 */
	public List listProductType();
	
	/**
	 * 查找类别，传一个类别名字，返回此小类类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName(String value);
	
	/**
	 * 查找类别，传一个大类类别名字，返回此大类类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByClassifyType(String value);
	
	/**
	 * 查找类别，传一个类别名字，和大类名返回此类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName_ClassifyType(String value,String value2);
	
	/**
	 * 查找最新产品
	 * @return
	 */
	public List findNewProduct();
	
	/**
	 * 查找购买最多的花
	 * @return
	 */
	public List findMostPopularProduct();
	
	/**
	 * 查找最便宜的花
	 * @return
	 */
	public List findCheapestProduct();
	
	/**
	 * 页码算法
	 * @param productAmount 产品数量
	 * @param pageNumberStr 当前页码
	 * @param pageSize 页面产品数量大小
	 * @return
	 */
	public int[] pageNumber(int productAmount,String pageNumberStr,int pageSize);
	
	/**
	 * 根据输入模糊查找产品
	 * @param keyword
	 * @return
	 */
	public List searchingProduct(String keyword);
	
}
