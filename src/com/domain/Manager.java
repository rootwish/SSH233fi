package com.domain;

public class Manager {
	//编号
	private Integer objId;
	//用户名
	private String managerId;
	private String ManagerName;
	//密码
	private String password;
	//邮箱
	private String email;
	//电话
	private String Phone;
	//QQ号
	private String qqNumber;
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String ManagerName) {
		this.ManagerName = ManagerName;
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
		Phone = phone;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	
}
