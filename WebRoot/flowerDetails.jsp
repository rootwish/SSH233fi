<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>产品详细信息</title>
   
  </head>  
  <body>  

	<div id="basicbody">
		<jsp:include page="head.jsp" flush="true" />
		<!--  -->
		<div id="sideBar">
		</div>
		<!--  -->
		<div id=main>
	    		<jsp:include page="FlowerIntroduction.jsp"></jsp:include>
	    </div>
	    <div id="foot">
  				
  		</div>
	</div>
	
  </body>
</html>
