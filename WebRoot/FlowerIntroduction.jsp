<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>	
  </head>  
  <body>
  	<div id="main"><!-- "main"包装层开始 -->
		<div id="flowerBlockBorder"><!-- "flowerBlockBorder"包装层开始 -->
			<table><!-- [放置花的图片+简介表格]的表格开始 -->
				<tr>
					<td align="right">
						<img src='shops/<s:property value="#request.aProduct.smallImg"/>' />
					</td>
					<td align="left">
							<table width="300px" style="font-size:15px;">									
								<tr>
									<td colspan="2" align="center">
										<span class="flowerName"><s:property value="#request.aProduct.productName"/></span>
									</td>
								</tr>
								<tr>
									<td align="right" style="width:20%">
										类别：
									</td>
									<td align="left" style="width:80%">
										<s:property value="#request.aProduct.productName"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										编号：
									</td>
									<td>
										<s:property value="#request.aProduct.productId"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										材料：
									</td>
									<td>
										<s:property value="#request.aProduct.feature"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										评语：
									</td>
									<td>
										
										<s:property value="#request.aProduct.meaning"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										附送：
									</td>
									<td>
										免费附送精美贺卡，代写您的祝福。(您下单时可填写留言栏)
									</td>
								</tr>
								<tr>
									<td align="right">
										配送：
									</td>
									<td>
										全国（可配送至全国900多城市，市区免配送费）
									</td>
								</tr>
								<tr>
									<td align="right">
										说明：
									</td>
									<td>
										<span class="strong"><s:property value="#request.aProduct.description"/></span>
									</td>
								</tr>									
							</table><!-- 花的简介表格的结束 -->
							<div class="priceTbl"><!-- "priceTbl"包装层开始 -->
								<table><!--显示价格的表格开始 -->
									<tr>
										<td>
											<span class="marketPrice"><label>市场价：￥<s:property value="#request.aProduct.price"/></label></span>											
										</td>
									</tr>
									<s:iterator value="#request.aProduct.priceList">
									<tr>
										<td>
											<label><s:property value="theCustomerType.typeName"/>：<span class="membershipPrice">￥<s:property value="realPrice"/></span></label>												
										</td>
									</tr>
									</s:iterator>
								</table><!--显示价格的表格结束 -->
							</div><!-- "priceTbl"包装层结束 -->
							<div class="shoppingCart"><!-- "shoppingCart"包装层开始 -->
								<a href='shoppingCartAction.action?productId=<s:property value="#request.aProduct.productId"/>' style="color:red " 	>
									加入购物车！
								</a>
							</div><!-- "shoppingCart"包装层结束 -->
					</td>
				</tr>
			</table><!-- [放置花的图片+简介表格]的表格结束 -->
		</div><!-- "flowerBlockBorder"包装层结束 -->
		<div id="details"><!-- "details"包装层开始 -->
			<div class="tagTitle"><!-- "tagTitle"包装层开始 -->
				<img src="images/icons/details.png" >
				<hr>
			</div><!-- "tagTitle"包装层结束 -->			
			<table>
				<tr>
					<td>
						<p>
							<span class="initCap">评</span>语:<s:property value="#request.aProduct.meaning"/><br><br>
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<s:if test="#request.aProduct.smallImg==#request.aProduct.bigImg">
						<img src='images/smallImg/<s:property value="#request.aProduct.smallImg"/>' />
						</s:if>
						<s:if test="#request.aProduct.smallImg!=#request.aProduct.bigImg">
						<img src='images/Flower_BigSize/<s:property value="#request.aProduct.bigImg"/>' />
						</s:if>
					</td>
				</tr>
				<tr>
					<td>
						<p>
							<span class="initCap">我</span>们的服务很到位的啦，免费哦亲！<br><br>
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<img src="images/others/cardstyle.jpg"/>
					</td>
				</tr>
			</table>
			<div class="tagTitle"><!-- "tagTitle"包装层开始 -->
				<img src="images/icons/chooseReason.png" >
				<hr>
			</div><!-- "tagTitle"包装层结束 -->			
			<table>
				<tr>
					<td>
						<img src="images/others/choosereason.jpg"/>
					</td>
				</tr>
			</table>
			<div class="tagTitle"><!-- "tagTitle"包装层开始 -->
				<img src="images/icons/commonQuestions.png" >
				<hr>
			</div><!-- "tagTitle"包装层结束 -->			
			<table class="commonQue">
				<tr>
					<td>
							
					</td>
				</tr>
				<tr>
					<td>
						
					</td>					
				</tr>
			</table>
		</div><!-- "details"包装层结束 -->
 	 </div><!-- "main"包装层结束 -->
 	 <script language="javascript">
 	 	var productId = "${aProduct.productId}";
 	 	var productName = "${aProduct.productName}";
 	 	var productImage = "${aProduct.smallImg}";
 	 	addHistory(productId,productName,productImage);
	</script>
  </body>
</html>
