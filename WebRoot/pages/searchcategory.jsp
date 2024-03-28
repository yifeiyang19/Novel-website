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
    <title>搜索分类</title>
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
<!--面包屑部分开始-->
<div id="ljp9xmrg">
    <nav aria-label="Breadcrumb" class="breadcrumb">
        <ul>
             <li><a href="index.action">首页</a></li>
            <li><a href="#" qw-c="operationname">搜索分类</a></li>
        </ul>
    </nav>
</div>
<!--面包屑部分结束-->
<!--搜索区部分开始-->
<div id="lkapb2r5" qw-c="searchform" action="searchcategory.action" method="post">
    <div class="sample one">
        <form qw-c="searchform" action="searchcategory.action" method="post">
            <input type="text" name="search" id="search" placeholder="请输入搜索条件">
           <button type="submit" id="searchbtn" class="btn btn-search fa fa-search" style="margin-left: 930px;">搜索</button>
        </form>
    </div>
</div>
<!--搜索区部分结束-->
<!--图文展示部分开始-->
<div id="ljqv3fp1">
    <div class="shop__header">
        <h1 class="shop__title" qw-c="operationname">搜索分类</h1>
    </div>
    <div class="products" qw-c="imagearea" qw-areaitemnum="10" id="allitems">
        <c:if test="${ !empty categoryall}">
            <c:forEach items="${ categoryall}" var="item">
                <article class="product oneitem" qw-c="entity">
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
<!--图文展示部分结束-->
<!--分页部分开始-->
<div  qw-c="paging" style="text-align: center;">
    <div class="col-12 ap-pagination">
        <div class="col-12 ap-pagination">
            <a class="prev page-numbers" id="shangyiye" href="JavaScript:;;">« </a>
            <a class="page-numbers current" id="dangqianye" href="JavaScript:;;">1</a>
            <a class="next page-numbers" id="xiayiye" href="JavaScript:;;"> »</a>
        </div>
    </div>
</div>
<!--分页部分结束-->
<!--底部版权部分开始-->
<footer class="footer">
    <div class="container">
        <div class="row align-items-center">
              <div class="col-md-4">
                <p>版权信息 ©2024 | Design by <a href="#">Novel website</a></p>
            </div>
        </div>
    </div>
</footer>
<!--底部版权部分结束-->
<script src="resource/qianduan/js/js.js"></script>
<script>
    function goPage(pno, psize) {
        var itable = document.getElementById("allitems");
        console.log(itable);
        var num = $("#allitems .oneitem").length;//表格所有行数(所有记录数)
        console.log(num);
        var totalPage = 0;//总页数
        var pageSize = psize;//每页显示行数
        //总共分几页
        if (num / pageSize > parseInt(num / pageSize)) {
            totalPage = parseInt(num / pageSize) + 1;
        } else {
            totalPage = parseInt(num / pageSize);
        }
        var currentPage = pno;//当前页数
        var startRow = (currentPage - 1) * pageSize + 1;//开始显示的行 31
        var endRow = currentPage * pageSize;//结束显示的行  40
        endRow = (endRow > num) ? num : endRow; //40
        console.log(endRow);
        //遍历显示数据实现分页
        for (var i = 1; i < (num + 1); i++) {
            if (i >= startRow && i <= endRow) {
                console.log($("#allitems .oneitem")[i - 1]);
                $("#allitems .oneitem")[i - 1].style.display = "block";
            } else {
                $("#allitems .oneitem")[i - 1].style.display = "none";
            }
        }
        var tempStr = "共 " + num + " 条记录 分 " + totalPage
            + " 页 当前第 <span style=\"color:red;font-weight:bold;\">"
            + currentPage + "</span> 页<br/>";
        if (currentPage > 1) {
            $("#shangyiye").off("click");
            $("#shangyiye").click(function () {
                goPage(currentPage - 1, psize)
            });
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
        } else {
            $("#shangyiye").off("click");
            //tempStr += "<a href='#'>首页</a>";
            //tempStr += "<a href='#'><上一页</a>";
        }
        if (currentPage < totalPage) {
            $("#xiayiye").off("click");
            $("#xiayiye").click(function () {
                goPage(currentPage + 1, psize)
            });
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
        } else {
            $("#xiayiye").off("click");
            //tempStr += "<a href='#'>下一页></a>";
            //tempStr += "<a href='#'>尾页</a>";
        }
        try {
            document.getElementById("barcon").innerHTML = tempStr;
        } catch (error) {

        }
        $("#dangqianye").html(currentPage);
    }

    goPage(1, 10);

    if ("${message}") {
        alert("${message}");
    }

</script>
</body>
</html>


