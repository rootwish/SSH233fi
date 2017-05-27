package com.domain;

import java.util.Date;
import java.util.Set;

public class Customer {
	//���
	private Integer objId;
	//�û���
	private String customerId;
	//�û�����
	private String customerName;
	//����
	private String password;
	//����
	private String email;
	//�绰
	private String Phone;
	//QQ��
	private String qqNumber;
	//ע��ʱ��
	private Date registDate;
	//��������
	private Set order;
	//�ջ��˼���
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
