<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta charset="utf-8">
	<title>购物车</title>
	<link rel="stylesheet" type="text/css" href="css/allstyle.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
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
					<a href="#"><img src="image/index-logo.jpg" alt="logo" width="190" height="60"></a>
				</div>
				<div class="step_box">
					<div class="step"></div>
					<ul class="step_text">
						<li class="step_text_li1 active">我的购物车</li>
						<li class="step_text_li2 active">填写核对订单</li>
						<li class="step_text_li3">订单提交成功</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="shopping_cart comWidth">
			<div class="shopping_item">
			<s:form action="createConsignee" method="post" namespace="/"><!-- 表单开始 -->
				<h3 class="shopping_item_tit">收货信息</h3>
				<div class="shopping_cont padding_shop">
					<ul class="shopping_list">
						<li><span class="shopping_list_span"><em>*</em>地区:</span>
							<input id="streetName" name="streetName" class="shopping_list_input input_long" type="text" value="XX省xx市"></li>
						</li>
						<li><span class="shopping_list_span"><em>*</em>详细地址:</span><input id="roadName" name="roadName" class="shopping_list_input input_long" type="text" value="最多输入26个汉字"></li>
						<li><span class="shopping_list_span"><em>*</em>收货人:</span><input id="name" name="name"  class="shopping_list_input" type="text" value="最多10个汉字"></li>
						<li><span class="shopping_list_span"><em>*</em>手机:</span><input id="mobilePhone" name="obilePhone" class="shopping_list_input" type="number" value="如13452525625"><span class="cart_tel"><!--&nbsp;或固定电话:</span><input class="shopping_list_input input_short" type="text" value="区号"><i class="ge">-</i><input class="shopping_list_input input_m" type="text" value="电话号码"><i class="ge">-</i><input class="shopping_list_input input_m" type="text" value="分机号(可选)"></li>-->
						<li><input type="submit" class="confirm" onclick=""></li>
					</ul>
				</div>
				</s:form>
			</div>
			<div class="hr_15"></div>
			<div class="shopping_item">
				<h3 class="shopping_item_tit">支付方式</h3>
				<div class="shopping_cont padding_shop">
					<ul class="shopping_list">
						<li><input class="radio" type="radio" id="r1"><label for="r1">微信支付</label>&nbsp;&nbsp;&nbsp;<span class="wechat">用微信扫一扫就能支付！</span></li>
						<li><input class="radio" type="radio" id="r2"><label for="r2">货到付款</label>&nbsp;&nbsp;&nbsp;<span>送货上门后再付款，使用现金或刷银行卡</span></li>
					</ul>
				</div>
			</div>
			<div class="hr_15"></div>
			<div class="shopping_item">
				<h3 class="shopping_item_tit">发票信息</h3>
				<div class="shopping_cont padding_shop">
					<ul class="shopping_list">
						<li><input type="checkbox" id="c1"><label for="c1">需要发票</label></li>
						<li><span class="shopping_list_span"><em>*</em>发票类型:</span>
							<select class="select1">
								<option value="">商业零售发票</option>
							</select>
						</li>
						<li><span class="shopping_list_span"><em>*</em>发票抬头:</span>
							<select class="select1">
								<option value="">个人</option>
							</select>
							<input class="border" type="text" value="某某">
						</li>
						<li><input type="button" class="savebtn">&nbsp;&nbsp;<input type="button" class="cancelbtn"></li>
					</ul>
				</div>
			</div>
			<div class="hr_15"></div>
			<div class="shopping_item">
				<h3 class="shopping_item_tit">送货清单<a href="#" class="backCar">返回购物车修改</a></h3>
				<div class="shopping_cont">
					<div class="cart_inner">
						<div class="cart_head clearfix">
							<div class="cart_item t_name">商品名称</div>
							<div class="cart_item t_price">单价</div>
						</div>
						<div class="cart_cont clearfix">
							<div class="cart_item t_name">
								<div class="cart_shop_info clearfix">
								<s:iterator value="#session.shoppingCart">
										<div class="cart_shopinfo_cont">
										<p class="cart_link"><a href="productAction.action?productId=<s:property value="productId"/>"><s:property value="productName"/></a></p>
									</div>
								</div>
							</div>
							<div class="cart_item t_price"><s:property value="price"/></div>
						
						</div>
						</s:iterator>
						<div class="cart_message">
							若您对包裹有特殊要求，请在此留言
						</div>
						<div class="cart_prompt">
							<i class="cart_prompt_icon"></i>抱歉，以下商品暂时不能购买，已帮您自动在本次结算中剔除并扣减相应金额，您可以先购买其他商品：)
						</div>
						<div class="cart_cont clearfix">
							<div class="cart_item t_name">
								<div class="cart_shop_info clearfix">
									<img src="image/qingfeng.jpg" alt="">
									<div class="sorry_shop">
										<p><a href="#">清风 欧院系列 清香型 100抽</a></p>
										<p class="cart_info">数量：1件</p>
										<span>￥4.90</span><em>(无货)</em>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="hr_15"></div>
			<div class="shopping_item">
				<h3 class="shopping_item_tit">清单结算</h3>
				<div class="shopping_cont padding_shop clearfix">
					<div class="cart_count"><s:form action="createOrderAction.do" namespace="/">
						<div class="cart_rmb">
							<em>总计:</em><input type="text" id="num" name="num" />  
						</div>
						<div class="cart_btnbox">
							<input type="submit" class="cart_btn" value="提交订单" />
						</div>
						</s:form>
					</div>
				</div>
			</div>
			<div class="hr_15"></div>
		</div>
	</div>
	<!--<div class="footer">
		<p><a href="#">公司介绍</a><i>|</i><a href="#">公司公告</a><i>|</i><a href="#">招纳贤才</a><i>|</i>客服热线：400-675-1234</p>
		<p>Copyright @ 2006-2016 版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373&nbsp;&nbsp;&nbsp;北京市公安局备案编号:123456789123</p>
		<p><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a>
		</p>
	</div>
--></body>
</html>
