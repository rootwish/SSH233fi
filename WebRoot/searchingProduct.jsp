<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  <body>
    	<div id="basicbody">
    		<jsp:include page="head.jsp"></jsp:include>
    		<div id="sidebar">
	    	</div>
	    	<div id=main>
	    		<!-- ������� -->
			    <div class="rmxhbox2">
			    <table>
	    			<tr bgcolor="#BF4D4D">
	    				<td height="30px" align="left"><font color="white" face="����">��������������£�</font></td>
	    			</tr>
	    			<tr><td>
					<div class="content">
							<s:iterator value="#request.products">	
								<div class="pro_nbox1">
									<a href='productAction.action?productId=<s:property value="productId"/>' title='<s:property value="productName"/>' target="_blank">
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
					</table>
				</div>
				<!-- ������� -->
	    	</div>
    	</div>
    	<div id="foot">
  		</div>
  </body>
</html>
