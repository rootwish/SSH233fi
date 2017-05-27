<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>花花世界网 | 填写订单资料</title>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
  <jsp:include page="head.jsp"></jsp:include>
  <img src="images/icons/order003.png" width="900px"/>
  <s:action name="provinceAction" executeResult="false"></s:action>
 
 	 <form action="createConsignee.action" method="post" name="submit"><!-- 表单开始 -->
   		<div id="tblConsigneeInfo"><!-- tblConsigneeInfo开始 -->
   			
   			
   			<table>
   				<tr>
   					<th>请填写收货人信息</th>
   				</tr>
   				<tr>
   					<td>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>收货人姓名：</label>
   						<input type="text" name="name" id="name"/>
   						<span class="strong">*</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>移动电话：</label>
   						<input type="text" name="mobilePhone" id="mobilePhone" style="width:120px;" />
   						<label>办公电话：</label>
   						<input type="text" name="officePhone" id="officePhone" style="width:120px;"  />
   						<label>家庭电话：</label>
   						<input type="text" name="homePhone" id="homePhone" style="width:120px;"  />
   						<span class="strong">*</span>
   						<span class="tips">电话请至少填写一项，建议都填写</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>收货人省份/直辖市：</label>
   						<select name="ConsigneeProvince" onchange="testName(1,this.value,'ConsigneeCity','ConsigneeArea');" >
    						<option selected value="">请选择省</option>
   							<s:iterator value="#request.province">
    						<option value=<s:property value="name"/> ><s:property value="name"/></option>
   							</s:iterator>
    					</select>
    					<span class="strong">*</span>
    					&nbsp;&nbsp;
   						<label>收货人城市：</label>
    					<select name="ConsigneeCity" onchange="testName(2,this.value,'ConsigneeCity','ConsigneeArea');" >
     						<option value="" selected>请选择市</option>
     					</select>
     					<span class="strong">*</span>
						&nbsp;&nbsp;
     					<label>收货人区：</label>
    					<select name="ConsigneeArea" id="ConsigneeArea">
     						<option value="" selected>请选择区</option>
     					</select>
     					<span class="strong">*</span>
     				</td>
   				</tr>
   				<tr>
   					<td>
   						<label>收货人所处街道名：</label>
   						<input type="text" name="streetName" id="streetName"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>路名：</label>
   						<input type="text" name="roadName" id="roadName"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>楼号及门牌号：</label>
   						<input type="text" name="doorNumber" id="doorNumber"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>邮政编码：</label>
   						<input type="text" name="zipCode" id="zipCode"/>
   						<span class="strong">*</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>收货人电子邮件：</label>
   						<input type="text" name="email" id="email"/>
   						<label>收货人QQ号：</label>
   						<input type="text" name="qqNumber" id="qqNumber"/>
   					</td>
   				</tr>
   			</table>
   		</div><!-- tblConsigneeInfo结束 -->
   		<div id="tblCardsInfo"><!-- tblCardsInfo开始 -->
   			<table>
   				<tr>
   					<th>
   						卡片资料<span class="normalSize">（随货赠送精美留言卡一张，请写下您的留言）</span>
   					</th>
   				</tr>
   				<tr>
   					<td>
   						<ul>
   							<li>
   								<label>
   									<br>
   									给收货人留言：
   									<br>
   									<br>
   									<a href="../Flower/flowerEncyclopedias.jsp" target=_blank>参考经典祝福语</a>
   								</label>
   							</li>
   							<li>
   								<textarea name="memo"></textarea>
   							</li>
   						</ul>			
   					</td>
   				</tr>
   			</table>
   			
   		</div>
   		<a href="shopping/createOrder.jsp" ><img src="images/icons/PreviousStep125x50.png" /></a>
   		&nbsp;&nbsp;&nbsp;&nbsp;
   		<a href="javascript:fsubmit(document.submit.submit());" onClick="return orderCheck();"><img src="images/icons/NextStep125x50.png" /></a>
   		
   	</form><!-- 表单结束 -->
   	<div id="foot">

  </body>
</html>
