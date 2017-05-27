package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CustomerService;
import com.domain.Customer;

public class LoginAction extends ActionSupport {
	private String userName;
	private String password;
	private String errorMsg;
	//�˿ͷ������
	private CustomerService customerservice;
	//�˿Ͷ���
	private Customer customer;
	

	public CustomerService getCustomerservice() {
		return customerservice;
	}

	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
			//ActionContext.getContext().getSession().put("loginUser", new Customer(userName));
			
			//MD5����
		
			//password=customerservice.encoderByMd5(password);
			
			//�������
			if(!customerservice.checklogin(getUserName(),getPassword())){
				System.out.println(getUserName()+"******11*******"+getPassword());
				addActionError("�û������������");			
				if(session.getAttribute("shoppingCart") == null)
					return INPUT;
				else return "orderLoginInput";
			}
			System.out.println(getUserName()+"*******22******"+getPassword());
			//��¼�ɹ�
			customer = customerservice.getCustomerExample(getUserName());
			session.setAttribute("customer", customer);                    //��customer�Ž�session����
			if(session.getAttribute("shoppingCart") == null)
				return SUCCESS;
			else return "orderLoginSuccess";
		
	}
}
