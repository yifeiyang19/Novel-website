<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>菜单栏</title>
</head>
<body>
<span style="margin-left: 400px;color: white;margin-top: 20px;font-size: 32px;">Novel website</span>
<ul class="menu" qw-c="menu">

    <li qw-c="menu-item"><a href="index.action" qw-c="menu-itema menu-itemtext">home</a></li>
    <li qw-c="menu-item"><a href="searchnovel.action" qw-c="menu-itema menu-itemtext">novel</a></li>
    <li qw-c="menu-item"><a href="searchcategory.action" qw-c="menu-itema menu-itemtext">classification</a></li>
    <li qw-c="menu-item"><a href="searchposts.action" qw-c="menu-itema menu-itemtext">Post</a></li>
    <li qw-c="menu-item"><a href="searchgonggao.action" qw-c="menu-itema menu-itemtext">Notice</a></li>
    <c:if test="${sessionScope.identity == '管理员'}">
        <li qw-c="menu-item"><a href="adminindex.action" qw-c="menu-itema menu-itemtext">Personal Center</a></li>
    </c:if>
    <c:if test="${sessionScope.identity == '用户'}">
        <li qw-c="menu-item"><a href="userindex.action" qw-c="menu-itema menu-itemtext">Personal Center</a></li>
    </c:if>
    <c:if test="${sessionScope.identity == '' || sessionScope.identity == null}">
        <li qw-c="menu-item"><a href="login.action" qw-c="menu-itema menu-itemtext">Login</a></li>
        <li qw-c="menu-item"><a href="regist.action" qw-c="menu-itema menu-itemtext">Regist</a></li>
    </c:if>
</ul>
</body>
</html>

