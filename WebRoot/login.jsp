<%@ page language="java"  pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/allstyle.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
	</head>
	<body>
		<div class="header">
			<div class="logoline login_logo">
				<div class="comWidth">
					<div class="logo fl">
						<a href="index.jsp"><img src="image/index-logo.jpg" alt="logo"
								width="190" height="60">
						</a>
					</div>
					<h3 class="welcome">
						欢迎登陆
					</h3>
				</div>
			</div>
			
			<div class="position">
				<a href="index.jsp">首页</a> >
				<label>
					登陆
				</label>
			</div>
			
			<div class="loginBox">
				<form action="login" method="post" namespace="/">
					<span class="l_tit">用户名:</span><br/>
					<input type="text" name="userName" class="login_input user_icon"/>
					<br />
					<span class="l_tit">密码:</span><br/>
					<input type="password" name="password" class="login_input user_icon"/>
					<br />
					<input type="submit" value="登录" class="login_btn"/>
					&nbsp;
					<input type="reset" value="重置" class="reset_btn"/>
				</form>
				<br />
				<a href="register.jsp" class="link">免费注册&gt;&gt;</a>
			</div>
			
		</div>
		<div class="hr_25"></div>
		</div>
		<div class="footer">
			<p>
				<a href="#">公司介绍</a><i>|</i><a href="#">公司公告</a><i>|</i><a href="#">招纳贤才</a><i>|</i>客服热线：400-675-1234
			</p>
			<p>
				Copyright @ 2006-2016
				版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373&nbsp;&nbsp;&nbsp;北京市公安局备案编号:123456789123
			</p>
			<p>
				<a href="#"><img src="image/footer.jpg" alt="">
				</a><a href="#"><img src="image/footer.jpg" alt="">
				</a><a href="#"><img src="image/footer.jpg" alt="">
				</a><a href="#"><img src="image/footer.jpg" alt="">
				</a>
			</p>
		</div>
	</body>
</html>
