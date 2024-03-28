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
    <title>帖子详情</title>
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
            <li><a href="#" qw-c="operationname">帖子详情</a></li>
        </ul>
    </nav>
</div>
<!--面包屑部分结束-->
<!--图文详情部分开始-->
<div id="lneliy19" qw-c="detailsarea">
    <h2><span class="main_text" qw-c="operationname">帖子详情</span></h2>
    <div>
        <div class="modal__container">
            <div class="modal__featured">
                <div class="modal__circle"></div>


                <!--  使用img展示帖子的图片  -->
                <img qw-c="entityimage" src="resource/uploads/${posts.pic}" class="modal__product">


            </div>
            <div class="modal__content" qw-c="entitycontent">
                <h2 qw-c="entitytitle">${posts.title}</h2>
                <ul class="form-list">

                    <br>
                    <h3>内容</h3>
                    <div v-html="posts.content">${posts.content}</div>
                    <br>
                    <h3>简介</h3>
                    <div v-html="posts.shortinfo">${posts.shortinfo}</div>
                    <li class="form-list__row" qw-c="entityattribute"><label qw-c="entitykey">发布时间</label>
                        <div id="input--cc">
                            <div style="color:var(--main-color);padding-left: 2px;border-bottom: 1px solid var(--main-color)">
                                <span qw-c="entityvalue">${posts.addtime}</span>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<!--图文详情部分结束-->
<!--评论区部分开始-->

<div id="lnhm8u7v" qw-c="commentarea">
    <ol class="commentlist group">

        <c:if test="${ !empty postspinglunall}">
            <c:forEach items="${ postspinglunall}" var="item">
                <li qw-c="commentitem" class="comment odd alt thread-odd thread-alt depth-1 featured"
                    id="li-comment-1592793">
                    <div class="grid group comment-wrap" id="comment-1592793">
                        <div class="comment-body group grid-5-5">
                            <div class="comment-author-wrap vcard">
                                <div class="comment-author" qw-c="commentitemuser">
                                        ${item.pinglunrenmingzi }
                                </div>
                                <div qw-c="commentitemdate" class="comment-time">
                                        ${item.pinglunshijian }
                                </div>
                            </div>
                            <div class="comment-content">
                                <p qw-c="commentitemcontent">${item.neirong }</p>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </c:if>

    </ol>
    <form action="addpostspinglunact.action" qw-c="commentform" method="post">
  <textarea name="neirong" id="neirong" cols="30" rows="10" qw-c="commentformtextarea" placeholder="请输入评论内容">

      </textarea>
        <button>评论</button>
        <input type="hidden" id="dangqianshijian" name="pinglunshijian">
        <input type="hidden" value="${posts.title }" name="posts">
        <input type="hidden" value="${posts.id }" name="postsid">
        <input type="hidden" value="${sessionScope.mingzi }" name="pinglunrenmingzi">
        <input type="hidden" value="${sessionScope.id }" name="pinglunrenid">
        <input type="hidden" value="postsdetails.action?id=${posts.id }" name="backurl">
        <script>document.getElementById("dangqianshijian").value = new Date().toLocaleString('chinese', {hour12: false});</script>
    </form>
</div>

<!--评论区部分结束-->
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
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


