package com.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ManageDAO;

public class ManageDaoImpl extends HibernateDaoSupport implements ManageDAO{
//	private static final Log log = LogFactory.getLog(ManageDaoImpl.class);
	public static final String managerClassName="Manager";
	public static final String managerId = "ManagerId";
	public static final String password = "password";
	/**
	 * 通过类名查找所有实例
	 * @param className
	 * @return
	 */
	public List findAllTemplateByClassName(String className,Integer beginNum){
		String queryString ="From " + className + " as model where model.objId>=" + beginNum;
		List list = getHibernateTemplate().find(queryString);
		return list;
	}
	
	/**
	 * 通过Id查找实例
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId){
		Session session =super.getSessionFactory().getCurrentSession();
		Object object=session.get(className,objId);
		return object;
	}
	
	
	/**
	 * 提供一个字段及字段值，返回List
	 */
	public List findByOneProperty(String className,String property,Object value){
		String queryString = "From " + className + " as model where model." + property
		+ "= '" + value + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results = session.createQuery(queryString).list();
		return results;
	}
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByTwoProperty(String property1,String property2,Object value1,Object value2){
		String queryString = "From Manager as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "'";
		Session session =super.getSessionFactory().getCurrentSession();
		List results = session.createQuery(queryString).list();
		for(int i=0;i<results.size();i++){    System.out.println(results.get(i));}
		return results;
	}
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByThreeProperty(String className,String property1,String property2,String property3,Object value1,Object value2,Object value3){
		String queryString = "From " + className + " as model where model." + property1
		+ " = '" + value1 + "' and model." + property2 + " = '" + value2 + "' and model." + property3 + " = '" + value3 + "'";
		List results = getHibernateTemplate().find(queryString);
		return results;
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity){
		super.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity){
		Session session =super.getSessionFactory().getCurrentSession();
		session.update(entity);
		session.flush();
		//getHibernateTemplate().merge(entity);
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity){
		Session session =super.getSessionFactory().getCurrentSession();
		session.delete(entity);
		session.flush();
		//getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 根据提供时间比较支付时间来统计销售金额
	 * @param time1
	 * @param time2
	 */
	public List<Double> statistics(String time1,String time2){
		String querystring = "select sum(amount) from [payment] where convert(varchar(10),transTime,111)>='"+time1+"' and convert(varchar(10),transTime,111)<'"+time2+"' and paymentState=1;";
		List<Double> amount = this.getSession().createSQLQuery(querystring).list();
		return amount;
	}
	/**
	 * 查询在所提供时间段内的Top销鲜花
	 * @param time1
	 * @param time2
	 * @return
	 */
	public List  findTopSellFlower(String time1,String time2){
		String querystring1 = "select top 1 theproduct from [order] where orderstate>=2 and convert(varchar(10),ordertime,111)>='"+time1+"' and convert(varchar(10),ordertime,111)<'"+time2+"' group by theproduct order by count(theproduct)desc;";
		List<Integer> productId = this.getSession().createSQLQuery(querystring1).list();
		List theProduct=null;
		if(!productId.isEmpty()){
			String querystring2 = "from Product as model where model.objId="+productId.get(0);
			theProduct = getHibernateTemplate().find(querystring2);
		}
		return theProduct;
	} 
	/**
	 * 根据提供时间来统计分店销售金额
	 * @param time1
	 * @param time2
	 * @param areaId
	 * @return
	 */
	public List<Double> findDivisionOrderByTime(String time1,String time2,Integer areaId){
		String queryString = "select sum(model.amt) from Order as model where convert(varchar(10),model.orderTime,111)>='"+time1+"' and convert(varchar(10),model.orderTime,111)<'"+time2+"' and model.orderState>=2 and model.theConsignee.theArea="+areaId;
		List<Double> amount = getHibernateTemplate().find(queryString);
		return amount;
	}

	public List findByManagerIdPwd(Object managerName, Object pwd) {
		System.out.println("****findByManagerIdPwd****");
		List results=findByTwoProperty(managerId,password,managerName,pwd);
		return results;
	}
}
