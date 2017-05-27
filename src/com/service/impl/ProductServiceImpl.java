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
	public static final String Property_productId = "productId";    	//Product�ֶ�productId
	public static final String ProductClassName = "Product";            //Product������� 
	public static final String ProductTypeClassName = "ProductType";    //ProductType�������
	public static final String productTypeClassName = "com.onlineflowershop.product.model.ProductType";    //ProductType�������
	public static final String classifyType = "classifyType";           //ProductType�ֶ�classifyType
	public static final String typeName = "typeName";                   //ProductType�ֶ�typeName
	
	ProductDAO productDao;
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * �������в�Ʒ
	 * @param message ���۵����в�Ʒ�����в�Ʒ
	 * @return
	 */
	public List<Product> findProduct(String message,int amount){
		List<Product> list = productDao.findProduct(message,amount);
		return list;
	}
	
	/**
	 * ͨ��objId����ĳ����
	 * @param objId
	 * @return
	 */
	public ProductType findProductTypeByObjId(int objId){
		ProductType productType = (ProductType)productDao.findTemplateByid(productTypeClassName, objId);
		return productType;
	}
	
	/**
	 * ����һ����Ʒ
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
	 * ��ȡ��Ʒ���
	 */
	public List findAllProductClassifyType(){
		List allCliassifytype = productDao.findProductType();
		return allCliassifytype;
	}
	
	/**
	 * ��ȡĳ����������
	 */
	public List findTypeNameByProductClassifyType(String ClassifyType){
		List list = productDao.findByOneProperty(classifyType,ClassifyType);
		return list;
	}
			
	
	/**
	 * ���Ҳ�Ʒ����
	 */
	public Map findProductType(){
		log.info("���Ҳ�Ʒ����");
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
	 * ���з���
	 * @return
	 */
	public List listProductType(){
		List list = productDao.listProductType();
		return list;
	}
	
	/**
	 * ������𣬴�һ��������֣����ش�С�����ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName(String value){
		log.info("ͨ����Ʒ������Ҳ�Ʒ");
		List list = productDao.findByOneProperty(ProductTypeClassName,typeName,value);
		return list;
	}
	
	/**
	 * ������𣬴�һ������������֣����ش˴������ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByClassifyType(String value){
		List list = productDao.findByOneProperty(ProductTypeClassName,classifyType,value);
		return list;
	}
	
	/**
	 * ����С����𣬴�һ��������֣��ʹ��������ش����ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName_ClassifyType(String value,String value2){
		List list = productDao.findByTwoProperty(ProductTypeClassName, classifyType, typeName, value, value2);
		return list;
	}
	
	/**
	 * �������²�Ʒ
	 */
	public List findNewProduct(){
		List list = productDao.findNewProduct();
		return list;
	}		

	/**
	 * ���ҹ������Ļ�
	 */
	public List findMostPopularProduct() {
		// TODO Auto-generated method stub
		List listRanking = productDao.findMostPopularProduct();
		return listRanking;
	}
	
	
	/**
	 * ��������˵Ļ�
	 */
	public List findCheapestProduct() {
		// TODO Auto-generated method stub
		List cheapestRanking=productDao.findCheapestProduct();
		return cheapestRanking;
	}

	/**
	 * ҳ���㷨
	 * @param productAmount ��Ʒ����
	 * @param pageNumberStr ��ǰҳ��
	 * @param pageSize ҳ���Ʒ������С
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
	 * �����������ģ������
	 */
	public List searchingProduct(String keyword){
		List list = productDao.searchingProduct(keyword);
		return list;
	}

}

