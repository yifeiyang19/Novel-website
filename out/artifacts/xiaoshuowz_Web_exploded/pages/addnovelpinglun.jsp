<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<!--[if IE 8]>
<html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]>
<html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zxx">
<!--<![endif]-->
<!-- Begin Head -->
<head>
    <title qw-c="operationname">添加小说评论</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <meta name="MobileOptimized" content="320">
    <!-- Required Start Style -->
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/icofont.min.css">
    <!--Page Specific Style -->
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/nice-select.css">
    <!-- Custom Style -->
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/style.css">
    <link rel="stylesheet" id="theme-change" type="text/css" href="">
</head>
<body>
<div class="loader">
    <div class="spinner">
        <img src="resource/houtai/picture/loader.gif" alt="">
    </div>
</div>
<!-- Main Body -->
<div class="page-wrapper">
    <!-- Header Start -->
    <header class="header-wrapper main-header">
        <div class="header-inner-wrapper">
            <div class="logo-wrapper">
                <a href="index.action" class="admin-logo"> <span
                        style="font-size: 20px;font-weight: 700;color: #fff">Novel website</span> </a>
            </div>
            <div class="header-right">
                <div class="serch-wrapper">
                </div>
                <div class="header-controls">
                    <div class="user-info-wrapper header-links">
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Sidebar Start -->
    <aside class="sidebar-wrapper">
        <div class="side-menu-wrap">

            <c:import url="htmenu.jsp"></c:import>

        </div>
    </aside>
    <!-- Container Start -->
    <div class="page-wrapper">
        <div class="main-content">
            <!-- Page Title Start -->
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="page-title-wrapper">
                        <div class="page-title-box">
                            <h4 class="page-title" qw-c="operationname">添加小说评论</h4>
                        </div>
                        <div class="breadcrumb-list">
                        </div>
                    </div>
                </div>
            </div>
            <!-- From Start -->
            <div class="from-wrapper">
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <div class="card-body">
                                <form class="separate-form" qw-c="operationform" action="addnovelpinglunact.action"
                                      method="post" enctype="multipart/form-data">
                                    <div class="row" qw-c="formselectcomponent">
                                        <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <div class="form-group">
                                                <label class="col-form-label" qw-c="formselecttext">小说</label>


                                                <select id='novel' onchange="novelchange(this)" name="novel"
                                                        class="select2 form-control" qw-c="formselect">
                                                    <!-- 用c标签的if表达式判断novelall是否为空  -->

                                                    <c:if test="${ !empty novelall}">

                                                        <!-- 用c标签的forEach循环展示 request中的novelall -->

                                                        <c:forEach items="${ novelall}" var="item">


                                                            <option value="${item.name }">${item.name }</option>

                                                        </c:forEach>

                                                    </c:if>


                                                </select>

                                                <script>
                                                    function GetQueryString(name) {
                                                        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                                        var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                                        if (r != null) return (r[2]);
                                                        return null;
                                                    }

                                                    var novel = GetQueryString("novel");

                                                    if (novel != null) {

                                                        $("#novel").val(novel);

                                                        $("#novel option:selected").siblings().remove();
                                                    }

                                                </script>
                                            </div>
                                        </div>
                                    </div> <!-- 设置display为none,设置为不可见 -->

                                    <div style='display:none;' class="row" qw-c="formselectcomponent">
                                        <!-- 设置display为none,设置为不可见 -->

                                        <div style='display:none;' class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <!-- 设置display为none,设置为不可见 -->

                                            <div style='display:none;' class="form-group">
                                                <label class="col-form-label" qw-c="formselecttext">小说id</label>


                                                <select id='novelid' onchange="novelidchange(this)" name="novelid"
                                                        class="select2 form-control" qw-c="formselect">
                                                    <!-- 用c标签的if表达式判断novelall是否为空  -->

                                                    <c:if test="${ !empty novelall}">

                                                        <!-- 用c标签的forEach循环展示 request中的novelall -->

                                                        <c:forEach items="${ novelall}" var="item">


                                                            <option value="${item.id }">${item.id }</option>

                                                        </c:forEach>

                                                    </c:if>


                                                </select>

                                                <script>
                                                    function GetQueryString(name) {
                                                        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                                        var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                                        if (r != null) return (r[2]);
                                                        return null;
                                                    }

                                                    var novelid = GetQueryString("novelid");

                                                    if (novelid != null) {

                                                        $("#novelid").val(novelid);

                                                        $("#novelid option:selected").siblings().remove();
                                                    }

                                                </script>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" qw-c="formtextareacomponent">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="form-group">
                                                <label class="col-form-label" qw-c="formtextareatext">内容</label>
                                                <!-- 定义内容本文输入框  -->

                                                <textarea name="neirong" class="form-control"
                                                          qw-c="formtextarea"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" qw-c="formselectcomponent">
                                        <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <div class="form-group">
                                                <label class="col-form-label" qw-c="formselecttext">评论人</label>


                                                <select id='pinglunrenmingzi' onchange="pinglunrenmingzichange(this)"
                                                        name="pinglunrenmingzi" class="select2 form-control"
                                                        qw-c="formselect">  <!-- 用c标签的if表达式判断userall是否为空  -->

                                                    <c:if test="${ !empty userall}">

                                                        <!-- 用c标签的forEach循环展示 request中的userall -->

                                                        <c:forEach items="${ userall}" var="item">


                                                            <option value="${item.name }">${item.name }</option>

                                                        </c:forEach>

                                                    </c:if>


                                                </select>

                                                <script>
                                                    function GetQueryString(name) {
                                                        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                                        var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                                        if (r != null) return (r[2]);
                                                        return null;
                                                    }

                                                    var pinglunrenmingzi = GetQueryString("pinglunrenmingzi");

                                                    if (pinglunrenmingzi != null) {

                                                        $("#pinglunrenmingzi").val(pinglunrenmingzi);

                                                        $("#pinglunrenmingzi option:selected").siblings().remove();
                                                    }

                                                </script>
                                            </div>
                                        </div>
                                    </div> <!-- 设置display为none,设置为不可见 -->

                                    <div style='display:none;' class="row" qw-c="formselectcomponent">
                                        <!-- 设置display为none,设置为不可见 -->

                                        <div style='display:none;' class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <!-- 设置display为none,设置为不可见 -->

                                            <div style='display:none;' class="form-group">
                                                <label class="col-form-label" qw-c="formselecttext">评论人id</label>


                                                <select id='pinglunrenid' onchange="pinglunrenidchange(this)"
                                                        name="pinglunrenid" class="select2 form-control"
                                                        qw-c="formselect">  <!-- 用c标签的if表达式判断userall是否为空  -->

                                                    <c:if test="${ !empty userall}">

                                                        <!-- 用c标签的forEach循环展示 request中的userall -->

                                                        <c:forEach items="${ userall}" var="item">


                                                            <option value="${item.id }">${item.id }</option>

                                                        </c:forEach>

                                                    </c:if>


                                                </select>

                                                <script>
                                                    function GetQueryString(name) {
                                                        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                                        var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                                        if (r != null) return (r[2]);
                                                        return null;
                                                    }

                                                    var pinglunrenid = GetQueryString("pinglunrenid");

                                                    if (pinglunrenid != null) {

                                                        $("#pinglunrenid").val(pinglunrenid);

                                                        $("#pinglunrenid option:selected").siblings().remove();
                                                    }

                                                </script>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" qw-c="forminputcomponent">
                                        <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <div class="form-group">
                                                <label class="col-form-label" qw-c="forminputtext">评论时间</label>
                                                <!-- 定义js方法将id为dangqianshijian的项设置为当前时间  -->

                                                <script>
                                                    setTimeout(function () {
                                                        document.getElementById("dangqianshijian").value = new Date(+new Date() + 8 * 3600 * 1000).toJSON().substr(0, 19).replace("T", " ");
                                                    }, 200)
                                                </script>
                                                <!-- 定义当前时间input输入框，并设置为只读  -->

                                                <input readonly type="text" id="dangqianshijian" name="pinglunshijian"
                                                       class="form-control" qw-c="forminput">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group mb-0">
                                            <button qw-c="operationbutton" class="btn btn-primary" type="submit">添加
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ad-footer-btm">
                <p> © .Novel website</p>
            </div>
        </div>
    </div>
