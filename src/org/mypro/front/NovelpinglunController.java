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

import org.mypro.service.NovelpinglunServiceImp;

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

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class NovelpinglunController {


    private static final Log logger = LogFactory.getLog(NovelpinglunController.class);

    @Autowired
    private NovelpinglunServiceImp novelpinglunservice;


    //定义方法addnovelpinglun,响应页面addnovelpinglun请求

    @RequestMapping(value = "addnovelpinglun")

    public String addnovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addnovelpinglun

        logger.debug("NovelpinglunController.addnovelpinglun ......");

        novelpinglunservice.addnovelpinglun(request, session);

        return "addnovelpinglun";

    }


    //定义useraddnovelpinglun方法

    @RequestMapping(value = "useraddnovelpinglun")

    public String useraddnovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，表示当前正在执行NovelpinglunController.useraddnovelpinglun方法

        logger.debug("NovelpinglunController.useraddnovelpinglun ......");

        novelpinglunservice.useraddnovelpinglun(request, session);


        //返回添加小说评论页面

        return "useraddnovelpinglun";

    }


    // 定义userupdatenovelpinglun方法

    @RequestMapping(value = "userupdatenovelpinglun")

    public String userupdatenovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志NovelpinglunController.userupdatenovelpinglun

        logger.debug("NovelpinglunController.userupdatenovelpinglun ......");

        novelpinglunservice.userupdatenovelpinglun(request, session, id);


        // 返回user修改小说评论页面

        return "userupdatenovelpinglun";

    }


    // 定义usernovelpinglunmanage方法

    @RequestMapping(value = "usernovelpinglunmanage")

    public String usernovelpinglunmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行方法NovelpinglunController.usernovelpinglunmanage

        logger.debug("NovelpinglunController.usernovelpinglunmanage ......");

        novelpinglunservice.usernovelpinglunmanage(request, session); // 返回user小说评论管理页面

        return "usernovelpinglunmanage";

    }


    //定义useraddnovelpinglunact，响应页面添加小说评论请求

    @RequestMapping(value = "useraddnovelpinglunact")

    public String useraddnovelpinglunact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Novelpinglun novelpinglun) throws IOException {

        //输出日志，表示当前正在执行方法为NovelpinglunController.useraddnovelpinglunact

        logger.debug("NovelpinglunController.useraddnovelpinglunact ......");

        novelpinglunservice.useraddnovelpinglunact(request, session, novelpinglun); //返回到user添加小说评论方法

        return "forward:/usernovelpinglunmanage.action";

    }


    //定义addnovelpinglunact方法,将小说评论信息插入到数据库的t_novelpinglun表中

    @RequestMapping(value = "addnovelpinglunact")

    public String addnovelpinglunact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Novelpinglun novelpinglun, String backurl) throws IOException {

        //输出当前方法日志，表示正在执行NovelpinglunController.addnovelpinglunact方法

        logger.debug("NovelpinglunController.addnovelpinglunact ......");

        novelpinglunservice.addnovelpinglunact(request, session, novelpinglun);        //如果存在返回地址，且返回地址不等于添加小说评论
        if (backurl != null && backurl.indexOf("addnovelpinglunact.action") == -1) {
// 返回backurl所对应的方法

            return "forward:/" + backurl;
        }
        //返回小说评论管理方法，执行小说评论信息的查询

        return "forward:/novelpinglunmanage.action";

    }


    //定义novelpinglunmanage方法响应页面请求

    @RequestMapping(value = "novelpinglunmanage")

    public String novelpinglunmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行NovelpinglunController.novelpinglunmanage

        logger.debug("NovelpinglunController.novelpinglunmanage ......");


        novelpinglunservice.novelpinglunmanage(request, session); //返回到小说评论管理页面

        return "novelpinglunmanage";

    }


    // 定义 novelpinglunview方法

    @RequestMapping(value = "novelpinglunview")

    public String novelpinglunview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行NovelpinglunController.novelpinglunview方法

        logger.debug("NovelpinglunController.novelpinglunview ......");


        novelpinglunservice.novelpinglunview(request, session);

        // 返回小说评论查看页面

        return "novelpinglunview";

    }


    // 定义 updatenovelpinglun方法

    @RequestMapping(value = "updatenovelpinglun")

    public String updatenovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志NovelpinglunController.updatenovelpinglun，表示正在执行该方法

        logger.debug("NovelpinglunController.updatenovelpinglun ......");


        novelpinglunservice.updatenovelpinglun(request, session, id); // 返回修改小说评论页面

        return "updatenovelpinglun";

    }


    // 定义updatenovelpinglunact处理小说评论修改

    @RequestMapping(value = "updatenovelpinglunact")

    public String updatenovelpinglunact(HttpServletRequest request, HttpServletResponse response, Novelpinglun novelpinglun, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法NovelpinglunController.updatenovelpinglunact

        logger.debug("NovelpinglunController.updatenovelpinglunact ......");

        novelpinglunservice.updatenovelpinglunact(request, novelpinglun, session);

        // 返回小说评论管理方法

        return "forward:/novelpinglunmanage.action";

    }


    // 定义userupdatenovelpinglunact方法

    @RequestMapping(value = "userupdatenovelpinglunact")

    public String userupdatenovelpinglunact(HttpServletRequest request, HttpServletResponse response, Novelpinglun novelpinglun, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("NovelpinglunController.userupdatenovelpinglunact ......");

        novelpinglunservice.userupdatenovelpinglunact(request, novelpinglun, session);

        // 返回user小说评论管理方法

        return "forward:/usernovelpinglunmanage.action";

    }


    // 定义deletenovelpinglun,处理删除小说评论

    @RequestMapping(value = "deletenovelpinglun")

    public String deletenovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelpinglunController.deletenovelpinglun方法

        logger.debug("NovelpinglunController.deletenovelpinglun ......");

        novelpinglunservice.deletenovelpinglun(request, session, id);

        // 返回小说评论管理方法

        return "forward:/novelpinglunmanage.action";

    }


    // 定义userdeletenovelpinglun方法

    @RequestMapping(value = "userdeletenovelpinglun")

    public String userdeletenovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelpinglunController.userdeletenovelpinglun方法

        logger.debug("NovelpinglunController.userdeletenovelpinglun ......");


        novelpinglunservice.userdeletenovelpinglun(request, session, id); // 返回user小说评论管理方法

        return "forward:/usernovelpinglunmanage.action";

    }


    // 定义searchnovelpinglun方法，处理搜索操作

    @RequestMapping(value = "searchnovelpinglun")

    public String searchnovelpinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行NovelpinglunController.searchnovelpinglun

        logger.debug("NovelpinglunController.searchnovelpinglun ......");


        novelpinglunservice.searchnovelpinglun(request, session, search); // 返回查询小说评论页面

        return "searchnovelpinglun";

    }


    // 定义NovelpinglunpinglunMapper

    @RequestMapping(value = "novelpinglundetails")

    public String novelpinglundetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为NovelpinglunController.novelpinglundetails

        logger.debug("NovelpinglunController.novelpinglundetails ......");


        novelpinglunservice.novelpinglundetails(request, session, id); // 返回小说评论详情页面

        return "novelpinglundetails";

    }


}

