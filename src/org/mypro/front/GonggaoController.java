package org.mypro.front;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.mypro.service.GonggaoServiceImp;

import org.mypro.entity.Gonggao;

import org.mypro.entity.GonggaoExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class GonggaoController {


    private static final Log logger = LogFactory.getLog(GonggaoController.class);

    @Autowired
    private GonggaoServiceImp gonggaoservice;


    //定义方法addgonggao,响应页面addgonggao请求

    @RequestMapping(value = "addgonggao")

    public String addgonggao(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addgonggao

        logger.debug("GonggaoController.addgonggao ......");

        gonggaoservice.addgonggao(request, session);

        return "addgonggao";

    }


    //定义addgonggaoact方法,将公告信息插入到数据库的t_gonggao表中

    @RequestMapping(value = "addgonggaoact")

    public String addgonggaoact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Gonggao gonggao, MultipartFile picfile) throws IOException {

        //输出当前方法日志，表示正在执行GonggaoController.addgonggaoact方法

        logger.debug("GonggaoController.addgonggaoact ......");

        gonggaoservice.addgonggaoact(request, session, gonggao, picfile); //返回公告管理方法，执行公告信息的查询

        return "forward:/gonggaomanage.action";

    }


    //定义gonggaomanage方法响应页面请求

    @RequestMapping(value = "gonggaomanage")

    public String gonggaomanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行GonggaoController.gonggaomanage

        logger.debug("GonggaoController.gonggaomanage ......");


        gonggaoservice.gonggaomanage(request, session); //返回到公告管理页面

        return "gonggaomanage";

    }


    // 定义 gonggaoview方法

    @RequestMapping(value = "gonggaoview")

    public String gonggaoview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行GonggaoController.gonggaoview方法

        logger.debug("GonggaoController.gonggaoview ......");


        gonggaoservice.gonggaoview(request, session);

        // 返回公告查看页面

        return "gonggaoview";

    }


    // 定义 updategonggao方法

    @RequestMapping(value = "updategonggao")

    public String updategonggao(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志GonggaoController.updategonggao，表示正在执行该方法

        logger.debug("GonggaoController.updategonggao ......");


        gonggaoservice.updategonggao(request, session, id); // 返回修改公告页面

        return "updategonggao";

    }


    // 定义updategonggaoact处理公告修改

    @RequestMapping(value = "updategonggaoact")

    public String updategonggaoact(HttpServletRequest request, HttpServletResponse response, Gonggao gonggao, HttpSession session, MultipartFile picfile) throws IOException {

        // 输出日志，表示正在执行当前方法GonggaoController.updategonggaoact

        logger.debug("GonggaoController.updategonggaoact ......");

        gonggaoservice.updategonggaoact(request, gonggao, session, picfile);

        // 返回公告管理方法

        return "forward:/gonggaomanage.action";

    }


    // 定义deletegonggao,处理删除公告

    @RequestMapping(value = "deletegonggao")

    public String deletegonggao(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行GonggaoController.deletegonggao方法

        logger.debug("GonggaoController.deletegonggao ......");

        gonggaoservice.deletegonggao(request, session, id);

        // 返回公告管理方法

        return "forward:/gonggaomanage.action";

    }


    // 定义searchgonggao方法，处理搜索操作

    @RequestMapping(value = "searchgonggao")

    public String searchgonggao(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行GonggaoController.searchgonggao

        logger.debug("GonggaoController.searchgonggao ......");


        gonggaoservice.searchgonggao(request, session, search); // 返回查询公告页面

        return "searchgonggao";

    }


    // 定义GonggaopinglunMapper

    @RequestMapping(value = "gonggaodetails")

    public String gonggaodetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为GonggaoController.gonggaodetails

        logger.debug("GonggaoController.gonggaodetails ......");


        gonggaoservice.gonggaodetails(request, session, id); // 返回公告详情页面

        return "gonggaodetails";

    }


}

