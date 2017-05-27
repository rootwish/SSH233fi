package com.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dao.ManageDAO;
//import com.domain.Division;
//import com.onlineflowershop.management.model.LeftInfo;
//import com.onlineflowershop.management.model.Role;
import com.domain.Manager;
import com.service.ManageService;
//import com.onlineflowershop.order.model.Order;
//import com.onlineflowershop.order.model.Payment;
import com.domain.Product;

public class ManageSerivceImpl implements ManageService{
	public static final String userClassName = "Manager";
	public static final String UserClassName = "com.domain.User";
	public static final String userId = "ManagerId";
	public static final String userName = "ManagerName";
	public static final String password = "password";
	public static final String theDivision = "theDivision";
	public static final String theRole = "theRole";
	public static final String theCustomerType = "theCustomerType";
	public static final String areaClassName = "Area";
	public static final String areaName = "name";
	public static final String divisionClassName = "com.domain.Division";
	public static final String DivisionClassName = "Division";
	public static final String roleClassName = "com.domain.Role";
	public static final String orderClassName = "Order";
	public static final String OrderClassName = "com.domain.Order";
	public static final String orderState = "orderState";
	public static final String RoleClassName = "Role";
	public static final String ProductClassName = "com.domain.Product";
	
	private ManageDAO manageDao;

	public ManageDAO getManageDao() {
		return manageDao;
	}
	public void setManageDao(ManageDAO manageDao) {
		this.manageDao = manageDao;
	}
	/**
	 * 查找用户名和密码
	 * @param name
	 * @param pwd
	 * @return
	 */
	public List findByUserIdPwd(Object name,Object pwd){
		List results = manageDao.findByTwoProperty(userId,password,name,pwd);
		return results;
	}
	
	/**
	 *传一个字符串，经过MD5经过加密后返回一个加密后的字符串
	 */
	public String encoderByMd5(String password){
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// 信息摘要
		try
		{
			md = MessageDigest.getInstance("MD5");// 实例化
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digest.length; i++)
			{
				sb.append(Integer.toHexString(((int) digest[i]) & 0xFF));
			}
			resultString = sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return resultString;
	}
	
	
	/**
	 * 通过地区名找地区实例
	 * @param name
	 * @return
	 */
	public List findAreaByName(Object name){
		List results = manageDao.findByOneProperty(areaClassName,areaName,name);
		return results;
	}
	
	/**
	 * 通过Division的类名查找所有分店
	 * @param className
	 * @return
	 */
	public List findAllDivision(int theNum){
		List results = manageDao.findAllTemplateByClassName(DivisionClassName,theNum);
		return results;
	}
	
	/**
	 * 通过Id查找分部实例
	 * @param objId
	 * @return
	 */
//	public Division findDivisionByObjId(Integer objId){
//		Division division = (Division)manageDao.findTemplateByid(divisionClassName, objId);
//		return division;
//	}
	
	/**
	 * 通过Role的类名查找所有角色
	 * @param className
	 * @return
	 */
	public List findAllRole(int theNum){
		List results = manageDao.findAllTemplateByClassName(RoleClassName,theNum);
		return results;
	}
	
	/**
	 * 通过Id查找角色实例
	 * @param objId
	 * @return
	 */
//	public Role findRoleByObjId(Integer objId){
//		Role role = (Role)manageDao.findTemplateByid(roleClassName, objId);
//		return role;
//	}
	
	/**
	 * 通过Id查找后台用户实例
	 * @param objId
	 * @return
	 */
	public Manager findManagerByObjId(Integer objId){
		Manager manager = (Manager)manageDao.findTemplateByid(UserClassName, objId);
		return manager;
	}
	
	/**
	 * 通过role的id值查询后台用户
	 * @param objId
	 * @return
	 */
	public List findUserByRoleId(Integer objId){
		List list = manageDao.findByOneProperty(userClassName, theRole, objId);
		return list;
	}
	
	/**
	 * 通过division的id值查询后台用户
	 * @param objId
	 * @return
	 */
	public List findUserByDivisionId(Integer objId){
		List list = manageDao.findByOneProperty(userClassName, theDivision, objId);
		return list;
	}
	
	/**
	 * 通过userId值查询后台用户
	 * @param objId
	 * @return
	 */
	public List findUserByUserId(String objId){
		List list = manageDao.findByOneProperty(userClassName, userId, objId);
		return list;
	}
	
	/**
	 * 查询某地区的所有订单
	 * @param objId
	 * @return
	 */
//	public List findOrderByArea(int theArea,int state){
//		List list = manageDao.findByTwoProperty(orderClassName, "theConsignee.theArea", orderState, theArea, state);
//		return list;
//	}
	

	/**
	 * 查询某地区某业务员的所有订单
	 * @param objId
	 * @return
	 */
	public List findOrderByAreaByClerk(int theArea,int theClerk,int state){
		List list = manageDao.findByThreeProperty(orderClassName, "theConsignee.theArea", "theClerk", orderState, theArea, theClerk, state);
		return list;
	}
	
	/**
	 * 查询未配送的订单
	 * @param state
	 * @return
	 */
//	public List findNotDelivererOrder(int theArea,int state){
//		List list = manageDao.findByTwoProperty(orderClassName, "theConsignee.theArea", orderState, theArea, state);
//		return list;
//	}
	
