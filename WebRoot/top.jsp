<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="head.jsp" flush="true" />
		<div class="logoline">
			<div class="comWidth">
				<div class="logo fl">
					<a href="#"><img src="image/index-logo.jpg" alt="logo" width="190" height="60"></a>
				</div>
				<div class="search-box fl">
					<input type="text" class="search-text fl">
					<input type="button" value="搜 索" class="search-button fr">
				</div>
				<div class="search-car fr">
					<a href="shoppingCart.jsp"><span class="shoptext fl">购物车</span></a>
					<span class="shopnum fl">0</span>
				</div>
			</div>
		</div>
		<div class="navbox">
			<div class="comWidth">
				<div class="shopclass fl">
					<h3>全部商品分类<i></i></h3>
				</div>
				<div class="nav fl">
					<ul id="nav">
						<li><a href="productAction.action">首页</a></li>
						<li><a href="productAction.action?productTypeName=22">三只松鼠</a></li>
						<li><a href="productAction.action?productTypeName=33">周黑鸭</a></li>
						<li><a href="productAction.action?productTypeName=44">旺仔</a></li>
						<li><a href="productAction.action?productTypeName=55">乐事</a></li>
						<li><a href="productAction.action?productTypeName=56">良品铺子</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
