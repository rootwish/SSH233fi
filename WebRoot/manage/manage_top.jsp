<%@ page language="java"  pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/manageSystem.css">
</head>
<body>
	<div class="top">
		<div class="top_right" >
		<s:if test="#session.manager !=null">
			<span> <a>${manager.managerName}</a>���ã���л��¼ʹ�ã�</span>
			<a href="managerExitAction"  id="out">�˳�</a>
			</s:if>
		</div>
	</div>
</body>
</html>
