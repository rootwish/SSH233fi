<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>���������� | �ʻ�ר��</title>
  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
    	<div id="basicbody">
    	
    		<div id="sidebar">
	    		
	    	</div>
	    	<div id=main>
				<!-- �����ʻ�start -->
				<div class="rmxhbox2">
				  	<table  border="-1">
		  				<tr bgcolor="#BF4D4D" valign="middle">
		  					<td align="left" width="200px" height="40px">  			
		  					<font size="4" color="white" face="����">&nbsp;<b>�ʻ�ר��</b></font>		  
		  					</td>
		  				</tr>
				  		<tr>
				  		<td>
						<div class="content">  						
						<s:iterator value="#request.ThemeProduct">	
						<div class="pro_nbox2">
							<a href='ThemeAction.action?productId=<s:property value="productId"/>' title='<s:property value="productName"/>' target="_blank">
								<img src='images/smallImg/<s:property value="smallImg"/>' alt='<s:property value="productName"/>' width="155" height="165" />
								<br /><s:property value="productName"/></a><br />
							<span class="old_price">�г��ۣ���<s:property value="price"/></span><br />
							<s:iterator value="priceList">
							<span class="now_price"><s:property value="theCustomerType.typeName"/>��<span class="color_hong">��<s:property value="realPrice"/></span></span><br />
							</s:iterator>
						</div>
						</s:iterator>				
						</div>
						</td>
					</tr>
					<tr>
					<td>
					<div align="center">
						<font size="3"><s:property value="pageNumber"/>/<s:property value="totalPage"/></font>
						<a class="maroon" href="ThemeAction.action?pageNumber=1&theTheme=�ʻ�"><font size="3"><b>��ҳ</b></font></a>
						<s:if test="pageNumber==1"><font size="3">��һҳ</font></s:if>
						<s:if test="pageNumber!=1">
						<a class="maroon" href="ThemeAction.action?pageNumber=<s:property value="pageNumber-1"/>&theTheme=�ʻ�"><font size="3"><b>��һҳ</b></font></a>
						</s:if>
						<s:if test="pageNumber==totalPage"><font size="3">��һҳ</font></s:if>
						<s:if test="pageNumber!=totalPage">
						<a class="maroon" href="ThemeAction.action?pageNumber=<s:property value="pageNumber+1"/>&theTheme=�ʻ�"><font size="3"><b>��һҳ</b></font></a>
						</s:if>
						<a class="maroon" href="ThemeAction.action?pageNumber=<s:property value="totalPage"/>&theTheme=�ʻ�"><font size="3"><b>ĩҳ</b></font></a>
					</div>
					</td>
				</tr>
					</table>
				</div>
				<!-- �����ʻ�end -->
    		</div>
    	</div>
    	<div id="foot">
  			
  		</div>
  </body>
</html>
