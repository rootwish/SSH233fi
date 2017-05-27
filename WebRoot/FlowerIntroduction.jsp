<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>	
  </head>  
  <body>
  	<div id="main"><!-- "main"��װ�㿪ʼ -->
		<div id="flowerBlockBorder"><!-- "flowerBlockBorder"��װ�㿪ʼ -->
			<table><!-- [���û���ͼƬ+�����]�ı��ʼ -->
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
										���
									</td>
									<td align="left" style="width:80%">
										<s:property value="#request.aProduct.productName"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										��ţ�
									</td>
									<td>
										<s:property value="#request.aProduct.productId"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										���ϣ�
									</td>
									<td>
										<s:property value="#request.aProduct.feature"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										���
									</td>
									<td>
										
										<s:property value="#request.aProduct.meaning"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										���ͣ�
									</td>
									<td>
										��Ѹ��;����ؿ�����д����ף����(���µ�ʱ����д������)
									</td>
								</tr>
								<tr>
									<td align="right">
										���ͣ�
									</td>
									<td>
										ȫ������������ȫ��900����У����������ͷѣ�
									</td>
								</tr>
								<tr>
									<td align="right">
										˵����
									</td>
									<td>
										<span class="strong"><s:property value="#request.aProduct.description"/></span>
									</td>
								</tr>									
							</table><!-- ���ļ����Ľ��� -->
							<div class="priceTbl"><!-- "priceTbl"��װ�㿪ʼ -->
								<table><!--��ʾ�۸�ı��ʼ -->
									<tr>
										<td>
											<span class="marketPrice"><label>�г��ۣ���<s:property value="#request.aProduct.price"/></label></span>											
										</td>
									</tr>
									<s:iterator value="#request.aProduct.priceList">
									<tr>
										<td>
											<label><s:property value="theCustomerType.typeName"/>��<span class="membershipPrice">��<s:property value="realPrice"/></span></label>												
										</td>
									</tr>
									</s:iterator>
								</table><!--��ʾ�۸�ı����� -->
							</div><!-- "priceTbl"��װ����� -->
							<div class="shoppingCart"><!-- "shoppingCart"��װ�㿪ʼ -->
								<a href='shoppingCartAction.action?productId=<s:property value="#request.aProduct.productId"/>' style="color:red " 	>
									���빺�ﳵ��
								</a>
							</div><!-- "shoppingCart"��װ����� -->
					</td>
				</tr>
			</table><!-- [���û���ͼƬ+�����]�ı����� -->
		</div><!-- "flowerBlockBorder"��װ����� -->
		<div id="details"><!-- "details"��װ�㿪ʼ -->
			<div class="tagTitle"><!-- "tagTitle"��װ�㿪ʼ -->
				<img src="images/icons/details.png" >
				<hr>
			</div><!-- "tagTitle"��װ����� -->			
			<table>
				<tr>
					<td>
						<p>
							<span class="initCap">��</span>��:<s:property value="#request.aProduct.meaning"/><br><br>
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
							<span class="initCap">��</span>�ǵķ���ܵ�λ���������Ŷ�ף�<br><br>
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<img src="images/others/cardstyle.jpg"/>
					</td>
				</tr>
			</table>
			<div class="tagTitle"><!-- "tagTitle"��װ�㿪ʼ -->
				<img src="images/icons/chooseReason.png" >
				<hr>
			</div><!-- "tagTitle"��װ����� -->			
			<table>
				<tr>
					<td>
						<img src="images/others/choosereason.jpg"/>
					</td>
				</tr>
			</table>
			<div class="tagTitle"><!-- "tagTitle"��װ�㿪ʼ -->
				<img src="images/icons/commonQuestions.png" >
				<hr>
			</div><!-- "tagTitle"��װ����� -->			
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
		</div><!-- "details"��װ����� -->
 	 </div><!-- "main"��װ����� -->
 	 <script language="javascript">
 	 	var productId = "${aProduct.productId}";
 	 	var productName = "${aProduct.productName}";
 	 	var productImage = "${aProduct.smallImg}";
 	 	addHistory(productId,productName,productImage);
	</script>
  </body>
</html>
