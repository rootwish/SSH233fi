package com.service;

import java.util.List;
import java.util.Map;

import com.domain.Product;
import com.domain.ProductType;

public interface ProductService {
	
	/**
	 * �������в�Ʒ
	 * @param message ���۵����в�Ʒ�����в�Ʒ
	 * @return
	 */
	public List<Product> findProduct(String message,int amount);
	
	/**
	 * ����һ����Ʒ
	 * @param value
	 * @return
	 */
	public Product findAProduct(String value);
	
	/**
	 * ��ȡ��Ʒ���
	 */
	public List findAllProductClassifyType();
	
	/**
	 * ��ȡĳ����������
	 */
	public List findTypeNameByProductClassifyType(String ClassifyType);
	
	/**
	 * ͨ��objId����ĳ����
	 * @param objId
	 * @return
	 */
	public ProductType findProductTypeByObjId(int objId);
	
	/**
	 * ���Ҳ�Ʒ����
	 * @return
	 */
	public Map findProductType();
	
	/**
	 * ���з���
	 * @return
	 */
	public List listProductType();
	
	/**
	 * ������𣬴�һ��������֣����ش�С�����ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName(String value);
	
	/**
	 * ������𣬴�һ������������֣����ش˴������ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByClassifyType(String value);
	
	/**
	 * ������𣬴�һ��������֣��ʹ��������ش����ʵ��
	 * @param value
	 * @return
	 */
	public List findProductTypeByTypeName_ClassifyType(String value,String value2);
	
	/**
	 * �������²�Ʒ
	 * @return
	 */
	public List findNewProduct();
	
	/**
	 * ���ҹ������Ļ�
	 * @return
	 */
	public List findMostPopularProduct();
	
	/**
	 * ��������˵Ļ�
	 * @return
	 */
	public List findCheapestProduct();
	
	/**
	 * ҳ���㷨
	 * @param productAmount ��Ʒ����
	 * @param pageNumberStr ��ǰҳ��
	 * @param pageSize ҳ���Ʒ������С
	 * @return
	 */
	public int[] pageNumber(int productAmount,String pageNumberStr,int pageSize);
	
	/**
	 * ��������ģ�����Ҳ�Ʒ
	 * @param keyword
	 * @return
	 */
	public List searchingProduct(String keyword);
	
}
