<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>
		<link href="manage/css/skin.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/basic.css">
		<script type="text/javascript" src="manage/js/manage_js.js"></script>
	 	<script type="text/javascript" src="js/js.js"></script>  
		
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
-->
</style>
	</head>
  
  <body>
  	<s:action name="allProductsAction" executeResult="false" namespace="/"></s:action>
  	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="17" valign="top"
					background="manage/images/mail_leftbg.gif">
					<img src="manage/images/left-top-right.gif" width="17" height="29" />
				</td>
				<td valign="top" background="manage/images/content-bg.gif">
				</td>
				<td width="16" valign="top"
					background="manage/images/mail_rightbg.gif">
					<img src="manage/images/nav-right-bg.gif" width="16" height="29" />
				</td>
			</tr>
			<tr>
				<td valign="middle" background="manage/images/mail_leftbg.gif">
					&nbsp;
				</td>
				<td valign="top" bgcolor="#F7F8F9">
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td colspan="2" valign="top">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
							<td valign="top">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" valign="top">
  		
  		<div id="orderLists">
  		<br>
  		<center><span class="left_bt">所有产品列表</span></center>
  		<br>
  		<center>
    	<table border="2">
    		<tr>
				<td>  																	
				<s:iterator value="#request.AllProducts">
				<tr>						
					<td valign="middle" align="center">											
					<img src='images/smallImg/<s:property value="smallImg"/>' alt='<s:property value="productName"/>' width="60" height="65" />
					<br />
					</td>
					<td><s:property value="productName"/><br /></td>
					<td>
					<s:if test="productState==0">不在售</s:if>
					<s:if test="productState==1">在售</s:if>
					</td>
					<td valign="middle" align="center">
					<a href='findAProdictInfoAction.action?objId=<s:property value="objId"/> '><font color='red'>修改</font></a>
					</td>
					<td>
					<a href='deleteProductAction.action?objId=<s:property value="objId"/> '><font color='red'>删除</font></a>
					</td>
				</tr>
				</s:iterator>								
				</td>
			</tr>
			<tr>
				<td colspan="5">
				<div align="center">
					<font size="3">					
					<s:property value="#request.pageNumber"/>/<s:property value="#request.totalPage"/>
					</font>
					<a class="maroon" href="allProductsAction.action?pageNumber=1"><font size="3"><b>首页</b></font></a>
					<s:if test="#request.pageNumber==1"><font size="3">上一页</font></s:if>
					<s:if test="#request.pageNumber!=1">
					<a class="maroon" href="allProductsAction.action?pageNumber=<s:property value="#request.pageNumber-1"/>"><font size="3"><b>上一页</b></font></a>
					</s:if>
					<s:if test="#request.pageNumber==#request.totalPage"><font size="3">下一页</font></s:if>
					<s:if test="#request.pageNumber!=#request.totalPage">
					<a class="maroon" href="allProductsAction.action?pageNumber=<s:property value="#request.pageNumber+1"/>"><font size="3"><b>下一页</b></font></a>
					</s:if>
					<a class="maroon" href="allProductsAction.action?pageNumber=<s:property value="#request.totalPage"/>"><font size="3"><b>末页</b></font></a>				   
				</div>
				</td>
			</tr>
    	</table>
    	</center>
    	</div>
    	
    						</td>
						</tr>
					</table>
				</td>
				<td background="manage/images/mail_rightbg.gif">
					&nbsp;
				</td>
			</tr>
			
			<tr>
				<td valign="bottom">
					<img src="manage/images/buttom_left2.gif" width="17" height="17" />
				</td>
				<td background="manage/images/buttom_bgs.gif">
					<img src="manage/images/buttom_bgs.gif" width="17" height="17">
				</td>
				<td valign="bottom">
					<img src="manage/images/buttom_right2.gif" width="16" height="17" />
				</td>
			</tr>
		</table>
  </body>
</html>
