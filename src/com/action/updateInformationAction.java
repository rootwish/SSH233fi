package com.action;

import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Customer;
//import com.domain.CustomerType;
import com.service.CustomerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateInformationAction extends ActionSupport{
	
	//顾客服务对象
	private CustomerService customerservice;
	
	//邮箱
	private String email;
	
	//移动电话
	private String Phone;
	
	//办公电话
	private String officePhone;
	
	//家庭电话
	private String homePhone;
	
	//QQ号
	private String qqNumber;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	public boolean checknumber(String str){   //判断号码为数字类型的方法
		boolean flag=true;
		int number;
		try{
			number=Integer.parseInt(str);
		}catch(Exception ex){
			flag=false;			
		}
		return flag;
	}
	
	public void validate(){
		if(getEmail()==null||getEmail().trim().equals("")){
			addActionError("邮箱不能为空！");
		}
		
		if(getPhone()!=null&&!getPhone().trim().equals("")){
			if(getPhone().trim().length()>11||getPhone().trim().length()<11){
				addActionError("手机号码必须为11位数字，您的号码为非法号码！");
			}
			else if(!checknumber(getPhone().substring(0, 10))){
				addActionError("手机号码必须为数字类型，您的号码为非法号码！");
			}
		}
		if(getOfficePhone()!=null&&!getOfficePhone().trim().equals("")){
			if(getOfficePhone().trim().length()>12||getOfficePhone().trim().length()<7){
				addActionError("办公电话号码必须为7-12位数字，您的号码为非法号码！");
			}
			else if(!checknumber(getOfficePhone().trim())){
				addActionError("办公电话号码必须为数字类型，您的号码为非法号码！");
			}
		}
		if(getHomePhone()!=null&&!getHomePhone().trim().equals("")){
			if(getHomePhone().trim().length()>12||getHomePhone().trim().length()<7){
				addActionError("家庭电话号码必须为7-12位数字，您的号码为非法号码！");
			}
			else if(!checknumber(getHomePhone().trim())){
				addActionError("家庭电话号码必须为数字类型，您的号码为非法号码！");
			}
		}
		
		if(getQqNumber()!=null&&!getQqNumber().trim().equals("")){
			if(!Pattern.matches("[0-9]{4,15}",getQqNumber())){
				addActionError("QQ号码必须为数字类型！长度必须在4-15个数字内");
			}
		}
		
	}
	
	public String execute(){
			Map session = ActionContext.getContext().getSession();
			Customer customer = (Customer)session.get("customer");
			customer.setEmail(email);
			customer.setPhone(Phone);
			//customer.setOfficePhone(officePhone);
			//customer.setHomePhone(homePhone);
			customer.setQqNumber(qqNumber);			
			customerservice.update(customer);                   //更新顾客信息	
			Map m = ActionContext.getContext().getSession();   //把customer放进session里面	
			m.put("customer", customer);
			return SUCCESS;
	}
	
	
}
