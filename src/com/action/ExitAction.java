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
		//String exit = request.getParameter("exit");  //��־ ��ֵΪ��true��ʱ �˳�
		
		
//			//���session����ص���Ϣ
//			session.remove("customer");   //����˿���Ϣ
//			session.remove("manager");   //����˿���Ϣ
//			session.remove("shoppingCart");  //������ﳵ�����Ʒ
//			session.remove("totalOMoney");   //������ﳵ����ͨ�ܼ۸�
//			session.remove("totalVMoney");   //������ﳵ��vip�ܼ۸�
			ActionContext.getContext().getSession().clear();
			ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
}
