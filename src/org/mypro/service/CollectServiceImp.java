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

import org.mypro.dao.CollectMapper;

import org.mypro.entity.Collect;

import org.mypro.entity.CollectExample;

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

public interface CollectServiceImp {


    //定义方法addcollect接口,响应控制层添加收藏请求

    public void addcollect(HttpServletRequest request, HttpSession session);


    //定义useraddcollect接口，在收藏控制层中调用

    public void useraddcollect(HttpServletRequest request, HttpSession session);


    // 定义userupdatecollect方法

    public void userupdatecollect(HttpServletRequest request, HttpSession session, int id);


    //定义usercollectmanage方法

    public void usercollectmanage(HttpServletRequest request, HttpSession session);


    //定义useraddcollectact接口，响应控制层添加请求

    public void useraddcollectact(HttpServletRequest request, HttpSession session, Collect collect) throws IOException;


    //定义addcollectact接口

    public void addcollectact(HttpServletRequest request, HttpSession session, Collect collect) throws IOException;


    //定义collectmanage方法响应页面请求

    public void collectmanage(HttpServletRequest request, HttpSession session);


    // 定义 collectview方法

    public void collectview(HttpServletRequest request, HttpSession session);


    // 定义 updatecollect方法

    public void updatecollect(HttpServletRequest request, HttpSession session, int id);


    // 定义updatecollectact处理收藏修改

    public void updatecollectact(HttpServletRequest request, Collect collect, HttpSession session) throws IOException;


    // 定义userupdatecollectact方法

    public void userupdatecollectact(HttpServletRequest request, Collect collect, HttpSession session) throws IOException;


    // 定义deletecollect,处理删除收藏

    public void deletecollect(HttpServletRequest request, HttpSession session, int id);


    // 定义userdeletecollect方法

    public void userdeletecollect(HttpServletRequest request, HttpSession session, int id);


    // 定义searchcollect方法，处理搜索操作

    public void searchcollect(HttpServletRequest request, HttpSession session, String search);


    // 定义CollectpinglunMapper

    public void collectdetails(HttpServletRequest request, HttpSession session, int id);


}

