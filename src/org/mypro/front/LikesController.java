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

import org.mypro.service.LikesServiceImp;

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

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class LikesController {


    private static final Log logger = LogFactory.getLog(LikesController.class);

    @Autowired
    private LikesServiceImp likesservice;


    //定义方法addlikes,响应页面addlikes请求

    @RequestMapping(value = "addlikes")

    public String addlikes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addlikes

        logger.debug("LikesController.addlikes ......");

        likesservice.addlikes(request, session);

        return "addlikes";

    }


    //定义useraddlikes方法

    @RequestMapping(value = "useraddlikes")

    public String useraddlikes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，表示当前正在执行LikesController.useraddlikes方法

        logger.debug("LikesController.useraddlikes ......");

        likesservice.useraddlikes(request, session);


        //返回添加点赞页面

        return "useraddlikes";

    }


    // 定义userupdatelikes方法

    @RequestMapping(value = "userupdatelikes")

    public String userupdatelikes(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志LikesController.userupdatelikes

        logger.debug("LikesController.userupdatelikes ......");

        likesservice.userupdatelikes(request, session, id);


        // 返回user修改点赞页面

        return "userupdatelikes";

    }


    //定义userlikesmanage方法

    @RequestMapping(value = "userlikesmanage")

    public String userlikesmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志 ，表示当前正在执行方法为LikesController.userlikesmanage

        logger.debug("LikesController.userlikesmanage ......");

        likesservice.userlikesmanage(request, session); // 返回user点赞管理页面


        return "userlikesmanage";

    }


    //定义useraddlikesact，响应页面添加点赞请求

    @RequestMapping(value = "useraddlikesact")

    public String useraddlikesact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Likes likes) throws IOException {

        //输出日志，表示当前正在执行方法为LikesController.useraddlikesact

        logger.debug("LikesController.useraddlikesact ......");

        likesservice.useraddlikesact(request, session, likes); //返回到user添加点赞方法

        return "forward:/userlikesmanage.action";

    }


    //定义addlikesact方法,将点赞信息插入到数据库的t_likes表中

    @RequestMapping(value = "addlikesact")

    public String addlikesact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Likes likes) throws IOException {

        //输出当前方法日志，表示正在执行LikesController.addlikesact方法

        logger.debug("LikesController.addlikesact ......");

        likesservice.addlikesact(request, session, likes); //返回点赞管理方法，执行点赞信息的查询

        return "forward:/likesmanage.action";

    }


    //定义likesmanage方法响应页面请求

    @RequestMapping(value = "likesmanage")

    public String likesmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行LikesController.likesmanage

        logger.debug("LikesController.likesmanage ......");


        likesservice.likesmanage(request, session); //返回到点赞管理页面

        return "likesmanage";

    }


    // 定义 likesview方法

    @RequestMapping(value = "likesview")

    public String likesview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行LikesController.likesview方法

        logger.debug("LikesController.likesview ......");


        likesservice.likesview(request, session);

        // 返回点赞查看页面

        return "likesview";

    }


    // 定义 updatelikes方法

    @RequestMapping(value = "updatelikes")

    public String updatelikes(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志LikesController.updatelikes，表示正在执行该方法

        logger.debug("LikesController.updatelikes ......");


        likesservice.updatelikes(request, session, id); // 返回修改点赞页面

        return "updatelikes";

    }


    // 定义updatelikesact处理点赞修改

    @RequestMapping(value = "updatelikesact")

    public String updatelikesact(HttpServletRequest request, HttpServletResponse response, Likes likes, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法LikesController.updatelikesact

        logger.debug("LikesController.updatelikesact ......");

        likesservice.updatelikesact(request, likes, session);

        // 返回点赞管理方法

        return "forward:/likesmanage.action";

    }


    // 定义userupdatelikesact方法

    @RequestMapping(value = "userupdatelikesact")

    public String userupdatelikesact(HttpServletRequest request, HttpServletResponse response, Likes likes, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("LikesController.userupdatelikesact ......");

        likesservice.userupdatelikesact(request, likes, session);

        // 返回user点赞管理方法

        return "forward:/userlikesmanage.action";

    }


    // 定义deletelikes,处理删除点赞

    @RequestMapping(value = "deletelikes")

    public String deletelikes(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行LikesController.deletelikes方法

        logger.debug("LikesController.deletelikes ......");

        likesservice.deletelikes(request, session, id);

        // 返回点赞管理方法

        return "forward:/likesmanage.action";

    }


    // 定义userdeletelikes方法

    @RequestMapping(value = "userdeletelikes")

    public String userdeletelikes(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行LikesController.userdeletelikes方法

        logger.debug("LikesController.userdeletelikes ......");


        likesservice.userdeletelikes(request, session, id); // 返回user点赞管理方法

        return "forward:/userlikesmanage.action";

    }


    // 定义searchlikes方法，处理搜索操作

    @RequestMapping(value = "searchlikes")

    public String searchlikes(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行LikesController.searchlikes

        logger.debug("LikesController.searchlikes ......");


        likesservice.searchlikes(request, session, search); // 返回查询点赞页面

        return "searchlikes";

    }


    // 定义LikespinglunMapper

    @RequestMapping(value = "likesdetails")

    public String likesdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为LikesController.likesdetails

        logger.debug("LikesController.likesdetails ......");


        likesservice.likesdetails(request, session, id); // 返回点赞详情页面

        return "likesdetails";

    }


}