	/**
	 * 查询配送中的订单
	 * @param state
	 * @return
	 */
	public List findFinishDelivererOrder(int theArea,int theDeliverer,int state){
		List list = manageDao.findByThreeProperty(orderClassName, "theConsignee.theArea", "theDeliverer", orderState, theArea, theDeliverer, state);
		return list;
	}
	
	/**
	 * 通过id查找订单
	 * @param objId
	 * @return
	 */
//	public Order findOrderById(int objId){
//		Order order = (Order)manageDao.findTemplateByid(OrderClassName, objId);
//		return order;
//	}
	
	/**
	 * 通过id查找产品
	 * @param objId
	 * @return
	 */
	public Product findProductById(int objId){
		Product product = (Product)manageDao.findTemplateByid(ProductClassName, objId);
		return product;
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity){
		manageDao.update(entity);
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity){
		manageDao.save(entity);
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity){
		manageDao.delete(entity);
	}
	/**
	 * 根据提供时间比较支付时间来统计销售金额
	 * @param time1
	 * @param time2
	 * @return
	 */
	public Double statistics(String time1,String time2){		
		Double amount = manageDao.statistics(time1, time2).get(0);
		return amount;
	}	
	/**
	 * 查询在所提供时间段内的Top销鲜花
	 * @param time1
	 * @param time2
	 * @return
	 */
	public List  findTopSellFlower(String time1,String time2){
		List<Product> product = manageDao.findTopSellFlower(time1,time2);
		return product;
	} 
	/**
	 * 根据提供时间来统计分店销售金额
	 * @param time1
	 * @param time2
	 * @param areaId
	 * @return
	 */
	public List<Double> findDivisionOrderByTime(String time1,String time2,Integer areaId){
		List<Double> amount = manageDao.findDivisionOrderByTime(time1, time2, areaId);
		return amount;
	}
	public boolean checklogin(Object value1, Object value2) {
		// TODO Auto-generated method stub
		System.out.println("****checklogin****");
		List list=manageDao.findByManagerIdPwd(value1,value2);
		if(list.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	public Manager getManagerExample(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	/**
//	 * 构造左边导航栏
//	 * @return
//	 */
//	public Map manageLeft(Manager manager){
//		Map left =  new LinkedHashMap();
//		String title;                                            //标题
//		LeftInfo leftInfo;                                      //子分类信息类  
//		List<LeftInfo> subList;                                 //标题下的子分类数组
//		String roleName = user.getTheRole().getName().trim();
//		if(roleName.equals("总经理")){
//			//第一个标题
//			title = "分店管理";
//			subList = new ArrayList<LeftInfo>();
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("增加分店");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_addBranch.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改分店");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_updateBranch.jsp");
//			subList.add(leftInfo);
//						
//			left.put(title, subList);
//			
//			//第二个标题
//			title = "产品维护";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("添加产品");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_addProduct.jsp");
//			subList.add(leftInfo);			
//						
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改产品");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_listProduct.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("添加分类");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_addProductType.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("所有分类");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_listProductType.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第三个标题
//			title = "用户管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("增加后台人员");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_addUser.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("所有后台人员");
//			leftInfo.setUrl("manage/manage_jsp/general_manager/manage_listUser.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第四个标题
//			title = "个人资料管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改登录密码");
//			leftInfo.setUrl("manage/manage_jsp/manage_changePassword.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改个人信息");
//			leftInfo.setUrl("manage/manage_jsp/updateUserInfo.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第五个标题
//			title = "统计业绩";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("总业绩统计");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_statistics.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//		}
//		
//		if(roleName.equals("地区经理")){
//			//第一个标题
//			title = "用户管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("增加本店人员");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_addUser.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("本店所有人员");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_listUser.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第二个标题
//			title = "个人资料管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改登录密码");
//			leftInfo.setUrl("manage/manage_jsp/manage_changePassword.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改个人信息");
//			leftInfo.setUrl("manage/manage_jsp/updateUserInfo.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第三个标题
//			title = "统计业绩";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("分店业绩统计");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_statistics.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//		}
//		
//		if(roleName.equals("业务员")){						
//			//第一个标题
//			title = "个人资料管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改登录密码");
//			leftInfo.setUrl("manage/manage_jsp/manage_changePassword.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改个人信息");
//			leftInfo.setUrl("manage/manage_jsp/updateUserInfo.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第二个标题
//			title = "订单管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("发生产单");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_sendProduction.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("收生产单");
//			leftInfo.setUrl("manage/manage_jsp/general_local_manager/manage_finishProduction.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//		}
//		
//		if(roleName.equals("配送员")){	
//			//第一个标题
//			title = "订单管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("配送订单");
//			leftInfo.setUrl("manage/manage_jsp/deliverer_manager/manage_notDeliverer.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("完成配送");
//			leftInfo.setUrl("manage/manage_jsp/deliverer_manager/manage_finishDeliverer.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			//第二个标题
//			title = "个人资料管理";
//			subList = new ArrayList<LeftInfo>();
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改登录密码");
//			leftInfo.setUrl("manage/manage_jsp/manage_changePassword.jsp");
//			subList.add(leftInfo);
//			
//			leftInfo = new LeftInfo();
//			leftInfo.setName("修改个人信息");
//			leftInfo.setUrl("manage/manage_jsp/updateUserInfo.jsp");
//			subList.add(leftInfo);
//			
//			left.put(title, subList);
//			
//			
//		}
		
	
}
