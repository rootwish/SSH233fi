package com.domain;

import java.util.Date;
import java.util.Set;

public class Customer {
	//编号
	private Integer objId;
	//用户名
	private String customerId;
	//用户姓名
	private String customerName;
	//密码
	private String password;
	//邮箱
	private String email;
	//电话
	private String Phone;
	//QQ号
	private String qqNumber;
	//注册时间
	private Date registDate;
	//订单集合
	private Set order;
	//收货人集合
	private Set consignee;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Set getOrder() {
		return order;
	}
	public void setOrder(Set order) {
		this.order = order;
	}
	public Set getConsignee() {
		return consignee;
	}
	public void setConsignee(Set consignee) {
		this.consignee = consignee;
	}
	
	
}
