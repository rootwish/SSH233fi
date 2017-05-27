<%@ page language="java"  pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>管理中心</title>
</head>
<frameset rows="64,*" frameborder="no" border="0" framespacing="0">
 	<frame src="manage/manage_top.jsp" noresize="noresize" frameborder="0" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main"/>
 	<frameset cols="200,*" rows="560,*" id="frame">
 		<frame src="manage/manage_left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" scrolling="0" target="main"></frame>
 		<frame src="" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self"></frame>
 	</frameset>
 </frameset>
<noframes>
<body>
</body>
</noframes>
</html>