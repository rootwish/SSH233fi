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
		<script type="text/javascript" src="manage/js/manage_check.js"></script>
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
#previewSmall,#previewBig   /*这个就是预览的DIV的ID*/   
{   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);   
}
-->
</style> 
</head>

	<body>
		<!--Start --><!--	
		<s:action name="allTypeAction" executeResult="false"></s:action>
 		
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
																				
								<form action="updateProductAction.action" method="post" enctype="multipart/form-data" onsubmit="return uppdateProductCheck();">
								<center><span class="left_bt">请填写需要修改的产品信息</span></center>
								<table>
								<tr>
									<td><span class="left_bt">产品代号:</span></td>
									<td><input type="text" disabled name="productId" value='<s:property value="#request.updateAProduct.productId"/>'></td>
								</tr>
								<tr>
									<td><span class="left_bt">产品名称:</span></td>
									<td><input type="text" name="productName" id="productName" value='<s:property value="#request.updateAProduct.productName"/>'></td>
								</tr>
								<tr>
									<td><span class="left_bt">材料:</span></td>
									<td><textarea name="feature" id="feature" rows="6" cols="50"><s:property value="#request.updateAProduct.feature"/></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">说明:</span></td>
									<td><textarea name="description" id="description" rows="6" cols="50"><s:property value="#request.updateAProduct.description"/></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">评语:</span></td>
									<td><textarea name="meaning" id="meaning" rows="6" cols="50"><s:property value="#request.updateAProduct.meaning"/></textarea></td>
								</tr>
								<tr>
									<td><span class="left_bt">市场价:</span></td>
									<td><input type="text" name="price" id="price" value='<s:property value="#request.updateAProduct.price"/>'></td>
								</tr>								
								<tr>
									<td><span class="left_bt">普通会员价:</span></td>
									<td>
									<s:iterator value="#request.updateAProduct.priceList">
									<s:if test="theCustomerType.objId==1">
									<input type="text" name="ordinary" id="ordinary" value='<s:property value="realPrice"/>'>
									</s:if>
									</s:iterator>
									</td>
								</tr>
								<tr>
									<td><span class="left_bt">vip会员价:</span></td>
									<td>
									<s:iterator value="#request.updateAProduct.priceList">
									<s:if test="theCustomerType.objId==2">
									<input type="text" name="vip" id="vip" value='<s:property value="realPrice"/>'>
									</s:if>
									</s:iterator>
									</td>
								</tr>									
								<tr>
									<td><span class="left_bt">产品状态:</span></td>
									<td>
									<s:if test="#request.updateAProduct.productState==1">
									<input type="radio" name="productState" value="1" checked />在售状态
											&nbsp;&nbsp;&nbsp;&nbsp;
   									<input type="radio" name="productState" value="0" />不在售状态
									</s:if>   											
   									<s:if test="#request.updateAProduct.productState==0">
   									<input type="radio" name="productState" value="1" />在售状态
											&nbsp;&nbsp;&nbsp;&nbsp;
   									<input type="radio" name="productState" value="0" checked />不在售状态
   									</s:if>
   									</td>
								</tr>
								</table>																						
									
								<div id="groupIdSelect">
								<span class="left_bt">请选择分类:（需要删除的请选择"删除"）</span>
								<div>   
								<s:iterator value="#request.updateAProduct.productType" status="num"> 
									 <select onchange="getTypeName(this.value,'oldType<s:property value='#num.getIndex()'/>');">
										<option selected value="">
											请选择分类
										</option>
										<!--<s:iterator value="#request.allType" status="dex">
										<s:set name="index" value="#dex.getIndex()"/>
										<s:if test="#request.allType.get(#index)==classifyType">
		              						<option value="<s:property value='#request.allType.get(#index)'/>" selected>
      											<s:property value="#request.allType.get(#index)"/>
											</option>
		              					</s:if>
		              					<s:else>
											 <option value="<s:property value='#request.allType.get(#index)'/>">
      											<s:property value="#request.allType.get(#index)"/>
											</option>
										</s:else>
										</s:iterator>
										</select>
										<select name="typeName" id="oldType<s:property value='#num.getIndex()'/>">
										<option value="<s:property value="typeName"/>" selected>
											<s:property value="typeName"/>
										</option>
										<option value="">
											删除
										</option>
									</select>
									<br/>
								</s:iterator>
								--><select name="groupId"
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
								<input type="file" name="myFile1"  onchange="preview(this,300,300,1);" />（如果不能预览图片，请在浏览器设置里将“将文件上载到服务器时包含本地目录路径”一项设置为“启动”）
								<div id="previewSmall">
								<img src="images/smallImg/<s:property value="#request.updateAProduct.smallImg"/>" width="300" height="300">
								</div><br/> 
								
								<span class="left_bt">请选择大图:</span>
								<input type="file" name="myFile2"  onchange="preview(this,500,500,2);" />
								
								<div id="previewBig">
								<img src="images/Flower_BigSize/<s:property value="#request.updateAProduct.bigImg"/>" width="500" height="500">
								</div><br/>
								<input type="hidden" name="objId" value="<s:property value="#request.updateAProduct.objId"/>">
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
		<!-- end -->		
	</body>
</html>