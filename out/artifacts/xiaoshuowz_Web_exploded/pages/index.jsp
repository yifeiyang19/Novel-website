<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/qianduan/css/config.css" rel="stylesheet">
    <script src="resource/qianduan/js/jquery.min.js"></script>
    <script src="resource/qianduan/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="resource/qianduan/css/css.css" rel="stylesheet">
</head>
<body>
<!--导航栏部分开始-->
<div id="lk57dj29">
    <header>
        <nav>
            <c:import url="qtmenu.jsp"></c:import>
        </nav>
    </header>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
</div>
<!--导航栏部分结束-->
<!--轮播图部分开始-->
<div id="myCarousel" class="carousel slide main" style="clear: both;">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img decoding="async" src="resource/qianduan/img/1.jpg" alt="First slide">
        </div>
        <div class="item">
            <img decoding="async" src="resource/qianduan/img/2.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img decoding="async" src="resource/qianduan/img/3.jpg" alt="Second slide">
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> <span
            class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> <span
            class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
</div>
<!--轮播图部分结束-->
<!--图文展示部分开始-->

<div id="ljqv3fp1" qw-c="imagearea" qw-areaitemnum="6">
    <div class="filter-list">
        <h2 qw-c="areatitle">Latest recommendations for novels</h2>
    </div>
    <div class="products">
        <c:if test="${ !empty novelzuixin6}">
            <c:forEach items="${ novelzuixin6}" var="item">
                <article class="product" qw-c="entity">
                    <div class="product__imgbox">
                        <a href="noveldetails.action?id=${item.id}"> <img qw-c="entityimage"
                                                                          src="resource/uploads/${item.pic}"
                                                                          class="product__preview"> </a>
                    </div>
                    <div class="product__body">
                        <h3 qw-c="entitytitle" class="product__name">${item.name}</h3>
                    </div>
                </article>
            </c:forEach>
        </c:if>
    </div>
</div>
<div id="ljqv3fp1" qw-c="imagearea" qw-areaitemnum="6">
    <div class="filter-list">
        <h2 qw-c="areatitle">Latest recommendations for classification</h2>
    </div>
    <div class="products">
        <c:if test="${ !empty categoryzuixin6}">
            <c:forEach items="${ categoryzuixin6}" var="item">
                <article class="product" qw-c="entity">
                    <div class="product__imgbox">
                        <a href="categorydetails.action?id=${item.id}"> <img qw-c="entityimage"
                                                                             src="resource/uploads/${item.pic}"
                                                                             class="product__preview"> </a>
                    </div>
                    <div class="product__body">
                        <h3 qw-c="entitytitle" class="product__name">${item.name}</h3>
                    </div>
                </article>
            </c:forEach>
        </c:if>
    </div>
</div>
<div id="ljqv3fp1" qw-c="imagearea" qw-areaitemnum="6">
    <div class="filter-list">
        <h2 qw-c="areatitle">Latest recommendations in the post</h2>
    </div>
    <div class="products">
        <c:if test="${ !empty postszuixin6}">
            <c:forEach items="${ postszuixin6}" var="item">
                <article class="product" qw-c="entity">
                    <div class="product__imgbox">
                        <a href="postsdetails.action?id=${item.id}"> <img qw-c="entityimage"
                                                                          src="resource/uploads/${item.pic}"
                                                                          class="product__preview"> </a>
                    </div>
                    <div class="product__body">
                        <h3 qw-c="entitytitle" class="product__name">${item.title}</h3>
                    </div>
                </article>
            </c:forEach>
        </c:if>
    </div>
</div>
<div id="ljqv3fp1" qw-c="imagearea" qw-areaitemnum="6">
    <div class="filter-list">
        <h2 qw-c="areatitle">Announcement of the latest recommendations</h2>
    </div>
    <div class="products">
        <c:if test="${ !empty gonggaozuixin6}">
            <c:forEach items="${ gonggaozuixin6}" var="item">
                <article class="product" qw-c="entity">
                    <div class="product__imgbox">
                        <a href="gonggaodetails.action?id=${item.id}"> <img qw-c="entityimage"
                                                                            src="resource/uploads/${item.pic}"
                                                                            class="product__preview"> </a>
                    </div>
                    <div class="product__body">
                        <h3 qw-c="entitytitle" class="product__name">${item.title}</h3>
                    </div>
                </article>
            </c:forEach>
        </c:if>
    </div>
</div>


<!--图文展示部分结束-->
<!--文字展示部分开始-->


<footer class="footer">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-4">
                <p>版权信息 ©2024 | Design by <a href="#">Novel website</a></p>
            </div>

        </div>
    </div>
</footer>
<script src="resource/qianduan/js/js.js"></script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


