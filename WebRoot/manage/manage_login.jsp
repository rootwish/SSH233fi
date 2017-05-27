<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>后台登陆界面</title>
	<base href="<%=basePath%>">
	<script type="text/javascript" src="js/check.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/manageSystem.css">
</head>
<body>
	<div class="top">
		
	</div>
	<div class="center">
		<div class="left">
			left
		</div>
		<div class="right">
			<div class="clear">
				
			</div>
			<s:form class="table" method="post" action="manageLoginAction" namespace="/">
				<div class="table_box">
					<h4>网上零食商城后台管理</h4>
				管理员：<s:textfield type="text" name="username" id="username" onPropertyChange="checkLoginUserName()" oninput="checkLoginUserName()" onfocus="cleanUserNameError()" onblur="checkLoginUserName()" /> <font class="red">*</font><span id="checkManagerNameInfo"></span><br/><br/>
				密&nbsp;码：<s:password type="password" name="password" id="password" oninput="checkPassword()" onPropertyChange="checkPassword()" onfocus="cleanPasswordError()" onblur="checkPassword()" /> <font class="red">*</font><span id="checkManagerPassInfo"></span><br/><br/>
					<div class="button_box">
					<s:submit value="登陆" id="submit" onclick="loginCheck()"></s:submit>
					&nbsp;
					<s:reset type="reset" value="重置" onclick="submitDisabled()"></s:reset>
					</div>
				</div>
			</s:form>
		</div>
	</div>
	<div class="footer">
		copyright@www.OnlineSnack.com
	</div>
</body>
<script>
	window.onload=function(){
		submitDisabled();
	}
</script>
</html>
