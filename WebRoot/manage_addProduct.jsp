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
		<link rel="stylesheet" type="text/css" href="manage/css/skin.css" >
		<link rel="stylesheet" type="text/css" href="css/basic.css">
		<script type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="manage/js/manage_js.js"></script>
		<script type="text/javascript" src="manage/js/manage_check.js"></script>
		
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}


#previewSmall,#previewBig   /*这个就是预览的DIV的ID*/   
{   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);   
}
-->
</style> 
</head>

<body>
<!--<s:action name="allTypeAction" executeResult="false"></s:action>
--><table width="100%" border="0" cellpadding="0" cellspacing="0">
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
							
							
								<form action="addProductAction.action" method="post" enctype="multipart/form-data" onsubmit="return addProductCheck();">
								<center><span class="left_bt">请填写产品信息</span></center>
								
								<table>
								<tr>
									<td><span class="left_bt">产品代号:</span></td>
									<td><input type="text" name="productId"></td>
								</tr>
								<tr>
									<td><span class="left_bt">产品名称:</span></td>
									<td><input type="text" name="productName" id="productName"></td>
								</tr>
								<tr>
									<td><span class="left_bt">材料:</span></td>
									<td><textarea name="feature" id="feature" rows="6" cols="50"></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">说明:</span></td>
									<td><textarea name="description" id="description" rows="6" cols="50"></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">花语:</span></td>
									<td><textarea name="meaning" id="meaning" rows="6" cols="50"></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">市场价:</span></td>
									<td><input type="text" name="price" id="price"></td>
								</tr>
								<tr>
									<td><span class="left_bt">普通会员价:</span></td>
									<td><input type="text" name="ordinary" id="ordinary"></td>
								</tr>
								<tr>
									<td><span class="left_bt">vip会员价:</span></td>
									<td><input type="text" name="vip" id="vip"></td>
								</tr>
								<tr>
									<td><span class="left_bt">产品状态:</span></td>
									<td><input type="radio" name="productState" value="1" checked />在售状态 
   											&nbsp;&nbsp;&nbsp;&nbsp;
   										<input type="radio" name="productState" value="0" />不在售状态</td>
								</tr>
								</table>
								
								
								<div id="groupIdSelect">
								<span class="left_bt">请选择分类:</span>
								<div>   
									 <select name="groupId"
										onchange="getTypeName(this.value,'idName1');">
										<option selected value="">
											请选择分类
										</option>
										<!--<s:iterator value="#request.allType" status="dex">
										<s:set name="index" value="#dex.getIndex()"/>
											 <option value="<s:property value='#request.allType.get(#index)'/>">
      											<s:property value="#request.allType.get(#index)"/>
											</option>
										</s:iterator>
										--></select>
										<select name="typeName" id="idName1">
										<option value="" selected>
											请选择子类
										</option>
									</select>
									<input type="button" value="新增" onclick="newSelect()" />
								</div>
								</div>
								<span class="left_bt">请选择小图:</span>
								<input type="file" name="myFile" id="myFile1" onchange="preview(this,300,300,1);" />（如果不能预览图片，请在浏览器设置里将“将文件上载到服务器时包含本地目录路径”一项设置为“启动”）
								<div id="previewSmall"></div><br/> 
								
								<span class="left_bt">请选择大图:</span>
								<input type="file" name="myFile" id="myFile2" onchange="preview(this,500,500,2);" />
								
								<div id="previewBig"></div><br/>
								<center><input type ="submit" value="提交" id= "sub"/></center>
								</form>
							

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