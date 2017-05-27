package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

//import com.onlineflowershop.management.model.Division;
//import com.onlineflowershop.management.model.Role;
//import com.onlineflowershop.management.model.User;
//import com.domain.Order;
//import com.onlineflowershop.order.model.Payment;
import com.domain.Manager;
import com.domain.Product;

public interface ManageService {
	/**
	 * 查找用户名和密码
	 * @param name
	 * @param pwd
	 * @return
	 */
	public List findByUserIdPwd(Object name,Object pwd);
	
	/**
	 * 传一个字符串，经过MD5经过加密后返回一个加密后的字符串
	 * @param password
	 * @return
	 */
	public String encoderByMd5(String password);
	
	/**
	 * 通过地区名找地区实例
	 * @param name
	 * @return
	 */
	public List findAreaByName(Object name);
	
	/**
	 * 通过Division的类名查找所有分店
	 * @param className
	 * @return
	 */
	public List findAllDivision(int theNum);
	
	/**
	 * 通过Id查找分部实例
	 * @param objId
	 * @return
	 */
	//public Division findDivisionByObjId(Integer objId);
	
	/**
	 * 通过Role的类名查找所有角色
	 * @param className
	 * @return
	 */
	public List findAllRole(int theNum);
	
	/**
	 * 通过Id查找角色实例
	 * @param objId
	 * @return
	 */
	//public Role findRoleByObjId(Integer objId);
	
	/**
	 * 通过Id查找后台用户实例
	 * @param objId
	 * @return
	 */
	//public User findUserByObjId(Integer objId);
	
	/**
	 * 通过role的id值查询后台用户
	 * @param objId
	 * @return
	 */
	public List findUserByRoleId(Integer objId);
	
	/**
	 * 通过division的id值查询后台用户
	 * @param objId
	 * @return
	 */
	public List findUserByDivisionId(Integer objId);
	
	/**
	 * 通过userId值查询后台用户
	 * @param objId
	 * @return
	 */
//	public List findUserByUserId(String objId);
//	
//	/**
//	 * 查询某地区的所有订单
//	 * @param objId
//	 * @return
//	 */
//	public List findOrderByArea(int theArea,int state);
//	
//	/**
//	 * 查询某地区某业务员的所有订单
//	 * @param objId
//	 * @return
//	 */
//	public List findOrderByAreaByClerk(int theArea,int theClerk,int state);
//	
//	/**
//	 * 查询未配送的订单
//	 * @param state
//	 * @return
//	 */
//	public List findNotDelivererOrder(int theArea,int state);
//	
//	/**
//	 * 查询配送中的订单
//	 * @param state
//	 * @return
//	 */
//	public List findFinishDelivererOrder(int theArea,int theDeliverer,int state);
	
	/**
	 * 通过id查找订单
	 * @param objId
	 * @return
	 */
	//public Order findOrderById(int objId);
	
	/**
	 * 通过id查找产品
	 * @param objId
	 * @return
	 */
	public Product findProductById(int objId);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity);
	
	/**
	 * 根据提供时间比较支付时间来统计销售金额
	 * @param time1
	 * @param time2
	 * @return
	 */
	/*检测管理员登陆*/
	public boolean checklogin(Object value1,Object value2);
	
	/*传一个管理员名，返回实例*/
	public Manager getManagerExample(String name);
	
//	public Double statistics(String time1,String time2);
//	/**
//	 * 查询在所提供时间段内的Top销鲜花
//	 * @param time1
//	 * @param time2
//	 * @return
//	 */
//	public List<Product>  findTopSellFlower(String time1,String time2);
//	/**
//	 * 根据提供时间来统计分店销售金额
//	 * @param time1
//	 * @param time2
//	 * @param areaId
//	 * @return
//	 */
//	public List<Double> findDivisionOrderByTime(String time1,String time2,Integer areaId);
//	/**
//	 * 构造左边导航栏
//	 * @return
//	 */
	//public Map manageLeft(User user);
		
}
