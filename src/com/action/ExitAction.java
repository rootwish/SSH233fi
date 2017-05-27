package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport{

	public String execute(){
		//Map session=ActionContext.getContext().getSession();
		//String exit = request.getParameter("exit");  //标志 当值为“true”时 退出
		
		
//			//清除session里相关的信息
//			session.remove("customer");   //清除顾客信息
//			session.remove("manager");   //清除顾客信息
//			session.remove("shoppingCart");  //清除购物车里的商品
//			session.remove("totalOMoney");   //清除购物车里普通总价格
//			session.remove("totalVMoney");   //清除购物车里vip总价格
			ActionContext.getContext().getSession().clear();
			ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
}
