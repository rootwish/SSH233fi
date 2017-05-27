<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/allstyle.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body>
    <div class="header">
		<div class="topline">
			<div class="comWidth">
				<div class="fl">
					<a href="#" class="collection">收藏我们</a>
										<a href="/SSH233/manage/manage_login.jsp">后台登陆！</a>
				</div>
				<div class="fr">
						<s:if test="#session.customer ==null">
					欢迎来到网上零食商城！<a href="login.jsp">[登录]<a><a href="register.jsp">[注册]<a>
				</s:if>
				<s:else>
						 欢迎您！<a >${customer.customerId}</a>
						 <a href="updateInformation.jsp"><font color="#54CDF6">更改个人信息</font></a>	
						 <a href="ExitAction"><font color="#54CDF6">注销</font></a>			
						</s:else>
				</div>
			</div>
		</div>
  </body>
</html>
