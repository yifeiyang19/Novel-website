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

import org.mypro.dao.NovelpinglunMapper;

import org.mypro.entity.Novelpinglun;

import org.mypro.entity.NovelpinglunExample;

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

public interface NovelpinglunServiceImp {


    //定义方法addnovelpinglun接口,响应控制层添加小说评论请求

    public void addnovelpinglun(HttpServletRequest request, HttpSession session);


    //定义useraddnovelpinglun接口，在小说评论控制层中调用

    public void useraddnovelpinglun(HttpServletRequest request, HttpSession session);


    // 定义userupdatenovelpinglun方法

    public void userupdatenovelpinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义usernovelpinglunmanage方法

    public void usernovelpinglunmanage(HttpServletRequest request, HttpSession session);


    //定义useraddnovelpinglunact接口，响应控制层添加请求

    public void useraddnovelpinglunact(HttpServletRequest request, HttpSession session, Novelpinglun novelpinglun) throws IOException;


    //定义addnovelpinglunact接口

    public void addnovelpinglunact(HttpServletRequest request, HttpSession session, Novelpinglun novelpinglun) throws IOException;


    //定义novelpinglunmanage方法响应页面请求

    public void novelpinglunmanage(HttpServletRequest request, HttpSession session);


    // 定义 novelpinglunview方法

    public void novelpinglunview(HttpServletRequest request, HttpSession session);


    // 定义 updatenovelpinglun方法

    public void updatenovelpinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义updatenovelpinglunact处理小说评论修改

    public void updatenovelpinglunact(HttpServletRequest request, Novelpinglun novelpinglun, HttpSession session) throws IOException;


    // 定义userupdatenovelpinglunact方法

    public void userupdatenovelpinglunact(HttpServletRequest request, Novelpinglun novelpinglun, HttpSession session) throws IOException;


    // 定义deletenovelpinglun,处理删除小说评论

    public void deletenovelpinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义userdeletenovelpinglun方法

    public void userdeletenovelpinglun(HttpServletRequest request, HttpSession session, int id);


    // 定义searchnovelpinglun方法，处理搜索操作

    public void searchnovelpinglun(HttpServletRequest request, HttpSession session, String search);


    // 定义NovelpinglunpinglunMapper

    public void novelpinglundetails(HttpServletRequest request, HttpSession session, int id);


}

