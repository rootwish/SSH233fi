<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="js/js.js"></script>
  </head>
  
  <body>
	<div id="main">
		<div id="bill">
			<ul class="Slides">	
			<li><a href="productAction.action">test<img src="images/adver/gj1.jpg"></a></li>
			<li><img src="images/adver/gj2.jpg"></li>
			<li><a href="productAction.action?productTypeName=教师节"><img src="images/adver/gj1.jpg"></a></li>
			<li><a href="productAction.action?productTypeName=周黑鸭">周黑鸭</a></li>
			<li><img src="images/adver/gj2.jpg"></li>
			<li><a href="productAction.action?productTypeName=情人节"><img src="images/adver/gj3.jpg"></a></li>
			<li><img src="images/adver/gj4.jpg"></li>
			</ul>
			<s:iterator value="#application.product">
			
			<s:property value="productName"/>
			</s:iterator>
		</div>

	
	</div>
  </body>
</html>
