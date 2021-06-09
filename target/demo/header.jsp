<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
	<div class="row" >
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
			<a href="#"><img src="img/Logo.png"/></a>
		</div>
		<div class="col-lg-4 col-md-4 hidden-sm hidden-sm">
			<img src="img/header.png" >
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12" style="margin-top: 20px;padding-left: 20px;padding-right: 20px; font-size: 20px;" >
			<a href="register.jsp">注册</a>&nbsp;&nbsp;
			<a href="login.jsp">登录</a>&nbsp;&nbsp;
			<a href="cart.jsp">我的收藏</a>&nbsp;&nbsp;
			<a href="order_list.jsp">我的订单</a>&nbsp;&nbsp;
		</div>
	</div>
</div>

<c:set var="path" scope="session" value="${pageContext.request.contextPath}"></c:set>

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
								<a href="#">全球自由行<span class="sr-only">(current)</span></a>
							</li>
							<li><a href="#">出境游</a></li>
							<li><a href="#">国内游</a></li>
							<li><a href="#">抱团定制</a></li>
							<li><a href="#">港澳游</a></li>
							<li><a href="#">酒店</a></li>
							<li><a href="#">门票</a></li>
							<li><a href="#">香港车票</a></li>
						</ul>

						<%--<li class="dropdown">
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
						</li>--%>


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