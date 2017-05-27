package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.Manager;
import com.service.ManageService;
import com.opensymphony.xwork2.ActionSupport;

public class ManageLoginAction extends ActionSupport{
	private ManageService manageService;
	private Manager manager;
	private String username;
	private String password;

	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
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
	@Override
	public void validate(){
		//String passwordMD5 = manageService.encoderByMd5(password);
		if(manageService.findByUserIdPwd(username, password).isEmpty())
		{
			addActionError("用户名或密码错误");
	}
//			else{
//		manager = (Manager)manageService.findByUserIdPwd(username, password).get(0);
//		if(manager.getUserState().equals(0)){
//			addActionError("此用户已被冻结，请联系管理员!");			
////		}
//		}
						}
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//String passwordMD5 = manageService.encoderByMd5(password);
		if(!manageService.checklogin(getUsername(),getPassword())){
			addActionError("密码错误");
			return INPUT;
		}
		System.out.println(getUsername()+"**********"+getPassword());
		manager=manageService.getManagerExample(getUsername());
		/*
		manager = (Manager)manageService.findByUserIdPwd(username, password).get(0);*/
		session.setAttribute("user", manager);
		
		//Map left = manageService.manageLeft(manager);
		//session.setAttribute("title", left);
		//session.setAttribute("sub", left.keySet());
		return SUCCESS;
	}
}
