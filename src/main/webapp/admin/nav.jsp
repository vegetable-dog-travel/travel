<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/admin/home/home.jsp">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin?method=findAll&code=user">会员管理</a></li><!-- user -->
                <li><a href="${pageContext.request.contextPath}/admin?method=findAll&code=product">商品管理</a></li><!-- product -->
                <li><a href="${pageContext.request.contextPath}/admin?method=findAll&code=order">订单管理</a></li><!-- order -->
                <li><a href="${pageContext.request.contextPath}/admin?method=findAll&code=category">商品分类管理</a></li><!-- category -->
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${admin.adminName}</a></li>
                <li><a href="${pageContext.request.contextPath}/admin?method=logout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>