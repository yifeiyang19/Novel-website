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
    <title qw-c="operationname">点赞管理</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <meta name="MobileOptimized" content="320">
    <!--Start Style -->
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/datatables.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/icofont.min.css">
    <link rel="stylesheet" href="resource/houtai/css/swiper.min.css">
    <!--Page Specific -->
    <link rel="stylesheet" type="text/css" href="resource/houtai/css/nice-select.css">
    <!--Custom Style -->
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
                    <form>
                        <input type="text" placeholder="Search Here...">
                    </form>
                    <a class="search-close" href="javascript:void(0);"><span class="icofont-close-line"></span></a>
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
                <div class="col xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="page-title-wrapper">
                        <div class="page-title-box">
                            <h4 class="page-title" qw-c="operationname">点赞管理</h4>
                        </div>
                        <div class="breadcrumb-list">
                        </div>
                    </div>
                </div>
            </div>
            <!-- Products view Start -->
            <div class="row">
                <!-- Styled Table Card-->
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="card table-card">
                        <div class="card-body">
                            <table id="example" class="table table-striped table-bordered dt-responsive nowrap"
                                   qw-c="table" style="width:100%">
                                <thead>
                                <tr>
                                    <td>小说

                                    </td>
                                    <td>用户

                                    </td>
                                    <td>操作</td>
                                </tr>
                                </thead>
                                <tbody>


                                <c:if test="${ !empty likesall}">

                                    <c:forEach items="${ likesall}" var="item">


                                        <tr>
                                            <td> ${item.novel }

                                            </td>
                                            <td> ${item.user }

                                            </td>
                                            <td>

                                                <!--  定义修改点赞按钮和删除点赞按钮，修改提交地址为userupdatelikes.action?id=${item.id}，删除提交地址为 userdeletelikes.action?id=${item.id}-->

                                                <a href="userupdatelikes.action?id=${item.id}">修改</a> <a
                                                    href="userdeletelikes.action?id=${item.id}">删除</a>

                                            </td>
                                        </tr>

                                    </c:forEach>

                                </c:if>

                                </tbody>
                            </table>
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
<!-- Color Setting -->
<!-- Script Start -->
<script src="resource/houtai/js/jquery.min.js"></script>
<script src="resource/houtai/js/popper.min.js"></script>
<script src="resource/houtai/js/datatables.min.js"></script>
<script src="resource/houtai/js/dataTables.responsive.min.js"></script>
<script src="resource/houtai/js/bootstrap.min.js"></script>
<script src="resource/houtai/js/swiper.min.js"></script>
<!-- Page Specific -->
<script src="resource/houtai/js/nice-select.min.js"></script>
<!-- Custom Script -->
<script src="resource/houtai/js/custom.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable({
            "language": {
                "lengthMenu": "每页显示 _MENU_记录",
                "zeroRecords": "没有匹配的数据",
                "info": "第_PAGE_页/共 _PAGES_页 ( 共\_TOTAL\_条记录 )",
                "infoEmpty": "没有符合条件的记录",
                "search": "查找",
                "infoFiltered": "(从 _MAX_条记录中过滤)",
                "paginate": {"first": "首页 ", "last": "末页", "next": "下一页", "previous": "上一页"}
            }
        });
    });
</script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


