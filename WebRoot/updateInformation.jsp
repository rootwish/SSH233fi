<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="js/checkUpdateInfo.js"></script>    
  </head>
  
  <body>
   		 <!-- head -->
		<jsp:include page="head.jsp"></jsp:include>
		<!-- position -->
		<div class="position">
   			 <a href="index.jsp">首页</a>   > <label>完善个人信息</label>
    	</div>
		<!-- content -->		
		<div class="regbodybox">
			<div class="content">
			<form action="updateInformation.action" method="post" onsubmit="return customerInfoCheck();">
			<table  border="0" cellspacing="0" cellpadding="3">
				<tr>
					<th bgcolor="#BF4D4D" colspan="3" valign="middle" align="center">
						<div style="color:#FFFFFF; align:center; font-size:30px; font-weight:bold; ">完善个人信息</div>
					</th>
				</tr>
				<tr>
					  <td width="45%"></td>
					  <td width="50%" align="left" >&nbsp;<font color="red"><s:actionerror /></font></td>
				</tr>
   				 <tr>
				      <td width="45%" align="right" ><span class="f14px">用户名：</span></td>
				      <td width="50%" align="left" >
        				${customer.customerId}
        			  </td>
        		</tr>       		
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">电子邮箱：</span></td>
				      <td width="50%" align="left"  >
        				<input type="text" name="email" id="email" value="${customer.email}"/>
        				<font color="red">*<span id="checkemailinfo"></span></font>
        			  </td>
        		</tr>
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">移动手机：</span></td>
				      <td width="50%" align="left"  >
        				<input type="text" name="Phone" id="Phone" value="${customer.phone}"/>
        				<font color="red"><span id="checkPhoneinfo"></span></font>
        			  </td>
        		</tr>
        		<tr>
				      <td width="45%" align="right" ><span class="f14px">QQ号码：</span></td>
				      <td width="50%" align="left"  >
        				<input type="text" name="qqNumber" id="qqNumber" value="${customer.qqNumber}"/>
        				<font color="red"><span id="checkqqNumberinfo"></span></font>
        			  </td>
        		</tr>
    			<tr>
			      <td align="center" colspan="2">
			      <span class="reg_postbtnbox">
			        <input type="submit" value="确&nbsp;认" id="submit"  />
			        <input type="reset" value="重&nbsp;置" id="reset" />
			      </span>
			      </td>
			    </tr>
			
			</table>
		</form>
			</div>
		</div>
		<!-- foot -->
  </body>
</html>
