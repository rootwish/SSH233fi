<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>���ﳵ</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/allstyle.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script src="js/myjs.js"></script>
		<style>
#tbshoppingCart {
	width: 900px;
}

#tbshoppingCart tr th {
	color: white;
	border: 1px solid #CEFDE9;
	text-align: center;
	vertical-align: center;
	background-color: #97FA6C;
	font-size: 15px;
	line-height: 30px;
}

#tbshoppingCart tr td {
	border: 2px solid #CEFDE9;
	text-align: center;
	vertical-align: center;
	line-height: 50px;
	background-color: white;
}

#tbshoppingCart button {
	width: 45px;
	height: 25px;
	border: 0px;
	background-color: #CEFDE9;
}

#tbshoppingCart input {
	width: 40px;
	height: 20px;
	background: #CDCACA;
	font-weight: bold;
	text-align: center;
	vertical-align: center;
}

p {
	width: 900px;
	text-align: right;
}

.strong {
	font-weight: bold;
	color: red;
}
</style>
	</head>
	<body>
		<div class="header">
			<div class="topline">
				<div class="comWidth">
					<div class="fl">

					</div>
					<div class="fr">
						<jsp:include page="head.jsp" flush="true" />
					</div>
				</div>
			</div>
			<div class="logoline">
				<div class="comWidth">
					<div class="logo fl">
						<a href="#"><img src="image/index-logo.jpg" alt="logo"
								width="190" height="60"> </a>
					</div>
					<div class="search-box fl">
						<input type="text" class="search-text fl">
						<input type="button" value="�� ��" class="search-button fr">
					</div>
					<div class="search-car fr">
						<a href="shoppingCart.jsp"><span class="shoptext fl">���ﳵ</span>
						</a>
						<span class="shopnum fl">0</span>
					</div>
				</div>
			</div>
			<div class="navbox">
				<div class="comWidth">
					<div class="shopclass fl">
						<h3>
							ȫ����Ʒ����
							<i></i>
						</h3>
					</div>
					<div class="nav fl">
						<ul id="nav">
							<li>
								<a href="index.jsp">��ҳ</a>
							</li>
							<li>
								<a href="nav/sanzhisongshu.jsp">��ֻ����</a>
							</li>
							<li>
								<a href="nav/zhouheiya.jsp">�ܺ�Ѽ</a>
							</li>
							<li>
								<a href="nav/wangzai.jsp">����</a>
							</li>
							<li>
								<a href="nav/leshi.jsp">����</a>
							</li>
							<li>
								<a href="nav/liangpin.jsp">��Ʒ����</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="hr_25"></div>
		<div class="comWidth clearfix products">
			<form action="shoppingCart.jsp" method="get" id="shoppingCart">
				<input type="hidden" name="action" value="update" />
				<table id="tbshoppingCart" >
					<tr>
						<th>
							<label>
								���
							</label>
						</th>
						<th>
							<label>
								��Ʒ����
							</label>
						</th>
						<th>
							<label>
								��������
							</label>
						</th>
						<th>
							<label>
								����
							</label>
						</th>
						<th>
							<label>
								�ܼ�
							</label>
						</th>
						<th>
							<label>
								����
							</label>
						</th>
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
								<input type="number" size=3 class="productAmount"
									name="productAmount" value="productAmount" min=0>
							</td>
							<td class="price">
								<s:property value="price" />
							</td>

							<td class="amountPrice"></td>
							<td>
								<a
									href="deleteShoppingCartAction?productId=<s:property value="productId"/>">ɾ��</a>
							</td>
						</tr>
					</s:iterator>



					<tr>
						<td colspan=3 align="right">
							������Ʒ�ܼ۸�Ϊ��
						</td>
						<td colspan=3 id="allAmount">
							<s:property value="#session.totalOMoney" />
						</td>
					</tr>

					<tr>
						<!--	<td colspan=3>
			 <a href="javascript:document.forms[0].submit()">�޸�</a> 
		</td>  -->

						<td colspan=6 align="right">
							<input type="button" onclick="sumb()" value="�µ�">

						</td>
					</tr>
				</table>
			</form>
			<div class="hr_25"></div>
			<div class="hr_25"></div>
			<div class="footer">
				<p>
					<a href="#">��˾����</a><i>|</i><a href="#">��˾����</a><i>|</i><a href="#">�����Ͳ�</a><i>|</i>�ͷ����ߣ�400-675-1234
				</p>
				<p>
					Copyright @ 2006-2016
					weicong��Ȩ����&nbsp;&nbsp;&nbsp;��ICP��09037834��&nbsp;&nbsp;&nbsp;��ICP֤B1034-8373&nbsp;&nbsp;&nbsp;�����й����ֱ������:123456789123
				</p>
				<p>
					<a href="#"><img src="image/footer.jpg" alt=""> </a><a
						href="#"><img src="image/footer.jpg" alt=""> </a><a href="#"><img
							src="image/footer.jpg" alt=""> </a><a href="#"><img
							src="image/footer.jpg" alt=""> </a>
				</p>
			</div>
			<script>
	function sumb() {
		var num = document.getElementById("allAmount").innerHTML;
		document.getElementById("shoppingCart").action = "shopcart.jsp";
		document.cookie = "allAmount=" + num;
		/*var strCookie=document.cookie; 
		alert(strCookie)*/
		document.getElementById("shoppingCart").submit();
	}
	function daohang() {
		var nav = document.getElementById("nav");
		var navli = nav.getElementsByTagName("li");
		for ( var i = 0; i < navli.length; i++) {
			navli[i].onmouseover = function() {
				this.className = "active";
			}
			navli[i].onmouseout = function() {
				this.className = "";
			}
		}
	}

	function sumb() {
		var num = document.getElementById("allAmount").innerHTML;
		document.getElementById("shoppingCart").action = "shopcart.jsp";
		document.cookie = "allAmount=" + num;
		/*var strCookie=document.cookie; 
		alert(strCookie)*/
		document.getElementById("shoppingCart").submit();
	}
	
	window.onload = function() {
		var resultTable = document.getElementById("tbshoppingCart");
		var allAmount = document.getElementById("allAmount");

		resultTable
				.addEventListener(
						"change",
						function(event) {
							var e = window.event || event;
							var target = e.srcElement || e.target;
							if (target.className === "productAmount") {
								var amountVal = parseInt(target.value);
								var amountNextElem = target.parentNode.nextElementSibling;
								var priceVal = parseInt(amountNextElem.innerHTML);
								var resultVal = amountNextElem.nextElementSibling;

								resultVal.innerHTML = amountVal * priceVal;

								var priceElems = document
										.getElementsByClassName("amountPrice");
								var amountPrice = 0;

								for ( var i = 0; i < priceElems.length; i++) {
									amountPrice += parseInt(priceElems[i].innerHTML || 0);
								}

								document.getElementById("allAmount").innerHTML = amountPrice;
							}
						}, false);
	};
</script>
</script>
	</body>
</html>


