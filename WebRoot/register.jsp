<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<head>
	<meta charset="utf-8">
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="css/allstyle.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div class="header">
		<div class="logoline reg_logo">
			<div class="comWidth">
				<div class="logo fl">
					<a href="#"><img src="image/index-logo.jpg" alt="logo" width="190" height="60"></a>
				</div>
				<h3 class="welcome">欢迎注册</h3>
			</div>
		</div>
		<!--<div class="regBox">
			<ul class="reg_list clearfix">
				<li><span class="reg_item"><em>*</em>账户名:</span>
					<div class="reg_input">
						<input class="user_icon" type="text" value="邮箱/用户名/手机号">
					</div>
				</li>
				<li><span class="reg_item"><em>*</em>请设置密码:</span>
					<div class="reg_input">
						<input class="pass" type="password" value="">
					</div>
				</li>
				<li><span class="reg_item"><em>*</em>请确认密码:</span>
					<div class="reg_input">
						<input class="pass" type="password" value="">
					</div>
				</li>
				<li><span class="reg_item"><em>*</em>邮箱:</span>
					<div class="reg_input">
						<input type="text" value="">
					</div>
				</li>
				<li><span class="reg_item"><em>*</em>地址:</span>
					<div class="reg_input">
						<input type="text" value="">
					</div>
				</li>
				<li>
					<div class="center">
						<input type="checkbox" id="a1"><label class="iagree" for="a1">我已阅读并同意<a class="xieyi" href="#">《用户注册协议》</a></label>
					</div>
				</li>
				<li>
					<div class="center">
						<input type="button" class="sumbit">
					</div>
				</li>
			</ul>
			</div>
		</div>
		-->
		<div class="content" >
			<form action="register" method="post">
			<table  border="0" cellspacing="0" cellpadding="3" align="center">
				<tr>
					<td colspan="3" align="center" valign="middle" bgcolor="#BF4D4D">
						<div style="color:#FFFFFF; align:center; font-size:30px; font-weight:bold;">注册新会员</div>
					</td>
				</tr>
   				 <tr>
				      <td width="45%" align="right" ><span class="f14px">用户名：</span></td>
				      <td width="50%" align="left" >
        				<input type="text" name="username" id="username"
						onblur="checkusername()" onfocus="cleanusernameerror()" />
        				<font color="red">*<span id="checkusernameinfo"></span></font>
        			  </td>
        		</tr>
        		
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">密码：</span></td>
				      <td width="50%" align="left" >
        				<input type="password" name="password" id="password"
						onPropertyChange="checkpassword()" oninput="checkpassword()" onfocus="cleanpassworderror()" />
        				<font color="red">*<span id="checkpasswordinfo"></span></font>
        			  </td>
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">确认密码：</span></td>
				      <td width="50%" align="left"  >
        				<input type="password" name="repassword" id="repassword"
						onPropertyChange="checkrepassword()" oninput="checkrepassword()" onfocus="cleanrepassworderror()" />
        				<font color="red">*<span id="checkrepasswordinfo"></span></font>
        			  </td>
        		</tr>
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">电子邮箱：</span></td>
				      <td width="50%" align="left"  >
        				<input type="text" name="email" id="email"
						onPropertyChange="checkemail()" oninput="checkemail()" onfocus="cleanemailerror()" />
        				<font color="red">*<span id="checkemailinfo"></span></font>
        			  </td>
        		</tr>
    			<tr>
			      <td>&nbsp;</td>
			      <td align="left"><span class="reg_postbtnbox">
			        <input type="submit" value="提交注册信息" id="submit" onclick="check()" />
			      </span></td><td align="right">&nbsp;</td>
			    </tr>
			
			</table>
		</form>
			</div>
		<div class="hr_25"></div>
	</div>
	<div class="footer">
		<p><a href="#">公司介绍</a><i>|</i><a href="#">公司公告</a><i>|</i><a href="#">招纳贤才</a><i>|</i>客服热线：400-675-1234</p>
		<p>Copyright @ 2006-2016 版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373&nbsp;&nbsp;&nbsp;北京市公安局备案编号:123456789123</p>
		<p><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a>
		</p>
	</div>
</body>
</html>
