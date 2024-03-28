<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>菜单栏</title>
</head>
<body>
<c:if test="${sessionScope.identity == '管理员' }">

    <ul class="main-menu" qw-c="menu">

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Personal Center</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="adminindex.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="adminindex.action">Personal Center</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">User Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="adduser.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="adduser.action">Add User</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="usermanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="usermanage.action">User Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Novel management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addnovel.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addnovel.action">Add a Novel</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="novelmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="novelmanage.action">Novel management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Classification management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addcategory.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addcategory.action">Add classification</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="categorymanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="categorymanage.action">Classif management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Novel Review Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addnovelpinglun.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addnovelpinglun.action">Add novel comments</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="novelpinglunmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="novelpinglunmanage.action">NR Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Collection Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addcollect.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addcollect.action">Add Collection</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="collectmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="collectmanage.action">Coll Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Like Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addlikes.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addlikes.action">Add Like</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="likesmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="likesmanage.action">Like Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Post Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addposts.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addposts.action">Add Post</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="postsmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="postsmanage.action">Post Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Post comment management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addpostspinglun.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addpostspinglun.action">Add Post comment</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="postspinglunmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="postspinglunmanage.action">Postcom management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Announcement Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addgonggao.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addgonggao.action">Add Announcement</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="gonggaomanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="gonggaomanage.action">Announ Management</span> </a></li>

            </ul>
        </li>


        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Exit the system</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="exitsystem.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="exitsystem.action">Exit the system</span> </a></li>

            </ul>
        </li>

    </ul>

</c:if><c:if test="${sessionScope.identity == '用户' }">

    <ul class="main-menu" qw-c="menu">

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Personal Center</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="userindex.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="adminindex.action">Personal Center</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Novel management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addnovel.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addnovel.action">Add a novel</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="novelview.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="novelmanage.action">View novels</span> </a></li>

            </ul>
        </li>


        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">My Collection</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="usercollectmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="usercollectmanage.action">My Collection</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">My likes</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="userlikesmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="userlikesmanage.action">My likes</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Post Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="addposts.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="addposts.action">Add post</span> </a></li>
                <li qw-c="menuitemselectitem"><a href="postsview.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="postsmanage.action">Post Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Novel Review Management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="usernovelpinglunmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="usernovelpinglunmanage.action">Novel Review Management</span> </a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Post comment management</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="userpostspinglunmanage.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="userpostspinglunmanage.action">Post comment management</span> </a></li>

            </ul>
        </li>



        <li qw-c="menuitem"><a href="javascript:void(0);" class="active"> <span class="icon-menu feather-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
           stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
       <line x1="22" y1="2" x2="11" y2="13"></line>
       <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
      </svg> </span> <span class="menu-text" qw-c="menuitematext">Exit the system</span> </a>
            <ul class="sub-menu" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="exitsystem.action" qw-c="menuitemselectitema"> <span
                        class="icon-dash"> </span> <span class="menu-text" qw-c="menuitemselectitematext"
                                                         href="exitsystem.action">Exit the system</span> </a></li>

            </ul>
        </li>

    </ul>

</c:if>
</body>
</html>


