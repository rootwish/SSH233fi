<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/allstyle.css">
		<style>
.loginBox {
	width: 286px;
	border: 1px solid #ccc;
	padding: 40px 86px;
	position: relative;
}

.l_tit {
	color: #666;
	line-height: 20px;
}  /*与文本框之间的间距通过设置行高*/
.login_input {
	border: 1px solid #999;
	height: 32px;
	line-height: 32px\9;
	padding: 0 5px;
	width: 100%;
}



.pass {
	background: url(../image/sock.jpg) right center no-repeat;
}

.mb_10 {
	margin-bottom: 10px;
}

.auto_login {
	padding-top: 27px;
	padding-bottom: 28px;
}

.auto_login label {
	margin-right: 10px;
	position: relative;
	top: 1px;
	left: 2px;
}

.login_btn {
	display: inline-block;
	position: absolute;;
	left: 174px;
	bottom: 10px;
	border: 1px solid #ccc;
	padding: 5px;
}

.reset_btn {
	display: inline-block;
	position: absolute;;
	right: 174px;
	bottom: 10px;
	border: 1px solid #ccc;
	padding: 5px;
}

.login_partners {
	padding-top: 34px;
}

.login_list li {
	float: left;
	line-height: 20px;
}

.login_list span {
	color: #999;
	margin: 0 2px;
}

.link {
	width: 115px;
	height: 31px;
	line-height: 31px;
	background-color: #72bd56;
	position: absolute;
	right: -1px;
	bottom: -31px;
	color: #fff;
	text-align: center;
	font-size: 15px;
}

.loginBox a:hover {
	color: #fff;
}
.title{
	font-size:20px;
	text-indent:185px;
}
</style>
	</head>
	<body>
		<div class="header">
			<p class="title">修改密码</p>
			<div class="loginBox">
				<form action="" method="post" namespace="/">
					<span class="l_tit">旧密码:</span>
					<br />
					<input type="password" name="" class="login_input" id="" onblur=""
						onfocus="">
					<br />
					<span class="l_tit">新密码:</span>
					<input type="password" name="" class="login_input" id="" onblur=""
						onfocus="">
					<br />
					<span class="l_tit">确认密码:</span>
					<input type="password" name="" class="login_input" id="" onblur=""
						onfocus="">
					<br />
					<input type="submit" value="提交" class="login_btn" />
					&nbsp;
					<input type="reset" value="重置" class="reset_btn" />
				</form>
			</div>

		</div>
		<div class="hr_25"></div>
		</div>
		
	</body>
</html>
