<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title>���������� | �����б�</title>
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
  <h3 class="h3Title">��ѡ�������ɵĶ�������</h3>
  <div id="orderLists"><!-- orderLists��ʼ --> 
  <form action="shopping/SubmitConfirmed.jsp" method="post" name="submit">		
  	<table>
  		<tr>  			
  			<th>�������</th>
  			<th>�ͻ���</th>
    		<th>�¶�ʱ��</th>
    		<th>��ƷͼƬ</th>
    		<th>��Ʒ����</th>   		
    		<th>������</th>
    		<th>�ջ���</th>
    		<th>����״̬</th>
    		<th>ɾ������</th>
  		</tr>
  		<s:if test="#session.orderlists==null">
  		<tr>
  			<td colspan="10">
  				<font size="5" color="red"><b>�����κζ�����</b></font>
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
  			<td><input id="num" type="text" />Ԫ</td>
  			<td>
  			<s:iterator value="theConsignee">
    			<s:property value="name"/>
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
  <!-- orderLists���� -->

  </body>
</html>
