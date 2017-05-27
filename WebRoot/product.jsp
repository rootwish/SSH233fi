<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<head>
	<meta charset="utf-8">
	<title>网上零食商城——产品分类</title>
	<link rel="stylesheet" type="text/css" href="css/allstyle.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div class="header">
		<div class="topline">
			<div class="comWidth">
				<div class="fl">
					<a href="#" class="collection">收藏我们</a>
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
					<span class="shoptext fl">购物车</span>
					<span class="shopnum fl">0</span>
				</div>
			</div>
		</div>
		<div class="navbox">
			<div class="comWidth">
				<div class="shopclass fl">
					<h3>全部商品分类<i></i></h3>
					<div class="shopclass_show" style="display: none">
						<dl class="shopclass_item">
							<dt><a href="#" class="b">休闲零食</a> <a href="#" class="b">膨化食品</a> <a href="#">薯片</a></dt>
							<dd><a href="#">肉干肉脯</a> <a href="#">坚果</a> <a href="#">海苔</a></dd>
						</dl>
						<dl class="shopclass_item">
							<dt><a href="#" class="b">饼干</a> <a href="#" class="b">糕点</a> <a href="#">凤梨酥</a></dt>
							<dd><a href="#">沙琪玛</a> <a href="#">蛋卷</a> <a href="#">苏打饼干</a></dd>
						</dl>
						<dl class="shopclass_item">
							<dt><a href="#" class="b">糖果</a> <a href="#" class="b">巧克力</a> <a href="#">口香糖</a></dt>
							<dd><a href="#">果冻</a> <a href="#">布丁</a> <a href="#">龟苓膏</a></dd>
						</dl>
						<dl class="shopclass_item">
							<dt><a href="#" class="b">南北干货</a> <a href="#" class="b">枸杞</a> <a href="#">香菇</a></dt>
							<dd><a href="#">木耳</a> <a href="#">海产干货</a> </dd>
						</dl>
						<dl class="shopclass_item">
							<dt><a href="#" class="b">进口食品</a> <a href="#" class="b">进口牛奶</a></dt>
							<dd><a href="#">进口零食 <a href="#">进口咖啡/茶</a></dd>
						</dl>
					</div>
				</div>
				<div class="nav fl">
					<ul>
						<li><a href="#" class="active">团购</a></li>
						<li><a href="#">闪购</a></li>
						<li><a href="#">进口美食</a></li>
						<li><a href="#">发现</a></li>
						<li><a href="#">海购</a></li>
						<li><a href="#">更多活动</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 图片展示区 -->
	<!-- <div class="hr_15"></div> -->
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
			<div class="banner_bar bigbanner">
				<ul class="imglist">
					<li><a href="#"><img src="image/new-index-logo.jpg" alt="banner"></a></li>
					<li><a href="#"><img src="image/new-index-logo.jpg" alt="banner"></a></li>
				</ul>
				<div class="imgNum">
					<a href="#" class="active"></a><a href="#"></a><a href="#"></a><a href="#"></a>
				</div>
			</div>
			<div class="hr_7"></div>
			<div class="products_title">
				<h3>进口休闲零食</h3>
			</div>
			<div class="products_list clearfix" >
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/1.jpg" alt="">
						</div>
						<p><a href="#">北田 蒟蒻糙米卷 海苔味 160g 台湾地区进口 进口食品</a></p>
						<p class="money">￥11.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(78条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/2.jpg" alt="">
						</div>
						<p><a href="#">张君雅小妹妹 休闲丸子(日式风味) 80g/袋 进口食品</a></p>
						<p class="money">￥7.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(10条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/3.jpg" alt="">
						</div>
						<p><a href="#">海牌 海苔（4连包）2g*10*4/袋 韩国进口 进口食品</a></p>
						<p class="money">￥49</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(175条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/4.jpg" alt="">
						</div>
						<p><a href="#">ZEK 芝士鳕鱼肠（袋装）105g 韩国进口 进口食品</a></p>
						<p class="money">￥19.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(1322条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/5.jpg" alt="">
						</div>
						<p><a href="#">乐事 无限薯片三连装（原味+番茄+烤肉）104g*3/组</a></p>
						<p class="money">￥19.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(190条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/6.jpg" alt="">
						</div>
						<p><a href="#">Blue Diamond蓝钻石 蜜烤风味扁桃仁 170g 美国进口</a></p>
						<p class="money">￥26.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(61条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/7.jpg" alt="">
						</div>
						<p><a href="#">圣美时 奇酷果仁夹心巧克力棒 350g/盒 早餐 零食 下午茶 点心</a></p>
						<p class="money">￥12</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(8条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/8.jpg" alt="">
						</div>
						<p><a href="#">百草味 牛肉粒 五香味 100g/袋 肉脯肉类零食 肉干零食特产</a></p>
						<p class="money">￥18.8</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(203条)</a></p>
					</div>
				</div>
			</div>
			<div class="hr_25"></div>
			<div class="products_title">
				<h3>进口糖果/巧克力</h3>
			</div>
			<div class="products_list clearfix">
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/9.jpg" alt="">
						</div>
						<p><a href="#">Raphaelpuzzle 拉斐尔 棷蓉扁桃仁糖果酥球 3粒 30g 波兰进口 进口食品</a></p>
						<p class="money">￥7.4</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(78条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/10.jpg" alt="">
						</div>
						<p><a href="#">Cavendish Harvey嘉云 嘉云糖 混合水果味 200g 金色装 德国进口</a></p>
						<p class="money">￥14.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(10条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/11.jpg" alt="">
						</div>
						<p><a href="#">Ferrero 费列罗 榛果威化巧克力 心型 100g 8粒 意大利进口 进口食品</a></p>
						<p class="money">￥45.5</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(175条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/12.jpg" alt="">
						</div>
						<p><a href="#">京都念慈菴 枇杷糖 60g 泰国进口 进口食品 休闲 零食 糖果 巧克力</a></p>
						<p class="money">￥17.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(1322条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/13.jpg" alt="">
						</div>
						<p><a href="#">落基山 棉花糖 150g/袋 美国进口 进口食品</a></p>
						<p class="money">￥12.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(190条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/14.jpg" alt="">
						</div>
						<p><a href="#">韩美禾 啵乐乐五角星棒棒糖 63g（9g*7）/包 韩国进口 进口食品</a></p>
						<p class="money">￥12.5</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(0条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/15.jpg" alt="">
						</div>
						<p><a href="#">韩美禾 啵乐乐爱心棒棒糖 63g（9g*7）/包 韩国进口 进口食品</a></p>
						<p class="money">￥12.5</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(8条)</a></p>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div class="item_img">
							<img src="shops/16.jpg" alt="">
						</div>
						<p><a href="#">Ricola利口乐 香草润喉糖（柠檬味）100g 瑞士进口 进口食品</a></p>
						<p class="money">￥19.9</p>
						<p>评论：<span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><span class="start"></span><a href="#">(203条)</a></p>
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
</body>
</html>
