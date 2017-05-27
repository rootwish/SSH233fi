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
	 * 通过Id查找实例
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId){
		
		Object object = getHibernateTemplate().get(className,objId);
		return object;
	}
	
	/**
	 * 查找所有产品
	 * @param message 在售状态的所有产品或所有产品
	 * @return
	 */
	public List<Product> findProduct(String message,int amount){
		log.info("查找了产品信息");
		List<Product> results=null;
		String queryString="";
		if(message.equals("在售")){			
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
	 * 提供一个字段及字段值，返回List
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
	 * 查找产品类型
	 * @return
	 */
	public List findProductType() {
		String queryString = "select distinct model.classifyType from ProductType as model where model.objId>0";
		getHibernateTemplate().setMaxResults(1000);
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * 所有分类
	 * @return
	 */
	public List listProductType(){
		String queryString = "from ProductType as model where model.objId>0";
		getHibernateTemplate().setMaxResults(1000);
		List list = getHibernateTemplate().find(queryString);
		return list;
	}
	
	/**
	 * 提供一个产品类型名称
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
	 * 提供两个字段及字段值，返回List
	 */
	public List findByTwoProperty(String className,String property1,String property2,Object value1,Object value2){
		String queryString = "From " + className + " as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "'";
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * 查找购买最多的花
	*/
	public List findMostPopularProduct() {
		// TODO Auto-generated method stub
		String queryString="select top 6 theproduct from [order] where orderstate>=2 group by theproduct order by count(theproduct)desc";
		List sqlResult = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(queryString).list();
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("from Product as model where model.objId in (:id_list)");
		q.setParameterList("id_list", sqlResult);
		List results = q.list();
		log.info("查找到购买Top6的花");
		return results;
	}
	
	/**
	 * 查找最便宜的花（鲜花哄抢）
	*/
	public List findCheapestProduct() {
		// TODO Auto-generated method stub
		String queryString="from Product as model where model.price>0 order by model.price asc";
		getHibernateTemplate().setMaxResults(4);
		List results = getHibernateTemplate().find(queryString);
		log.info("查找Top4最便宜的花");
		return results;
	}
	
	/**
	 * 查找最新产品
	 */
	public List findNewProduct(){
		String queryString = "from Product as model where model.productState=1 order by model.objId desc";
		getHibernateTemplate().setMaxResults(4);
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * 根据输入模糊查找产品
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
