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

import org.mypro.dao.NovelMapper;

import org.mypro.entity.Novel;

import org.mypro.entity.NovelExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.entity.Category;

import org.mypro.entity.CategoryExample;

import org.mypro.dao.CategoryMapper;

import org.mypro.dao.NovelpinglunMapper;
import org.mypro.entity.NovelpinglunExample;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface NovelServiceImp {


    Map collectjson(HttpServletRequest request, HttpSession session, Collect collect);

    Map likesjson(HttpServletRequest request, HttpSession session, Likes likes);


    //定义方法addnovel接口,响应控制层添加小说请求

    public void addnovel(HttpServletRequest request, HttpSession session);


    //定义addnovelact接口

    public void addnovelact(HttpServletRequest request, HttpSession session, Novel novel, MultipartFile picfile, MultipartFile uploadsfile) throws IOException;


    //定义novelmanage方法响应页面请求

    public void novelmanage(HttpServletRequest request, HttpSession session);


    // 定义 novelview方法

    public void novelview(HttpServletRequest request, HttpSession session);


    // 定义 updatenovel方法

    public void updatenovel(HttpServletRequest request, HttpSession session, int id);


    // 定义updatenovelact处理小说修改

    public void updatenovelact(HttpServletRequest request, Novel novel, HttpSession session, MultipartFile picfile, MultipartFile uploadsfile) throws IOException;


    // 定义deletenovel,处理删除小说

    public void deletenovel(HttpServletRequest request, HttpSession session, int id);


    // 定义searchnovel方法，处理搜索操作

    public void searchnovel(HttpServletRequest request, HttpSession session, String search);


    // 定义NovelpinglunMapper

    public void noveldetails(HttpServletRequest request, HttpSession session, int id);


}

