<%@ page language="java"  pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<style>
		*{padding:0;margin:0;}
		#container{
			width:182px;
			background-color:#72F990;
		}
		#container a:hover{
			color:white;
		}
		.title{
			width:182px;
			cursor: pointer;
			font-size: 12px;
			font-weight: bold;
			height:30px;
			line-height: 30px;
			text-align: center;
			display: inline-block;
			background-color: #FFDE4D;
			text-decoration: none;
		}
		.content{
			width:182px;
		}
		.list{
			width:182px;
			list-style-type: none;
			font-size: 10px;
			text-align: center;
		}
		.list a{
			text-decoration: none;
		}
		.list li{
			height:30px;
			line-height: 30px;
			width: 100%;
		}
	</style>
</head>
<body>
	<div id="container">
		<a href="#"  title="" index="0" class="title">��̨�û�����</a></h1>
		<div id="Open0" class="content" style="display: none">
			<ul class="list">
				<li><a href="addManager.jsp" title="" target="main">���Ӻ�̨��Ա</a></li>
				<li><a href="showManager.jsp" title="" target="main">���к�̨��Ա</a></li>
			</ul>
		</div>
		<a href="#" title="" index="1" class="title">��Ʒ����</a></h1>
		<div id="Open1" class="content" style="display: none" >
			<ul class="list">
				<li><a href="manage_addProduct.jsp" title="" target="main">�����Ʒ</a></li>
				<li><a href="#" title="">�޸���Ʒ</a></li>
			</ul>
		</div>
		<a href="#"  title="" index="2" class="title">���˹���</a></h1>
		<div id="Open2" class="content" style="display: none">
			<ul class="list">
				<li><a href="changePassword.jsp" title="" target="main">�޸ĵ�¼����</a></li>
				<li><a href="changePersonalInfo.jsp" title="" target="main">�޸ĸ�����Ϣ</a></li>
			</ul>
		</div>
	</div>
</body>
<script>
	//ͨ��������ȡԪ��
	function getElementsByClass(className,parent){
	var oParent=parent?document.getElementById(parent):document,
		eles=[],
		elements=document.getElementsByTagName('*');

	for(var i=0,l=elements.length;i<l;i++){
		if(elements[i].className==className){
			eles.push(elements[i]);
		}
	}
	return eles;
}

	//��ʾ������ϸ
	function show(index){
		var Index=document.getElementById('Open'+index);
		if(Index.style.display=='none'){
			Index.style.display="block"
		}else{
			Index.style.display="none";
		}
	}
	var as=getElementsByClass('title','container');
	for (var i = as.length - 1; i >= 0; i--) {
		as[i].onclick=function(){
			index=this.getAttribute('index');
			show(index);
		}
	};

</script>
</html>