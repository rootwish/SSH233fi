<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>���������� | ��д��������</title>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
  <jsp:include page="head.jsp"></jsp:include>
  <img src="images/icons/order003.png" width="900px"/>
  <s:action name="provinceAction" executeResult="false"></s:action>
 
 	 <form action="createConsignee.action" method="post" name="submit"><!-- ����ʼ -->
   		<div id="tblConsigneeInfo"><!-- tblConsigneeInfo��ʼ -->
   			
   			
   			<table>
   				<tr>
   					<th>����д�ջ�����Ϣ</th>
   				</tr>
   				<tr>
   					<td>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>�ջ���������</label>
   						<input type="text" name="name" id="name"/>
   						<span class="strong">*</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>�ƶ��绰��</label>
   						<input type="text" name="mobilePhone" id="mobilePhone" style="width:120px;" />
   						<label>�칫�绰��</label>
   						<input type="text" name="officePhone" id="officePhone" style="width:120px;"  />
   						<label>��ͥ�绰��</label>
   						<input type="text" name="homePhone" id="homePhone" style="width:120px;"  />
   						<span class="strong">*</span>
   						<span class="tips">�绰��������дһ����鶼��д</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>�ջ���ʡ��/ֱϽ�У�</label>
   						<select name="ConsigneeProvince" onchange="testName(1,this.value,'ConsigneeCity','ConsigneeArea');" >
    						<option selected value="">��ѡ��ʡ</option>
   							<s:iterator value="#request.province">
    						<option value=<s:property value="name"/> ><s:property value="name"/></option>
   							</s:iterator>
    					</select>
    					<span class="strong">*</span>
    					&nbsp;&nbsp;
   						<label>�ջ��˳��У�</label>
    					<select name="ConsigneeCity" onchange="testName(2,this.value,'ConsigneeCity','ConsigneeArea');" >
     						<option value="" selected>��ѡ����</option>
     					</select>
     					<span class="strong">*</span>
						&nbsp;&nbsp;
     					<label>�ջ�������</label>
    					<select name="ConsigneeArea" id="ConsigneeArea">
     						<option value="" selected>��ѡ����</option>
     					</select>
     					<span class="strong">*</span>
     				</td>
   				</tr>
   				<tr>
   					<td>
   						<label>�ջ��������ֵ�����</label>
   						<input type="text" name="streetName" id="streetName"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>·����</label>
   						<input type="text" name="roadName" id="roadName"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>¥�ż����ƺţ�</label>
   						<input type="text" name="doorNumber" id="doorNumber"/>
   						<span class="strong">*</span>
   						&nbsp;&nbsp;
   						<label>�������룺</label>
   						<input type="text" name="zipCode" id="zipCode"/>
   						<span class="strong">*</span>
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<label>�ջ��˵����ʼ���</label>
   						<input type="text" name="email" id="email"/>
   						<label>�ջ���QQ�ţ�</label>
   						<input type="text" name="qqNumber" id="qqNumber"/>
   					</td>
   				</tr>
   			</table>
   		</div><!-- tblConsigneeInfo���� -->
   		<div id="tblCardsInfo"><!-- tblCardsInfo��ʼ -->
   			<table>
   				<tr>
   					<th>
   						��Ƭ����<span class="normalSize">��������;������Կ�һ�ţ���д���������ԣ�</span>
   					</th>
   				</tr>
   				<tr>
   					<td>
   						<ul>
   							<li>
   								<label>
   									<br>
   									���ջ������ԣ�
   									<br>
   									<br>
   									<a href="../Flower/flowerEncyclopedias.jsp" target=_blank>�ο�����ף����</a>
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
   		
   	</form><!-- ������ -->
   	<div id="foot">

  </body>
</html>
