<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">
    <title>订单查询</title>
  </head>
  
  <body>
  	<jsp:include page="../head.jsp"></jsp:include>
  	
  	<div id="basicbody">
	  	<div align="left">
	  		<br>
	  		<img src="images/icons/search.png" style="margin-right:-7px;margin-left:7px; margin-bottom:-3px; width:25px; height:25px;" /> 
	  		<font style="font-size:25px; color:#BF4D4D; font-weight:bold;">订单查询</font>		
	  	</div>
	    <form action="FindOrderListAction.action" method="post">
	    	<table>
	    		<tr>
					<td align="center" colspan="3"><font color="red"><s:actionerror /></font></td>
				</tr>
	    		<tr>
	    			<td>请输入您想要查询的订单号：</td>
	    			<td><input type="text" name="orderId" /></td>
	    			<td align="right">&nbsp;<input type="submit" id="submit" value="查询"/></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id=showOrdersList>
	    	<s:iterator value="#request.orderlist">	
	    	<table id="showOrdersList">
	    		<tr align="center" valign="middle">
	    			<th>
	    				订单号
	    			</th>
	    			<th>
	    				下订时间
	    			</th>
	    			<th>
	    				商品名称
	    			</th>
	    			<th>
	    				商品数量
	    			</th>
	    			<th>
	    				付款方式
	    			</th>
	    			<th>
	    				付款金额
	    			</th>
	    			<th>
	    				收花人
	    			</th>
	    			<th>
	    				业务员
	    			</th>
	    			<th>
	    				配送员
	    			</th>
	    			<th>
	    				订单状态
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
	    				1(扎)
	    			</td>
	    			<td>
		    			<s:iterator value="thePayment">
		    				<s:iterator value="thePaymentType">
		    					<s:property value="typeName"/>
		    				</s:iterator>
		    			</s:iterator>
	    			</td>
	    			<td>
	    				<s:property value="amt"/>(元)
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
		  				<s:if test="orderState==0">已撤销</s:if>
		  				<s:if test="orderState==1">未付款</s:if>
		  				<s:if test="orderState==2">已付款</s:if>
		  				<s:if test="orderState==3">已下单</s:if>
		  				<s:if test="orderState==4">已生产</s:if>
		  				<s:if test="orderState==5">配送中</s:if>
		  				<s:if test="orderState==6">已送达</s:if>
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
