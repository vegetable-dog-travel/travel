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

<%--引入header.jsp--%>
<jsp:include page="/header.jsp"></jsp:include>

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
					<a href="#">
						<p>&nbsp;&nbsp;
							北京15日14晚跟团游〖菜狗专享 · 悠悠小钱〗
						</p>
					</a>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/shanghai.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							上海15日14晚跟团游〖菜狗专享 · 悠悠小屠〗
						</p>
					</a>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-2">
					<img src="img/xian.png" width="310px" height="200px"/>
					<a>
						<p>&nbsp;&nbsp;
							西安15日14晚跟团游〖菜狗专享 · 悠悠小董〗
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

<%--引入footer.jsp--%>
<jsp:include page="/footer.jsp"></jsp:include>
</body>

<!-- 先引入jQuery核心js文件 -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="js/bootstrap.min.js"></script>
</html>