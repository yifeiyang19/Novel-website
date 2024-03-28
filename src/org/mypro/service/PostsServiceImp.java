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

import org.mypro.dao.PostsMapper;

import org.mypro.entity.Posts;

import org.mypro.entity.PostsExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.dao.PostspinglunMapper;
import org.mypro.entity.PostspinglunExample;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface PostsServiceImp {


    //定义方法addposts接口,响应控制层添加帖子请求

    public void addposts(HttpServletRequest request, HttpSession session);


    //定义addpostsact接口

    public void addpostsact(HttpServletRequest request, HttpSession session, Posts posts, MultipartFile picfile) throws IOException;


    //定义postsmanage方法响应页面请求

    public void postsmanage(HttpServletRequest request, HttpSession session);


    // 定义 postsview方法

    public void postsview(HttpServletRequest request, HttpSession session);


    // 定义 updateposts方法

    public void updateposts(HttpServletRequest request, HttpSession session, int id);


    // 定义updatepostsact处理帖子修改

    public void updatepostsact(HttpServletRequest request, Posts posts, HttpSession session, MultipartFile picfile) throws IOException;


    // 定义deleteposts,处理删除帖子

    public void deleteposts(HttpServletRequest request, HttpSession session, int id);


    // 定义searchposts方法，处理搜索操作

    public void searchposts(HttpServletRequest request, HttpSession session, String search);


    // 定义PostspinglunMapper

    public void postsdetails(HttpServletRequest request, HttpSession session, int id);


}

