package com.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.dao.ProductDAO;

import com.domain.Product;
import com.domain.ProductType;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);
	public static final String Property_productId = "productId";    	//Product字段productId
	public static final String ProductClassName = "Product";            //Product类的类名 
	public static final String ProductTypeClassName = "ProductType";    //ProductType类的类名
	public static final String productTypeClassName = "com.onlineflowershop.product.model.ProductType";    //ProductType类的类名
	public static final String classifyType = "classifyType";           //ProductType字段classifyType
	public static final String typeName = "typeName";                   //ProductType字段typeName
	
	ProductDAO productDao;
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * 查找所有产品
	 * @param message 在售的所有产品或所有产品
	 * @return
	 */
	public List<Product> findProduct(String message,int amount){
		List<Product> list = productDao.findProduct(message,amount);
		return list;
	}
	
	/**
	 * 通过objId查找某分类
	 * @param objId
	 * @return
	 */
	public ProductType findProductTypeByObjId(int objId){
		ProductType productType = (ProductType)productDao.findTemplateByid(productTypeClassName, objId);
		return productType;
	}
	
	/**
	 * 查找一个产品
	 * 
	 */
	public Product findAProduct(String value){
		Product aproduct = null;
		List list = productDao.findByOneProperty(ProductClassName,Property_productId,value);
		if(list != null && !list.isEmpty())
		aproduct = (Product)list.get(0);		
		return aproduct;
	}
	
	/**
	 * 获取产品类别
	 */
	public List findAllProductClassifyType(){
		List allCliassifytype = productDao.findProductType();
		return allCliassifytype;
	}
	
	/**
	 * 获取某类别里的子类
	 */
	public List findTypeNameByProductClassifyType(String ClassifyType){
		List list = productDao.findByOneProperty(classifyType,ClassifyType);
		return list;
	}
			
	
	/**
	 * 查找产品分类
	 */
	public Map findProductType(){
		log.info("查找产品分类");
		Map productType =  new HashMap();
		List types = productDao.findProductType();
		Iterator iterator = types.iterator();
		while (iterator.hasNext()) {
			String type = (String)iterator.next();
			List subList = productDao.findByOneProperty(classifyType,type);
		productType.put(type, subList);
		}
		
		return productType;
	}
	
	/**
	 * 所有分类
	 * @return
	 */
	public List listProductType(){
		List list = productDao.listProductType();
		return list;
	}
	
	/**
	 * 查找类别，传一个类别名字，返回此小类类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName(String value){
		log.info("通过产品分类查找产品");
		List list = productDao.findByOneProperty(ProductTypeClassName,typeName,value);
		return list;
	}
	
	/**
	 * 查找类别，传一个大类类别名字，返回此大类类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByClassifyType(String value){
		List list = productDao.findByOneProperty(ProductTypeClassName,classifyType,value);
		return list;
	}
	
	/**
	 * 查找小类类别，传一个类别名字，和大类名返回此类别实例
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName_ClassifyType(String value,String value2){
		List list = productDao.findByTwoProperty(ProductTypeClassName, classifyType, typeName, value, value2);
		return list;
	}
	
	/**
	 * 查找最新产品
	 */
	public List findNewProduct(){
		List list = productDao.findNewProduct();
		return list;
	}		

	/**
	 * 查找购买最多的花
	 */
	public List findMostPopularProduct() {
		// TODO Auto-generated method stub
		List listRanking = productDao.findMostPopularProduct();
		return listRanking;
	}
	
	
	/**
	 * 查找最便宜的花
	 */
	public List findCheapestProduct() {
		// TODO Auto-generated method stub
		List cheapestRanking=productDao.findCheapestProduct();
		return cheapestRanking;
	}

	/**
	 * 页码算法
	 * @param productAmount 产品数量
	 * @param pageNumberStr 当前页码
	 * @param pageSize 页面产品数量大小
	 * @return
	 */
	public int[] pageNumber(int productAmount,String pageNumberStr,int pageSize){
		int[] paging = new int[2];
		int pageNumber = 1;
		pageNumber = Integer.parseInt(pageNumberStr);
		if(pageNumber <= 0){
			pageNumber = 1;
		}
		int totalPage = 1;
		if(productAmount > 0){
			totalPage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		}
		if(pageNumber > totalPage){
			pageNumber = totalPage;
		}
		paging[0] = pageNumber;
		paging[1] = totalPage;
		return paging;
	}
	
	/**
	 * 根据输入进行模糊查找
	 */
	public List searchingProduct(String keyword){
		List list = productDao.searchingProduct(keyword);
		return list;
	}

}

