<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/admin/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">欢迎登录后台管理系统</h3>
        </div>
        <div class="panel-body">
            <font color="red">${msg}</font>
            <form action="${pageContext.request.contextPath}/admin?method=login" method="post">
                <div class="form-group">
                    <label for="username">User Name</label>
                    <input type="text" class="form-control" id="username" placeholder="UserName" name="adminName">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="adminPwd">
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
    </body>
</html>


