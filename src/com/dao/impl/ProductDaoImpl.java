package com.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ProductDAO;
import com.domain.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDAO{
	private static final Log log = LogFactory.getLog(ProductDaoImpl.class);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId){
		
		Object object = getHibernateTemplate().get(className,objId);
		return object;
	}
	
	/**
	 * �������в�Ʒ
	 * @param message ����״̬�����в�Ʒ�����в�Ʒ
	 * @return
	 */
	public List<Product> findProduct(String message,int amount){
		log.info("�����˲�Ʒ��Ϣ");
		List<Product> results=null;
		String queryString="";
		if(message.equals("����")){			
			queryString = "from Product as model where model.objId>0 and model.productState=1";
			Query query = super.getSessionFactory().getCurrentSession().createQuery(queryString);
			query.setMaxResults(amount);
			results = query.list();
		}else{
			queryString = "from Product as model where model.objId>0";
			Query query = super.getSessionFactory().getCurrentSession().createQuery(queryString);
			query.setMaxResults(amount);
			results = query.list();
		}
		return results;
	}
		
	/**
	 * �ṩһ���ֶμ��ֶ�ֵ������List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value){
		String queryString = "From " + className + " as model where model." + property
		+ "= '" + value + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results=session.createQuery(queryString).list();
		return results;
	}
	
	/**
	 * ���Ҳ�Ʒ����
	 * @return
	 */
	public List findProductType() {
		String queryString = "select distinct model.classifyType from ProductType as model where model.objId>0";
		getHibernateTemplate().setMaxResults(1000);
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * ���з���
	 * @return
	 */
	public List listProductType(){
		String queryString = "from ProductType as model where model.objId>0";
		getHibernateTemplate().setMaxResults(1000);
		List list = getHibernateTemplate().find(queryString);
		return list;
	}
	
	/**
	 * �ṩһ����Ʒ��������
	 */
	public List findByOneProperty(String property,Object value){
		String queryString = "select model.typeName from ProductType as model where model." + property
		+ "= '" + value + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results=session.createQuery(queryString).list();
		//session.flush();
		return results;
	}
	
	/**
	 * �ṩ�����ֶμ��ֶ�ֵ������List
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2){
		String queryString = "From " + className + " as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "'";
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * ���ҹ������Ļ�
	*/
	public List findMostPopularProduct() {
		// TODO Auto-generated method stub
		String queryString="select top 6 theproduct from [order] where orderstate>=2 group by theproduct order by count(theproduct)desc";
		List sqlResult = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(queryString).list();
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("from Product as model where model.objId in (:id_list)");
		q.setParameterList("id_list", sqlResult);
		List results = q.list();
		log.info("���ҵ�����Top6�Ļ�");
		return results;
	}
	
	/**
	 * ��������˵Ļ����ʻ�������
	*/
	public List findCheapestProduct() {
		// TODO Auto-generated method stub
		String queryString="from Product as model where model.price>0 order by model.price asc";
		getHibernateTemplate().setMaxResults(4);
		List results = getHibernateTemplate().find(queryString);
		log.info("����Top4����˵Ļ�");
		return results;
	}
	
	/**
	 * �������²�Ʒ
	 */
	public List findNewProduct(){
		String queryString = "from Product as model where model.productState=1 order by model.objId desc";
		getHibernateTemplate().setMaxResults(4);
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * ��������ģ�����Ҳ�Ʒ
	 * @param keyword
	 * @return
	 */
	public List searchingProduct(String keyword){
		String queryString = "from Product as model where (model.productName like'%" + keyword + "%' " +
				"or model.feature like'%" + keyword + "%' or model.description like'%" + keyword + "%' " +
				"or model.meaning like'%" + keyword + "%') order by model.objId desc";
		Query query = super.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setMaxResults(10);
		List results = query.list();		 			
		return results;
	}
		
}
