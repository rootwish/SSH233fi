<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">
    <title>������ѯ</title>
  </head>
  
  <body>
  	<jsp:include page="../head.jsp"></jsp:include>
  	
  	<div id="basicbody">
	  	<div align="left">
	  		<br>
	  		<img src="images/icons/search.png" style="margin-right:-7px;margin-left:7px; margin-bottom:-3px; width:25px; height:25px;" /> 
	  		<font style="font-size:25px; color:#BF4D4D; font-weight:bold;">������ѯ</font>		
	  	</div>
	    <form action="FindOrderListAction.action" method="post">
	    	<table>
	    		<tr>
					<td align="center" colspan="3"><font color="red"><s:actionerror /></font></td>
				</tr>
	    		<tr>
	    			<td>����������Ҫ��ѯ�Ķ����ţ�</td>
	    			<td><input type="text" name="orderId" /></td>
	    			<td align="right">&nbsp;<input type="submit" id="submit" value="��ѯ"/></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id=showOrdersList>
	    	<s:iterator value="#request.orderlist">	
	    	<table id="showOrdersList">
	    		<tr align="center" valign="middle">
	    			<th>
	    				������
	    			</th>
	    			<th>
	    				�¶�ʱ��
	    			</th>
	    			<th>
	    				��Ʒ����
	    			</th>
	    			<th>
	    				��Ʒ����
	    			</th>
	    			<th>
	    				���ʽ
	    			</th>
	    			<th>
	    				������
	    			</th>
	    			<th>
	    				�ջ���
	    			</th>
	    			<th>
	    				ҵ��Ա
	    			</th>
	    			<th>
	    				����Ա
	    			</th>
	    			<th>
	    				����״̬
	    			</th>
	    		</tr>
	    		<tr align="center">
	    			<td>
	    				<s:property value="objId"/>
	    			</td>
	    			<td>
	    				<s:property value="orderTime"/>
	    			</td>
	    			<td>
		    			<s:iterator value="theProduct">	
		    				<s:property value="productName"/>
	    				</s:iterator>
	    			</td>
	    			<td>
	    				1(��)
	    			</td>
	    			<td>
		    			<s:iterator value="thePayment">
		    				<s:iterator value="thePaymentType">
		    					<s:property value="typeName"/>
		    				</s:iterator>
		    			</s:iterator>
	    			</td>
	    			<td>
	    				<s:property value="amt"/>(Ԫ)
	    			</td>   			   			  				
	    			<td>
		    			<s:iterator value="theConsignee">
		    				<s:property value="name"/>
	    				</s:iterator>
	    			</td>
	    			<td>
	    				<s:iterator value="theClerk">
	    					<s:property value="userName"/>
	    				</s:iterator>
	    			</td>
	    			<td>
						<s:iterator value="theDeliverer">
	    					<s:property value="userName"/>
	    				</s:iterator>
	    			</td>    			
	  				<td align="center">
		  				<s:if test="orderState==0">�ѳ���</s:if>
		  				<s:if test="orderState==1">δ����</s:if>
		  				<s:if test="orderState==2">�Ѹ���</s:if>
		  				<s:if test="orderState==3">���µ�</s:if>
		  				<s:if test="orderState==4">������</s:if>
		  				<s:if test="orderState==5">������</s:if>
		  				<s:if test="orderState==6">���ʹ�</s:if>
	  				</td>
	    		</tr>
	    	</table>
	    	</s:iterator>
	    </div>
	    <br>
	    <br>
	    <br>
    </div>    
  </body>
</html>
