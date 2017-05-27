package com.action;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;




import com.domain.Customer;
import com.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;


public class registerAction extends ActionSupport{
	
	//�˿Ͷ���
	private Customer customer;
	
	//�˿����ͣ���ͨ��vip��
	//private CustomerType customerType;
	
	//�˿ͷ������
	private CustomerService customerservice;
	
	//��¼��
	private String username;
	
	//��¼����
	private String password;
	
	//����
	private String email;
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public CustomerService getCustomerservice() {
		return customerservice;
	}
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public String execute(){
		customer.setCustomerId(username);
		//password=customerservice.encoderByMd5(password);   //MD5����
		customer.setPassword(password);
		customer.setEmail(email);
		//customerType = customerservice.getCustomerTypeExample("��ͨ");
		//customer.setTheCustomerType(customerType);
		//customer.setRegistDate(new Date());
		customerservice.add(customer);                     //���ӹ˿�
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);                    //��customer�Ž�session����
	return SUCCESS;
	
	}

	
}
