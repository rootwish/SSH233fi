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
		<a href="#"  title="" index="0" class="title">后台用户管理</a></h1>
		<div id="Open0" class="content" style="display: none">
			<ul class="list">
				<li><a href="addManager.jsp" title="" target="main">增加后台人员</a></li>
				<li><a href="showManager.jsp" title="" target="main">所有后台人员</a></li>
			</ul>
		</div>
		<a href="#" title="" index="1" class="title">商品管理</a></h1>
		<div id="Open1" class="content" style="display: none" >
			<ul class="list">
				<li><a href="manage_addProduct.jsp" title="" target="main">添加商品</a></li>
				<li><a href="#" title="">修改商品</a></li>
			</ul>
		</div>
		<a href="#"  title="" index="2" class="title">个人管理</a></h1>
		<div id="Open2" class="content" style="display: none">
			<ul class="list">
				<li><a href="changePassword.jsp" title="" target="main">修改登录密码</a></li>
				<li><a href="changePersonalInfo.jsp" title="" target="main">修改个人信息</a></li>
			</ul>
		</div>
	</div>
</body>
<script>
	//通过类名获取元素
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

	//显示分类详细
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