<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录界面</title>
	<link rel="stylesheet" href="css/login.css">
	<link rel="shortcut icon" href="img/6.png" />
</head>
<body>
<h1 style="color:red">${requestScope.msg}</h1>
<form action="/user?method=login" method="post" id="loginForm">
	<div id="login-box">
		<h1>Login登录</h1>
		<div class="form">
			<div class="item">
				<!-- <i class="fa fa-user" aria-hidden="true"></i> -->
				<input type="text" placeholder="用户名" name="username" required="required">
			</div>
			<div class="item">
				<!-- <i class="fa fa-key" aria-hidden="true"></i> -->
				<input type="password" placeholder="密码" name="password" required="required">
			</div>

			<br/>
		</div>
		<div align="center" >
			<input type="submit" value="登录"  />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置" />
		</div>
	</div>
</form>
</body>
</html>
