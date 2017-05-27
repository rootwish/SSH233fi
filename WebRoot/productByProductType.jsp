<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>产品分类</title>
  </head>
  
  <body>
  	<jsp:include page="top.jsp" flush="true" />
  
  	<div id="basicbody">
  		<div id="sidebar">
	    	
		</div>	
  		<div id=main> 			
  			 <div class="rmxhbox2">
  	 		<table>
  			<tr>
  				<td>
  				<div class="title"><p><font size="4" color="red"><b>分类产品</b></font></p><a href="/Flower" target="_blank" title="" class="rmxh_more"><span></span></a></div>
  				</td>
  			</tr>
  			<tr>
  				<td>
				<div class="content">  
				<s:iterator value="#request.productByTypeName">	
					<div class="pro_nbox2">
					<a href='productAction.action?productId=<s:property value="productId"/>' title='<s:property value="productName"/>' target="_blank">
						<img src='shops/<s:property value="smallImg"/>' alt='<s:property value="productName"/>' width="155" height="165" />
						<br /><s:property value="productName"/></a><br />
						<span class="old_price">市场价：￥<s:property value="price"/></span><br />
					<s:iterator value="priceList">
						<span class="now_price"><s:property value="theCustomerType.typeName"/>：<span class="color_hong">￥<s:property value="realPrice"/></span></span><br />
					</s:iterator>
					</div>
				</s:iterator>				
				</div>
				</td>
			</tr>
	 	</table>
		</div>
  	</div>
  </div>
  
  </body>
</html>