</div>
<!-- Slide Setting Box -->
<div class="slide-setting-box">
    <div class="slide-setting-holder">
        <div class="setting-box-head">
            <h4>General Settings</h4>
            <a href="javascript:void(0);" class="close-btn">Close</a>
        </div>
        <div class="setting-box-body">
            <div class="p-4">
                <div class="switch-settings">
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Notifications</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox55" type="checkbox">
                            <label for="checkbox55"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Show your emails</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox56" type="checkbox">
                            <label for="checkbox56"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Show Task statistics</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox57" type="checkbox">
                            <label for="checkbox57"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Show recent activity</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox58" type="checkbox">
                            <label for="checkbox58"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">System Logs</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox59" type="checkbox">
                            <label for="checkbox59"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Error Reporting</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox60" type="checkbox">
                            <label for="checkbox60"></label>
                        </div>
                    </div>
                    <div class="d-flex mb-3">
                        <span class="mr-auto fs-15">Show your status to all</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox61" type="checkbox">
                            <label for="checkbox61"></label>
                        </div>
                    </div>
                    <div class="d-flex">
                        <span class="mr-auto fs-15">Keep up to date</span>
                        <div class="checkbox checkbox-toggle">
                            <input id="checkbox62" type="checkbox">
                            <label for="checkbox62"></label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="p-3 border-top border-bottom">
            <h5 class="border-bottom-0 mb-0">Overview</h5>
        </div>
        <div class="p-4">
            <div class="progress-wrapper">
                <div class="mb-3">
                    <p class="mb-2">Achieves<span class="float-right text-muted font-weight-normal">95%</span></p>
                    <div class="progress h-1">
                        <div class="progress-bar bg-primary col-3" role="progressbar" aria-valuenow="25"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="progress-wrapper pt-2">
                <div class="mb-3">
                    <p class="mb-2">Projects<span class="float-right text-muted font-weight-normal">65%</span></p>
                    <div class="progress">
                        <div class="progress-bar bg-secondary col-3" role="progressbar" aria-valuenow="25"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="progress-wrapper pt-2">
                <div class="mb-3">
                    <p class="mb-2">Earnings<span class="float-right text-muted font-weight-normal">55%</span></p>
                    <div class="progress">
                        <div class="progress-bar bg-success col-8" role="progressbar" aria-valuenow="25"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="progress-wrapper pt-2">
                <div class="mb-3">
                    <p class="mb-2">Balance<span class="float-right text-muted font-weight-normal">50%</span></p>
                    <div class="progress h-1">
                        <div class="progress-bar bg-warning w-50 " role="progressbar"></div>
                    </div>
                </div>
            </div>
            <div class="progress-wrapper pt-2">
                <div class="mb-3">
                    <p class="mb-2">Total Profits<span class="float-right text-muted font-weight-normal">80%</span></p>
                    <div class="progress">
                        <div class="progress-bar bg-info col-6" role="progressbar" aria-valuenow="25" aria-valuemin="0"
                             aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="progress-wrapper pt-2">
                <div class="mb-3">
                    <p class="mb-2">Total Likes<span class="float-right text-muted font-weight-normal">75%</span></p>
                    <div class="progress h-1">
                        <div class="progress-bar bg-teal w-75" role="progressbar"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Color Setting -->
<div id="style-switcher">
    <div>
        <ul class="colors">
            <li><p class="colorchange" id="color"></p></li>
            <li><p class="colorchange" id="color2"></p></li>
            <li><p class="colorchange" id="color3"></p></li>
            <li><p class="colorchange" id="color4"></p></li>
            <li><p class="colorchange" id="color5"></p></li>
            <li><p class="colorchange" id="style"></p></li>
        </ul>
    </div>
    <div class="bottom">
    </div>
</div>
<!-- Color Setting -->
<!-- Required Script -->
<script src="resource/houtai/js/jquery.min.js"></script>
<script src="resource/houtai/js/bootstrap.min.js"></script>
<!-- Page Specific Script -->
<script src="resource/houtai/js/nice-select.min.js"></script>
<!-- Custom Script -->
<script src="resource/houtai/js/custom.js"></script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


