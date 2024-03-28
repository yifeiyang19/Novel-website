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

import org.mypro.dao.GonggaoMapper;

import org.mypro.entity.Gonggao;

import org.mypro.entity.GonggaoExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface GonggaoServiceImp {


    //定义方法addgonggao接口,响应控制层添加公告请求

    public void addgonggao(HttpServletRequest request, HttpSession session);


    //定义addgonggaoact接口

    public void addgonggaoact(HttpServletRequest request, HttpSession session, Gonggao gonggao, MultipartFile picfile) throws IOException;


    //定义gonggaomanage方法响应页面请求

    public void gonggaomanage(HttpServletRequest request, HttpSession session);


    // 定义 gonggaoview方法

    public void gonggaoview(HttpServletRequest request, HttpSession session);


    // 定义 updategonggao方法

    public void updategonggao(HttpServletRequest request, HttpSession session, int id);


    // 定义updategonggaoact处理公告修改

    public void updategonggaoact(HttpServletRequest request, Gonggao gonggao, HttpSession session, MultipartFile picfile) throws IOException;


    // 定义deletegonggao,处理删除公告

    public void deletegonggao(HttpServletRequest request, HttpSession session, int id);


    // 定义searchgonggao方法，处理搜索操作

    public void searchgonggao(HttpServletRequest request, HttpSession session, String search);


    // 定义GonggaopinglunMapper

    public void gonggaodetails(HttpServletRequest request, HttpSession session, int id);


}

