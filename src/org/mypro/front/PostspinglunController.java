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

import org.mypro.service.PostspinglunServiceImp;

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

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class PostspinglunController {


    private static final Log logger = LogFactory.getLog(PostspinglunController.class);

    @Autowired
    private PostspinglunServiceImp postspinglunservice;


    //定义方法addpostspinglun,响应页面addpostspinglun请求

    @RequestMapping(value = "addpostspinglun")

    public String addpostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addpostspinglun

        logger.debug("PostspinglunController.addpostspinglun ......");

        postspinglunservice.addpostspinglun(request, session);

        return "addpostspinglun";

    }


    //定义useraddpostspinglun方法

    @RequestMapping(value = "useraddpostspinglun")

    public String useraddpostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，表示当前正在执行PostspinglunController.useraddpostspinglun方法

        logger.debug("PostspinglunController.useraddpostspinglun ......");

        postspinglunservice.useraddpostspinglun(request, session);


        //返回添加帖子评论页面

        return "useraddpostspinglun";

    }


    // 定义userupdatepostspinglun方法

    @RequestMapping(value = "userupdatepostspinglun")

    public String userupdatepostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志PostspinglunController.userupdatepostspinglun

        logger.debug("PostspinglunController.userupdatepostspinglun ......");

        postspinglunservice.userupdatepostspinglun(request, session, id);


        // 返回user修改帖子评论页面

        return "userupdatepostspinglun";

    }


    // 定义userpostspinglunmanage方法

    @RequestMapping(value = "userpostspinglunmanage")

    public String userpostspinglunmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行方法PostspinglunController.userpostspinglunmanage

        logger.debug("PostspinglunController.userpostspinglunmanage ......");

        postspinglunservice.userpostspinglunmanage(request, session); // 返回user帖子评论管理页面

        return "userpostspinglunmanage";

    }


    //定义useraddpostspinglunact，响应页面添加帖子评论请求

    @RequestMapping(value = "useraddpostspinglunact")

    public String useraddpostspinglunact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Postspinglun postspinglun) throws IOException {

        //输出日志，表示当前正在执行方法为PostspinglunController.useraddpostspinglunact

        logger.debug("PostspinglunController.useraddpostspinglunact ......");

        postspinglunservice.useraddpostspinglunact(request, session, postspinglun); //返回到user添加帖子评论方法

        return "forward:/userpostspinglunmanage.action";

    }


    //定义addpostspinglunact方法,将帖子评论信息插入到数据库的t_postspinglun表中

    @RequestMapping(value = "addpostspinglunact")

    public String addpostspinglunact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Postspinglun postspinglun, String backurl) throws IOException {

        //输出当前方法日志，表示正在执行PostspinglunController.addpostspinglunact方法

        logger.debug("PostspinglunController.addpostspinglunact ......");

        postspinglunservice.addpostspinglunact(request, session, postspinglun);        //如果存在返回地址，且返回地址不等于添加帖子评论
        if (backurl != null && backurl.indexOf("addpostspinglunact.action") == -1) {
// 返回backurl所对应的方法

            return "forward:/" + backurl;
        }
        //返回帖子评论管理方法，执行帖子评论信息的查询

        return "forward:/postspinglunmanage.action";

    }


    //定义postspinglunmanage方法响应页面请求

    @RequestMapping(value = "postspinglunmanage")

    public String postspinglunmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行PostspinglunController.postspinglunmanage

        logger.debug("PostspinglunController.postspinglunmanage ......");


        postspinglunservice.postspinglunmanage(request, session); //返回到帖子评论管理页面

        return "postspinglunmanage";

    }


    // 定义 postspinglunview方法

    @RequestMapping(value = "postspinglunview")

    public String postspinglunview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行PostspinglunController.postspinglunview方法

        logger.debug("PostspinglunController.postspinglunview ......");


        postspinglunservice.postspinglunview(request, session);

        // 返回帖子评论查看页面

        return "postspinglunview";

    }


    // 定义 updatepostspinglun方法

    @RequestMapping(value = "updatepostspinglun")

    public String updatepostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志PostspinglunController.updatepostspinglun，表示正在执行该方法

        logger.debug("PostspinglunController.updatepostspinglun ......");


        postspinglunservice.updatepostspinglun(request, session, id); // 返回修改帖子评论页面

        return "updatepostspinglun";

    }


    // 定义updatepostspinglunact处理帖子评论修改

    @RequestMapping(value = "updatepostspinglunact")

    public String updatepostspinglunact(HttpServletRequest request, HttpServletResponse response, Postspinglun postspinglun, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法PostspinglunController.updatepostspinglunact

        logger.debug("PostspinglunController.updatepostspinglunact ......");

        postspinglunservice.updatepostspinglunact(request, postspinglun, session);

        // 返回帖子评论管理方法

        return "forward:/postspinglunmanage.action";

    }


    // 定义userupdatepostspinglunact方法

    @RequestMapping(value = "userupdatepostspinglunact")

    public String userupdatepostspinglunact(HttpServletRequest request, HttpServletResponse response, Postspinglun postspinglun, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("PostspinglunController.userupdatepostspinglunact ......");

        postspinglunservice.userupdatepostspinglunact(request, postspinglun, session);

        // 返回user帖子评论管理方法

        return "forward:/userpostspinglunmanage.action";

    }


    // 定义deletepostspinglun,处理删除帖子评论

    @RequestMapping(value = "deletepostspinglun")

    public String deletepostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostspinglunController.deletepostspinglun方法

        logger.debug("PostspinglunController.deletepostspinglun ......");

        postspinglunservice.deletepostspinglun(request, session, id);

        // 返回帖子评论管理方法

        return "forward:/postspinglunmanage.action";

    }


    // 定义userdeletepostspinglun方法

    @RequestMapping(value = "userdeletepostspinglun")

    public String userdeletepostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostspinglunController.userdeletepostspinglun方法

        logger.debug("PostspinglunController.userdeletepostspinglun ......");


        postspinglunservice.userdeletepostspinglun(request, session, id); // 返回user帖子评论管理方法

        return "forward:/userpostspinglunmanage.action";

    }


    // 定义searchpostspinglun方法，处理搜索操作

    @RequestMapping(value = "searchpostspinglun")

    public String searchpostspinglun(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行PostspinglunController.searchpostspinglun

        logger.debug("PostspinglunController.searchpostspinglun ......");


        postspinglunservice.searchpostspinglun(request, session, search); // 返回查询帖子评论页面

        return "searchpostspinglun";

    }


    // 定义PostspinglunpinglunMapper

    @RequestMapping(value = "postspinglundetails")

    public String postspinglundetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为PostspinglunController.postspinglundetails

        logger.debug("PostspinglunController.postspinglundetails ......");


        postspinglunservice.postspinglundetails(request, session, id); // 返回帖子评论详情页面

        return "postspinglundetails";

    }


}

