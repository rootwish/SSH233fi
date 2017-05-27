<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title>花花世界网 | 订单列表</title>
  	<script type="text/javascript" src="js/js.js" charset="gb2312"></script>
  	<script>
	function getCookie(cookieName) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for(var i = 0; i < arrCookie.length; i++){
        var arr = arrCookie[i].split("=");
        if(cookieName == arr[0]){
            return arr[1];
        }
    }
    return "";
	}
	
	window.onload=function(){
		var n=getCookie("allAmount");
		var num=document.getElementById("num");
		num.value=n;
	}
	</script>
  </head>
  
  <body>
  <jsp:include page="top.jsp" flush="true" />
  <h3 class="h3Title">您选购所生成的订单如下</h3>
  <div id="orderLists"><!-- orderLists开始 --> 
  <form action="shopping/SubmitConfirmed.jsp" method="post" name="submit">		
  	<table>
  		<tr>  			
  			<th>订单编号</th>
  			<th>送花人</th>
    		<th>下订时间</th>
    		<th>商品图片</th>
    		<th>商品名称</th>   		
    		<th>付款金额</th>
    		<th>收花人</th>
    		<th>订单状态</th>
    		<th>删除订单</th>
  		</tr>
  		<s:if test="#session.orderlists==null">
  		<tr>
  			<td colspan="10">
  				<font size="5" color="red"><b>尚无任何订单！</b></font>
  			</td>
  		</tr>
  		</s:if>
  		<s:iterator value="#session.orderlists">
  		<tr>
  			<td><s:property value="objId"/></td>
  			<td>
  			<s:iterator value="theCustomer">	
    			<s:property value="customerId"/>
    		</s:iterator>
    		</td>
  			<td><s:property value="orderTime"/></td>
  			<s:iterator value="theProduct">	
  			<td><img src="shop/<s:property value="smallImg"/>" style="width:50px; height:50px;"/></td>
  			<td><s:property value="productName"/></td>
  			</s:iterator>  			
  			<td><input id="num" type="text" />元</td>
  			<td>
  			<s:iterator value="theConsignee">
    			<s:property value="name"/>
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
  			<td>
  			<button type="button" onclick="delOrder('<s:property value="objId"/>')"><img src='images/icons/Delete50x30.png' /></button>	
  			</td>
  		</tr>
  		</s:iterator>
  	</table>
  	<s:if test="#session.orderlists!=null">
  		<a href="javascript:fsubmit(document.submit.submit());"><img src="images/icons/ConfirmOrders125x50.png" /></a>
  	</s:if>
  </form>
  </div>
  <!-- orderLists结束 -->

  </body>
</html>
