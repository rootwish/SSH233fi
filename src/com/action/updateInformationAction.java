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
	
	//�˿ͷ������
	private CustomerService customerservice;
	
	//����
	private String email;
	
	//�ƶ��绰
	private String Phone;
	
	//�칫�绰
	private String officePhone;
	
	//��ͥ�绰
	private String homePhone;
	
	//QQ��
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
	
	public boolean checknumber(String str){   //�жϺ���Ϊ�������͵ķ���
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
			addActionError("���䲻��Ϊ�գ�");
		}
		
		if(getPhone()!=null&&!getPhone().trim().equals("")){
			if(getPhone().trim().length()>11||getPhone().trim().length()<11){
				addActionError("�ֻ��������Ϊ11λ���֣����ĺ���Ϊ�Ƿ����룡");
			}
			else if(!checknumber(getPhone().substring(0, 10))){
				addActionError("�ֻ��������Ϊ�������ͣ����ĺ���Ϊ�Ƿ����룡");
			}
		}
		if(getOfficePhone()!=null&&!getOfficePhone().trim().equals("")){
			if(getOfficePhone().trim().length()>12||getOfficePhone().trim().length()<7){
				addActionError("�칫�绰�������Ϊ7-12λ���֣����ĺ���Ϊ�Ƿ����룡");
			}
			else if(!checknumber(getOfficePhone().trim())){
				addActionError("�칫�绰�������Ϊ�������ͣ����ĺ���Ϊ�Ƿ����룡");
			}
		}
		if(getHomePhone()!=null&&!getHomePhone().trim().equals("")){
			if(getHomePhone().trim().length()>12||getHomePhone().trim().length()<7){
				addActionError("��ͥ�绰�������Ϊ7-12λ���֣����ĺ���Ϊ�Ƿ����룡");
			}
			else if(!checknumber(getHomePhone().trim())){
				addActionError("��ͥ�绰�������Ϊ�������ͣ����ĺ���Ϊ�Ƿ����룡");
			}
		}
		
		if(getQqNumber()!=null&&!getQqNumber().trim().equals("")){
			if(!Pattern.matches("[0-9]{4,15}",getQqNumber())){
				addActionError("QQ�������Ϊ�������ͣ����ȱ�����4-15��������");
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
			customerservice.update(customer);                   //���¹˿���Ϣ	
			Map m = ActionContext.getContext().getSession();   //��customer�Ž�session����	
			m.put("customer", customer);
			return SUCCESS;
	}
	
	
}
