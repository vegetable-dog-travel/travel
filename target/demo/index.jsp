<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<!-- 声明文档的编码集 -->
	<meta charset="utf-8">
	<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

	<title>菜狗菜狗，说走就走</title>
	<link href="img/logo.jpeg" rel="shortcut icon"/>

	<!-- 引入Bootstrap核心样式文件 -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style>
		p{
			margin-top: 20px;
		}
	</style>
</head>

<body>
<!--
    logo
    最外层的div：container 不会充斥全屏
    第二层dediv：row 在一行
    第三层的div：放置在三个元素
        若是超大屏（台式机）：lg 4/4/4
        若是中屏幕（笔记本）：md 4/4/4
        若是小屏幕（pad）：sm 6/hidden/4
        若是超小屏幕（pad）：xs 12/hidden/12
-->
<div class="container">
	<div class="row" >
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
			<a href="#"><img src="img/logo.png"/></a>
		</div>
		<div class="col-lg-4 col-md-4 hidden-sm hidden-sm">
			<img src="img/header.png" >
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12" style="margin-top: 20px;padding-left: 20px;padding-right: 20px; font-size: 20px;" >
			<a href="#">注册</a>&nbsp;&nbsp;
			<a href="#">登录</a>&nbsp;&nbsp;
			<a href="#">我的收藏</a>&nbsp;&nbsp;
			<a href="#">我的订单</a>&nbsp;&nbsp;
		</div>
	</div>
</div>

<!-- 导航栏 -->
<div class="container">
	<div class="row">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display 适应移动端-->
				<div class="navbar-header">
					<!-- 屏幕缩小后，出现导航按钮 -->
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">首页</a>
				</div>

				<!-- 菜单栏 -->
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<ul class="nav navbar-nav">
							<li class="active">
								<a href="#">国内游<span class="sr-only">(current)</span></a>
							</li>
							<li><a href="#">国际游</a></li>
							<li><a href="#">自驾游</a></li>
							<li><a href="#">跟团游</a></li>
						</ul>

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">酒店住宿<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#"></a></li>
								<li><a href="#">国内酒店</a></li>
								<li><a href="#">海外酒店</a></li>
								<li><a href="#">复古民宿</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">城堡皇宫</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">我就想睡街上</a></li>
							</ul>
						</li>

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">机票预定<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">国内机票</a></li>
								<li><a href="#">国际机票</a></li>
								<li><a href="#">特价机票</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">退订改签</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">我自己会飞</a></li>
							</ul>
						</li>

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">旅游导航<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">国内行</a></li>
								<li><a href="#">海外行</a></li>
								<li><a href="#">周边游</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">地下游</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">我自己会玩</a></li>
							</ul>
						</li>


					</ul>

					<!-- 表单 -->
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="去哪里玩呢...">
						</div>
						<button type="submit" class="btn btn-default">搜一下吧</button>
					</form>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
	</div>
</div>

<!-- 轮播图 -->
<div class="container">
	<div class="row">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			<!-- Indicators 三个点-->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				<li data-target="#carousel-example-generic" data-slide-to="4"></li>
			</ol>

			<!-- Wrapper for slides轮播图 -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="img/1.png" alt="...">
				</div>
				<div class="item">
					<img src="img/2.png" alt="...">
				</div>
				<div class="item">
					<img src="img/3.png" alt="...">
				</div>
				<div class="item">
					<img src="img/4.png" alt="...">
				</div>
				<div class="item">
					<img src="img/5.png" alt="...">
				</div>
			</div>

			<!-- Controls左右控制 -->
			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>

