<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<meta charset="utf-8">
	<title>网上零食商城————周黑鸭品牌</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/allstyle.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div class="header">
		<div class="topline">
			<div class="comWidth">
				<div class="fl">
					<a href="javascript:void(0)"class="collection" onmousedown="browserEvent(this,'file:///F:/%E5%A4%A7%E4%B8%89/%E5%8E%9F%E5%9E%8B/%E6%96%B0%E5%BB%BA%E6%96%87%E4%BB%B6%E5%A4%B9/%E9%A6%96%E9%A1%B5.html','网上零食')">收藏我们</a>
				</div>
				<div class="fr">
					欢迎来到网上零食商城！<a href="#">[登录]</a><a href="#">[注册]</a>
				</div>
			</div>
		</div>
		<div class="logoline">
			<div class="comWidth">
				<div class="logo fl">
					<a href="#"><img src="image/index-logo.jpg" alt="logo" width="190" height="60"></a>
				</div>
				<div class="search-box fl">
					<input type="text" class="search-text fl">
					<input type="button" value="搜 索" class="search-button fr">
				</div>
				<div class="search-car fr">
					<a href="shoppingCart.jsp"><span class="shoptext fl">购物车</span></a>
					<span class="shopnum fl">0</span>
				</div>
			</div>
		</div>
		<div class="navbox">
			<div class="comWidth">
				<div class="shopclass fl">
					<h3>全部商品分类<i></i></h3>
				</div>
				<div class="nav fl">
					<ul id="nav">
						<li><a href="index.jsp">首页</a></li>
						<li><a href="nav/sanzhisongshu.jsp">三只松鼠</a></li>
						<li><a href="nav/zhouheiya.jsp">周黑鸭</a></li>
						<li><a href="nav/wangzhai.jsp">旺仔</a></li>
						<li><a href="nav/leshi.jsp">乐事</a></li>
						<li><a href="nav/liangpin.jsp">良品铺子</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 图片展示区 -->
	<div class="comWidth clearfix products">
		<div class="fl">
			<div class="leftNav">
				<h3 class="navtitle">所有零食</h3>
				<div class="navcont">
					<h3>休闲零食</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">膨化食品</a></li>
						<li><a href="#">果干蜜饯</a></li>
						<li><a href="#">肉干肉脯</a></li>
						<li><a href="#">坚果炒货</a></li>
						<li><a href="#">薯片</a></li>
						<li><a href="#">鸭脖</a></li>
						<li><a href="#">海苔</a></li>
					</ul>
				</div>
				<div class="navcont">
					<h3>饼干/糕点</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">饼干</a></li>
						<li><a href="#">西式糕点</a></li>
						<li><a href="#">传统糕点</a></li>
						<li><a href="#">凤梨酥</a></li>
						<li><a href="#">沙琪玛</a></li>
						<li><a href="#">曲奇</a></li>
					</ul>
				</div><div class="navcont">
					<h3>糖果/巧克力</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">口香糖</a></li>
						<li><a href="#">果冻/布丁</a></li>
						<li><a href="#">软糖</a></li>
						<li><a href="#">硬糖</a></li>
						<li><a href="#">巧克力</a></li>
					</ul>
				</div><div class="navcont">
					<h3>调味速食</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">方便面</a></li>
						<li><a href="#">火腿肠</a></li>
						<li><a href="#">罐头</a></li>
						<li><a href="#">速食汤</a></li>
					</ul>
				</div><div class="navcont">
					<h3>进口牛奶</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">全脂牛奶</a></li>
						<li><a href="#">低脂牛奶</a></li>
						<li><a href="#">脱脂牛奶</a></li>
						<li><a href="#">进口豆奶</a></li>
						<li><a href="#">进口酸奶</a></li>
					</ul>
				</div><div class="navcont">
					<h3>进口饼干/糕点</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">进口饼干</a></li>
						<li><a href="#">进口曲奇</a></li>
						<li><a href="#">苏打饼干</a></li>
						<li><a href="#">休闲小饼</a></li>
						<li><a href="#">夹心饼干</a></li>
						<li><a href="#">进口糕点</a></li>
						<li><a href="#">面包干</a></li>
						<li><a href="#">日本糕点</a></li>
						<li><a href="#">专业配件</a></li>
						<li><a href="#">进口威化</a></li>
					</ul>
				</div>
				<div class="navcont">
					<h3>进口休闲零食</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">进口膨化</a></li>
						<li><a href="#">进口薯片</a></li>
						<li><a href="#">进口海苔</a></li>
						<li><a href="#">进口虾条</a></li>
						<li><a href="#">进口果冻</a></li>
						<li><a href="#">进口肉脯</a></li>
					</ul>
				</div>
				<div class="navcont">
					<h3>进口糖果/巧克力</h3>
					<ul class="navcont_list clearfix">
						<li><a href="#">进口硬糖</a></li>
						<li><a href="#">进口软糖</a></li>
						<li><a href="#">进口棉花糖</a></li>
						<li><a href="#">进口巧克力</a></li>
						<li><a href="#">牛奶巧克力</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="fr" style="width:810px">
			<!-- <div class="banner_bar bigbanner">
				<ul class="imglist">
					<li><a href="#"><img src="image/new-index-logo.jpg" alt="banner"></a></li>
					<li><a href="#"><img src="image/new-index-logo.jpg" alt="banner"></a></li>
				</ul>
			</div> -->
			<div class="hr_7"></div>
			<div class="products_title">
				<h3>周黑鸭零食</h3>
			</div>
			<div class="products_list clearfix" >
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2001.jpg" /></a>
						</div>
						<p><a href="#">周黑鸭 鸭脖 210g/袋 特色卤味，休闲食品</a></p>
						<p class="money">￥28</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2002.jpg" ></a>
						</div>
						<p><a href="#">周黑鸭 锁鲜 盒装卤鸭脖320g 武汉特产食品 零食小吃</a></p>
						<p class="money">￥29</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2003.jpg"></a>
						</div>
						<p><a href="#">周黑鸭 锁鲜 卤鸭脖200g锁骨240g鸭翅250g食品零食</a></p>
						<p class="money">￥58</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2004.jpg"></a>
						</div>
						<p><a href="#">周黑鸭 锁鲜 卤鸭翅250g 武汉特产官方新鲜食品零食</a></p>
						<p class="money">￥22</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2005.jpg" ></a>
						</div>
						<p><a href="#">周黑鸭 锁鲜 卤锁骨240g 武汉特产官方新鲜食品零食</a></p>
						<p class="money">￥23</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<a href="#"><img src="shops/2006.jpg" ></a>
						</div>
						<p><a href="#">周黑鸭 锁鲜 卤鸭舌150g 武汉特产肉类新鲜食品零食
</a></p>
						<p class="money">￥48</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span></p>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<div class="hr_25"></div>
	<div class="hr_25"></div>
	<div class="footer">
		<p><a href="#">公司介绍</a><i>|</i><a href="#">公司公告</a><i>|</i><a href="#">招纳贤才</a><i>|</i>客服热线：400-675-1234</p>
		<p>Copyright @ 2006-2016 weicong版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373&nbsp;&nbsp;&nbsp;北京市公安局备案编号:123456789123</p>
		<p><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a><a href="#"><img src="image/footer.jpg" alt=""></a>
		</p>
	</div>
	<script>
	//导航滑动
	function daohang(){
		var nav=document.getElementById("nav");
		var navli=nav.getElementsByTagName("li");
		for(var i=0;i<navli.length;i++){
			navli[i].onmouseover=function(){
				this.className="active";
			}
			navli[i].onmouseout=function(){
				this.className="";
			}
		}
	}

	window.onload=function(){
		daohang();
	}
	</script>
</body>
</html>

