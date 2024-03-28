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

import org.mypro.service.PostsServiceImp;

import org.mypro.entity.Posts;

import org.mypro.entity.PostsExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.dao.PostspinglunMapper;
import org.mypro.entity.PostspinglunExample;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class PostsController {


    private static final Log logger = LogFactory.getLog(PostsController.class);

    @Autowired
    private PostsServiceImp postsservice;


    //定义方法addposts,响应页面addposts请求

    @RequestMapping(value = "addposts")

    public String addposts(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addposts

        logger.debug("PostsController.addposts ......");

        postsservice.addposts(request, session);

        return "addposts";

    }


    //定义addpostsact方法,将帖子信息插入到数据库的t_posts表中

    @RequestMapping(value = "addpostsact")

    public String addpostsact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Posts posts, MultipartFile picfile) throws IOException {

        //输出当前方法日志，表示正在执行PostsController.addpostsact方法

        logger.debug("PostsController.addpostsact ......");

        postsservice.addpostsact(request, session, posts, picfile); //返回帖子管理方法，执行帖子信息的查询

        return "forward:/postsmanage.action";

    }


    //定义postsmanage方法响应页面请求

    @RequestMapping(value = "postsmanage")

    public String postsmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行PostsController.postsmanage

        logger.debug("PostsController.postsmanage ......");


        postsservice.postsmanage(request, session); //返回到帖子管理页面

        return "postsmanage";

    }


    // 定义 postsview方法

    @RequestMapping(value = "postsview")

    public String postsview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行PostsController.postsview方法

        logger.debug("PostsController.postsview ......");


        postsservice.postsview(request, session);

        // 返回帖子查看页面

        return "postsview";

    }


    // 定义 updateposts方法

    @RequestMapping(value = "updateposts")

    public String updateposts(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志PostsController.updateposts，表示正在执行该方法

        logger.debug("PostsController.updateposts ......");


        postsservice.updateposts(request, session, id); // 返回修改帖子页面

        return "updateposts";

    }


    // 定义updatepostsact处理帖子修改

    @RequestMapping(value = "updatepostsact")

    public String updatepostsact(HttpServletRequest request, HttpServletResponse response, Posts posts, HttpSession session, MultipartFile picfile) throws IOException {

        // 输出日志，表示正在执行当前方法PostsController.updatepostsact

        logger.debug("PostsController.updatepostsact ......");

        postsservice.updatepostsact(request, posts, session, picfile);

        // 返回帖子管理方法

        return "forward:/postsmanage.action";

    }


    // 定义deleteposts,处理删除帖子

    @RequestMapping(value = "deleteposts")

    public String deleteposts(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostsController.deleteposts方法

        logger.debug("PostsController.deleteposts ......");

        postsservice.deleteposts(request, session, id);

        // 返回帖子管理方法

        return "forward:/postsmanage.action";

    }


    // 定义searchposts方法，处理搜索操作

    @RequestMapping(value = "searchposts")

    public String searchposts(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行PostsController.searchposts

        logger.debug("PostsController.searchposts ......");


        postsservice.searchposts(request, session, search); // 返回查询帖子页面

        return "searchposts";

    }


    // 定义PostspinglunMapper

    @RequestMapping(value = "postsdetails")

    public String postsdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为PostsController.postsdetails

        logger.debug("PostsController.postsdetails ......");


        postsservice.postsdetails(request, session, id); // 返回帖子详情页面

        return "postsdetails";

    }


}

