<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
	<div id="classification">
 		
 		<h1 class="img">产品分类</h1>	
 		<ul>
  			<c:forEach varStatus="suff" var="names" items="${productType}">
  			<li><a class="catalog">
  				<table>
  					<tr align="left">
  						<td align="left"><img src="images/icons/pink-arrow-right.png" /></td>
  						<td height="23" valign="top" style="font-weight:bold; font-size:14px; color:#d02313" align="left">&nbsp;${names}</td>
  					</tr>
  				 </table>
  			<li id="OpenRep${suff.index}">
  			<table>
				<tr height="25"> 
			  		<c:forEach var="subList" varStatus="status" items="${TypeName[names]}"> 
			  		<td align="center" width="36%" height="22">
			  			<a href="productAction.action?productTypeName=${subList}">${subList}</a>   
			  		</td>
			   		<c:if test="${status.count % 2 eq 0 || status.count eq count}" var="test" scope="page">
			       <tr></tr>
			     </c:if>
			  </c:forEach>
			  </tr>
			  </table>
  		</c:forEach>
 		</ul>
	</div>
	</body>
</html>
