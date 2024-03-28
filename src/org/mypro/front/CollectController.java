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

import org.mypro.service.CollectServiceImp;

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

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class CollectController {


    private static final Log logger = LogFactory.getLog(CollectController.class);

    @Autowired
    private CollectServiceImp collectservice;


    //定义方法addcollect,响应页面addcollect请求

    @RequestMapping(value = "addcollect")

    public String addcollect(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addcollect

        logger.debug("CollectController.addcollect ......");

        collectservice.addcollect(request, session);

        return "addcollect";

    }


    //定义useraddcollect方法

    @RequestMapping(value = "useraddcollect")

    public String useraddcollect(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，表示当前正在执行CollectController.useraddcollect方法

        logger.debug("CollectController.useraddcollect ......");

        collectservice.useraddcollect(request, session);


        //返回添加收藏页面

        return "useraddcollect";

    }


    // 定义userupdatecollect方法

    @RequestMapping(value = "userupdatecollect")

    public String userupdatecollect(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志CollectController.userupdatecollect

        logger.debug("CollectController.userupdatecollect ......");

        collectservice.userupdatecollect(request, session, id);


        // 返回user修改收藏页面

        return "userupdatecollect";

    }


    //定义usercollectmanage方法

    @RequestMapping(value = "usercollectmanage")

    public String usercollectmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志 ，表示当前正在执行方法为CollectController.usercollectmanage

        logger.debug("CollectController.usercollectmanage ......");

        collectservice.usercollectmanage(request, session); // 返回user收藏管理页面


        return "usercollectmanage";

    }


    //定义useraddcollectact，响应页面添加收藏请求

    @RequestMapping(value = "useraddcollectact")

    public String useraddcollectact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Collect collect) throws IOException {

        //输出日志，表示当前正在执行方法为CollectController.useraddcollectact

        logger.debug("CollectController.useraddcollectact ......");

        collectservice.useraddcollectact(request, session, collect); //返回到user添加收藏方法

        return "forward:/usercollectmanage.action";

    }


    //定义addcollectact方法,将收藏信息插入到数据库的t_collect表中

    @RequestMapping(value = "addcollectact")

    public String addcollectact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Collect collect) throws IOException {

        //输出当前方法日志，表示正在执行CollectController.addcollectact方法

        logger.debug("CollectController.addcollectact ......");

        collectservice.addcollectact(request, session, collect); //返回收藏管理方法，执行收藏信息的查询

        return "forward:/collectmanage.action";

    }


    //定义collectmanage方法响应页面请求

    @RequestMapping(value = "collectmanage")

    public String collectmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行CollectController.collectmanage

        logger.debug("CollectController.collectmanage ......");


        collectservice.collectmanage(request, session); //返回到收藏管理页面

        return "collectmanage";

    }


    // 定义 collectview方法

    @RequestMapping(value = "collectview")

    public String collectview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行CollectController.collectview方法

        logger.debug("CollectController.collectview ......");


        collectservice.collectview(request, session);

        // 返回收藏查看页面

        return "collectview";

    }


    // 定义 updatecollect方法

    @RequestMapping(value = "updatecollect")

    public String updatecollect(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志CollectController.updatecollect，表示正在执行该方法

        logger.debug("CollectController.updatecollect ......");


        collectservice.updatecollect(request, session, id); // 返回修改收藏页面

        return "updatecollect";

    }


    // 定义updatecollectact处理收藏修改

    @RequestMapping(value = "updatecollectact")

    public String updatecollectact(HttpServletRequest request, HttpServletResponse response, Collect collect, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法CollectController.updatecollectact

        logger.debug("CollectController.updatecollectact ......");

        collectservice.updatecollectact(request, collect, session);

        // 返回收藏管理方法

        return "forward:/collectmanage.action";

    }


    // 定义userupdatecollectact方法

    @RequestMapping(value = "userupdatecollectact")

    public String userupdatecollectact(HttpServletRequest request, HttpServletResponse response, Collect collect, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("CollectController.userupdatecollectact ......");

        collectservice.userupdatecollectact(request, collect, session);

        // 返回user收藏管理方法

        return "forward:/usercollectmanage.action";

    }


    // 定义deletecollect,处理删除收藏

    @RequestMapping(value = "deletecollect")

    public String deletecollect(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CollectController.deletecollect方法

        logger.debug("CollectController.deletecollect ......");

        collectservice.deletecollect(request, session, id);

        // 返回收藏管理方法

        return "forward:/collectmanage.action";

    }


    // 定义userdeletecollect方法

    @RequestMapping(value = "userdeletecollect")

    public String userdeletecollect(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CollectController.userdeletecollect方法

        logger.debug("CollectController.userdeletecollect ......");


        collectservice.userdeletecollect(request, session, id); // 返回user收藏管理方法

        return "forward:/usercollectmanage.action";

    }


    // 定义searchcollect方法，处理搜索操作

    @RequestMapping(value = "searchcollect")

    public String searchcollect(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行CollectController.searchcollect

        logger.debug("CollectController.searchcollect ......");


        collectservice.searchcollect(request, session, search); // 返回查询收藏页面

        return "searchcollect";

    }


    // 定义CollectpinglunMapper

    @RequestMapping(value = "collectdetails")

    public String collectdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为CollectController.collectdetails

        logger.debug("CollectController.collectdetails ......");


        collectservice.collectdetails(request, session, id); // 返回收藏详情页面

        return "collectdetails";

    }


}

