package org.mypro.service;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.HashMap;

import java.util.Map;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.mypro.dao.PostspinglunMapper;

import org.mypro.entity.Postspinglun;

import org.mypro.entity.PostspinglunExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.entity.Posts;

import org.mypro.entity.PostsExample;

import org.mypro.dao.PostsMapper;

import org.mypro.entity.User;

import org.mypro.entity.UserExample;

import org.mypro.dao.UserMapper;

import org.mypro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface PostspinglunServiceImp {


    //定义方法addpostspinglun接口,响应控制层添加帖子评论请求

    public void addpostspinglun(HttpServletRequest request, HttpSession session);


    //定义useraddpostspinglun接口，在帖子评论控制层中调用

    public void useraddpostspinglun(HttpServletRequest request, HttpSession session);


    // 定义userupdatepostspinglun方法

    public void userupdatepostspinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义userpostspinglunmanage方法

    public void userpostspinglunmanage(HttpServletRequest request, HttpSession session);


    //定义useraddpostspinglunact接口，响应控制层添加请求

    public void useraddpostspinglunact(HttpServletRequest request, HttpSession session, Postspinglun postspinglun) throws IOException;


    //定义addpostspinglunact接口

    public void addpostspinglunact(HttpServletRequest request, HttpSession session, Postspinglun postspinglun) throws IOException;


    //定义postspinglunmanage方法响应页面请求

    public void postspinglunmanage(HttpServletRequest request, HttpSession session);


    // 定义 postspinglunview方法

    public void postspinglunview(HttpServletRequest request, HttpSession session);


    // 定义 updatepostspinglun方法

    public void updatepostspinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义updatepostspinglunact处理帖子评论修改

    public void updatepostspinglunact(HttpServletRequest request, Postspinglun postspinglun, HttpSession session) throws IOException;


    // 定义userupdatepostspinglunact方法

    public void userupdatepostspinglunact(HttpServletRequest request, Postspinglun postspinglun, HttpSession session) throws IOException;


    // 定义deletepostspinglun,处理删除帖子评论

    public void deletepostspinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义userdeletepostspinglun方法

    public void userdeletepostspinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义searchpostspinglun方法，处理搜索操作

    public void searchpostspinglun(HttpServletRequest request, HttpSession session, String search);


    // 定义PostspinglunpinglunMapper

    public void postspinglundetails(HttpServletRequest request, HttpSession session, int id);


}