<!-- 热门境内游 -->
<div class="container">
	<div class="row">
		<!-- 文字部分 -->
		<div class="col-md-2" style="margin-top: 10px;margin-bottom: 5px;">
			<span style="font-size: 28px;">热门境内游</span>
		</div>
		<!-- 图片部分 -->
		<div class="col-md-10" style="padding-left: 15px;margin-top: 20px;">
			<img src="img/title2.jpg" />
		</div>
	</div>

	<!-- 商品信息 -->
	<div class="row">
		<!-- 左大图 -->
		<div class="col-lg-2 hidden-md hidden-sm hidden-xs" style="padding-left: 0px;">
			<img src="img/big02.png" width="205px" height="485px"/>
		</div>

		<!-- 右小图 -->
		<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
			<!-- 右上 -->
			<div class="row" style="text-align: center;">
				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/tiananmen.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							北京15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/shanghai.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							上海15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/xian.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							西安15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>

				<!-- 右下 -->
				<div class="col-lg-4 col-md-4 col-sm-2" style="text-align: center;">
					<img src="img/nanjing.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							南京15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/xinjiang.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							新疆15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/jilin.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							吉林15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>

				</div>
			</div>
		</div>
	</div>
</div>

<!-- 广告条  -->
<div class="container">
	<div class="row">
		<img src="img/广告.jpg" width="100%"/>
	</div>
</div>

<!-- 热门境外游 -->
<div class="container">
	<div class="row">
		<!-- 文字部分 -->
		<div class="col-md-2" style="margin-top: 10px;margin-bottom: 5px;">
			<span style="font-size: 28px;">热门境外游</span>
		</div>
		<!-- 图片部分 -->
		<div class="col-md-10" style="padding-left: 15px;margin-top: 20px;">
			<img src="img/title2.jpg" />
		</div>
	</div>

	<!-- 商品信息 -->
	<div class="row">
		<!-- 右小图 -->
		<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
			<!-- 右上 -->
			<div class="row" style="text-align: center;">
				<div class="col-lg-4 col-md-4 col-sm-2" style="padding-left: 0px;">
					<img src="img/yingguo.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							英国15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-2" style="padding-left: 0px;">
					<img src="img/faguo.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							法国15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2" style="padding-left: 0px;">
					<img src="img/meiguo.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							美国15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>

				<!-- 右下 -->
				<div class="col-lg-4 col-md-4 col-sm-2" style="text-align: center; padding-left: 0px;">
					<img src="img/taiguo.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							泰国15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2" style="padding-left: 0px;">
					<img src="img/riben.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							日本15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2" style="padding-left: 0px;">
					<img src="img/bingdao.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							冰岛15日13晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>
			</div>
		</div>

		<!-- 左大图 -->
		<div class="col-lg-2 hidden-md hidden-sm hidden-xs" style="padding-left: 0px;">
			<img src="img/big01.png" width="205px" height="485px"/>
		</div>

	</div>
</div>

<!-- 服务 -->
<div class="container">
	<div class="row">
		<div class="col-md-11" style="margin-top: 10px;margin-bottom: 5px; margin-left: -20px">
			<img src="img/footer.jpg" width="110%" >
		</div>
		<!-- 图片部分 -->
		<div class="col-md-1 hidden-sm hidden-xs" style="padding-left: 15px;">
			<a href="#" >
				<img src="img/火箭.png" width="80%" style="margin-left: 80px;padding-top: 15px;"/>
			</a>
			<!-- <span style="font-size: 16px; padding-left: 80px;">冲</span> -->
		</div>
	</div>
</div>

<!-- foot -->
<div class="container">
	<div class="row" style="text-align: center;">
		<div class="list-inline">
			<p>
				<a href="#">关于我们</a>
				<a href="#">联系我们</a>
				<a href="#">招贤纳士</a>
				<a href="#">法律声明</a>
				<a href="#">友情链接</a>
				<a href="#">支付方式</a>
				<a href="#">配送方式</a>
				<a href="#">服务声明</a>
				<a href="#">广告招租</a>
			</p>
			<p>
				Copyrignt @ 1900-9900 菜狗旅行 说行就是行
			</p>
		</div>
	</div>
</div>

</body>

<!-- 先引入jQuery核心js文件 -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="js/bootstrap.min.js"></script>
</html>