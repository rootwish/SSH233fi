<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>购物车</title>

</head>
<body>

<form action="shoppingCart.jsp" method="get">
<input type="hidden" name="action" value="update"/>
<table align="center" border="1" id="resultTable">
				<tr>
					<td>
						产品ID
					</td>
					<td>
						产品名称
					</td>
					<td>
						购买数量
					</td>
					<td>
						单价
					</td>
					<td>
						总价
					</td>
					<td>
						处理
					</td>
				</tr>
				<s:iterator value="#session.shoppingCart">
					<tr>
						<td>
							<s:property value="productId" />
						</td>
						<td>
							<s:property value="productName" />
						</td>
						<td>
							<input type="number" size=3 class=" " name="productAmount"
								value="1" min=0>
						</td>
						<td class="price">
							<s:property value="price" />
						</td>

						<td class="amountPrice"></td>
						<td>
							<a
								href="deleteShoppingCartAction?productId=<s:property value="productId"/>">删除</a>
						</td>
					</tr>
				</s:iterator>



				<tr>
		<td colspan=3 align="right">
			所有商品总价格为：
		</td>
		<td colspan=3 id="allAmount"><s:property value="#session.totalOMoney"/></td>
	</tr>
	
	
	<tr>
	<!--	<td colspan=3>
			 <a href="javascript:document.forms[0].submit()">修改</a> 
		</td>  -->
		<td colspan=6 align="right">
			<a href="shopcart.jsp" onclick="">下单</a>		
		</td>
	</tr>
</table>
</form>
<script>
	window.onload = function() {
		var resultTable = document.getElementById("resultTable");
		var allAmount = document.getElementById("allAmount");
		
		resultTable.addEventListener("change", function(event) {
			var e = window.event || event;
			var target = e.srcElement || e.target;
			if(target.className === "productAmount") {
				var amountVal = parseInt(target.value);
				var amountNextElem = target.parentNode.nextElementSibling;
				var priceVal = parseInt(amountNextElem.innerHTML);
				var resultVal = amountNextElem.nextElementSibling;
				
				resultVal.innerHTML = amountVal * priceVal;
				
				var priceElems = document.getElementsByClassName("amountPrice");
				var amountPrice = 0;
				
				for(var i=0;i<priceElems.length;i++) {
					amountPrice += parseInt(priceElems[i].innerHTML || 0);
				}
				
				document.getElementById("allAmount").innerHTML = amountPrice;
			}
		}, false);
	};
</script>
</body>
</html>


