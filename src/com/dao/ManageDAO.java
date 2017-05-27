package com.dao;


import java.util.List;


public interface ManageDAO {
	
	/**
	 * 通过类名查找所有实例
	 * @param className
	 * @return
	 */
	public List findAllTemplateByClassName(String className,Integer beginNum);
	
	/**
	 * 通过Id查找实例
	 * @param className
	 * @param objId
	 * @return
	 */
	public Object findTemplateByid(String className,Integer objId);
	
	/**
	 * 提供一个字段及字段值，返回List
	 * @param property
	 * @param value
	 * @return
	 */
	public List findByOneProperty(String className,String property,Object value);
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByTwoProperty(String property1,String property2,Object value1,Object value2);
	
	/**
	 * 提供两个字段及字段值，返回List
	 */
	public List findByThreeProperty(String className,String property1,String property2,String property3,Object value1,Object value2,Object value3);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity);

	/**
	 * 根据提供时间比较支付时间来统计销售金额
	 * @param time1
	 * @param time2
	 */
	public List<Double> statistics(String time1,String time2);
	/**
	 * 查询在所提供时间段内的Top销鲜花
	 * @param time1
	 * @param time2
	 * @return
	 */
	public List  findTopSellFlower(String time1,String time2);
	/**
	 * 根据提供时间来统计分店销售金额
	 * @param time1
	 * @param time2
	 * @param areaId
	 * @return
	 */
	public List<Double> findDivisionOrderByTime(String time1,String time2,Integer areaId);
	
	/*根据用户名密码查找*/
	public List findByManagerIdPwd(Object managerName,Object pwd);
}
