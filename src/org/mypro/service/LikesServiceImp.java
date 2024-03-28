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

import org.mypro.dao.LikesMapper;

import org.mypro.entity.Likes;

import org.mypro.entity.LikesExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.entity.Novel;

import org.mypro.entity.NovelExample;

import org.mypro.dao.NovelMapper;

import org.mypro.entity.User;

import org.mypro.entity.UserExample;

import org.mypro.dao.UserMapper;

import org.mypro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface LikesServiceImp {


    //定义方法addlikes接口,响应控制层添加点赞请求

    public void addlikes(HttpServletRequest request, HttpSession session);


    //定义useraddlikes接口，在点赞控制层中调用

    public void useraddlikes(HttpServletRequest request, HttpSession session);


    // 定义userupdatelikes方法

    public void userupdatelikes(HttpServletRequest request, HttpSession session, int id);


    //定义userlikesmanage方法

    public void userlikesmanage(HttpServletRequest request, HttpSession session);


    //定义useraddlikesact接口，响应控制层添加请求

    public void useraddlikesact(HttpServletRequest request, HttpSession session, Likes likes) throws IOException;


    //定义addlikesact接口

    public void addlikesact(HttpServletRequest request, HttpSession session, Likes likes) throws IOException;


    //定义likesmanage方法响应页面请求

    public void likesmanage(HttpServletRequest request, HttpSession session);


    // 定义 likesview方法

    public void likesview(HttpServletRequest request, HttpSession session);


    // 定义 updatelikes方法

    public void updatelikes(HttpServletRequest request, HttpSession session, int id);


    // 定义updatelikesact处理点赞修改

    public void updatelikesact(HttpServletRequest request, Likes likes, HttpSession session) throws IOException;


    // 定义userupdatelikesact方法

    public void userupdatelikesact(HttpServletRequest request, Likes likes, HttpSession session) throws IOException;


    // 定义deletelikes,处理删除点赞

    public void deletelikes(HttpServletRequest request, HttpSession session, int id);


    // 定义userdeletelikes方法

    public void userdeletelikes(HttpServletRequest request, HttpSession session, int id);


    // 定义searchlikes方法，处理搜索操作

    public void searchlikes(HttpServletRequest request, HttpSession session, String search);


    // 定义LikespinglunMapper

    public void likesdetails(HttpServletRequest request, HttpSession session, int id);


}

