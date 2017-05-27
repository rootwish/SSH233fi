package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomerLoginCheck implements Filter {

	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {
	    response.setCharacterEncoding("GB2312");
	    PrintWriter out=response.getWriter();
		HttpSession session=((HttpServletRequest)request).getSession();
		if(session.getAttribute("customer")==null){
			out.print("<body bgcolor='#BF4D4D'>");
			out.print("<div align='center' ><br><br><br><br><br>");
			//out.print("<img src='../images/head/logo.png'><br>");
	 	    out.print("<br><b>�Բ����ף�����û�е�¼����ʱ��Ȩ���ʸ�ҳ�棡</b><br>");
	 	    out.print("<br><a href='../mainLogin.jsp' ><font size='5' color='white' ><b>�� ¼</b></font></a><br>");
	 	    out.print("<br><a href='../index.jsp' ><font size='5' color='white' ><b>������ҳ</b></font></a><br>");
	 	    out.print("</div>");
	 	   out.print("</body>");
	 	    return;
		}
     	else {
     		chain.doFilter(request, response);	
     	}
	}
}
