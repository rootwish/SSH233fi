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
		<title>��¼</title>
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
						��ӭ��½
					</h3>
				</div>
			</div>
			
			<div class="position">
				<a href="index.jsp">��ҳ</a> >
				<label>
					��½
				</label>
			</div>
			
			<div class="loginBox">
				<form action="login" method="post" namespace="/">
					<span class="l_tit">�û���:</span><br/>
					<input type="text" name="userName" class="login_input user_icon"/>
					<br />
					<span class="l_tit">����:</span><br/>
					<input type="password" name="password" class="login_input user_icon"/>
					<br />
					<input type="submit" value="��¼" class="login_btn"/>
					&nbsp;
					<input type="reset" value="����" class="reset_btn"/>
				</form>
				<br />
				<a href="register.jsp" class="link">���ע��&gt;&gt;</a>
			</div>
			
		</div>
		<div class="hr_25"></div>
		</div>
		<div class="footer">
			<p>
				<a href="#">��˾����</a><i>|</i><a href="#">��˾����</a><i>|</i><a href="#">�����Ͳ�</a><i>|</i>�ͷ����ߣ�400-675-1234
			</p>
			<p>
				Copyright @ 2006-2016
				��Ȩ����&nbsp;&nbsp;&nbsp;��ICP��09037834��&nbsp;&nbsp;&nbsp;��ICP֤B1034-8373&nbsp;&nbsp;&nbsp;�����й����ֱ������:123456789123
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
