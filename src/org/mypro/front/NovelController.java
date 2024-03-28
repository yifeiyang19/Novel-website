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

import org.mypro.service.NovelServiceImp;

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

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class NovelController {


    private static final Log logger = LogFactory.getLog(NovelController.class);

    @Autowired
    private NovelServiceImp novelservice;


    @ResponseBody
    @RequestMapping(value = "collectjson")
    public Map collectjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody Collect collect) {
        //输出日志，当前执行方法为collectjson
        logger.debug("NoveljsonController.collectjson ......");

        Map result = novelservice.collectjson(request, session, collect);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "likesjson")
    public Map likesjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody Likes likes) {
        //输出日志，当前执行方法为likesjson
        logger.debug("NoveljsonController.likesjson ......");

        Map result = novelservice.likesjson(request, session, likes);

        return result;
    }


    //定义方法addnovel,响应页面addnovel请求

    @RequestMapping(value = "addnovel")

    public String addnovel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addnovel

        logger.debug("NovelController.addnovel ......");

        novelservice.addnovel(request, session);

        return "addnovel";

    }


    //定义addnovelact方法,将小说信息插入到数据库的t_novel表中

    @RequestMapping(value = "addnovelact")

    public String addnovelact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Novel novel, MultipartFile picfile, MultipartFile uploadsfile) throws IOException {

        //输出当前方法日志，表示正在执行NovelController.addnovelact方法

        logger.debug("NovelController.addnovelact ......");

        novelservice.addnovelact(request, session, novel, picfile, uploadsfile); //返回小说管理方法，执行小说信息的查询

        return "forward:/novelmanage.action";

    }


    //定义novelmanage方法响应页面请求

    @RequestMapping(value = "novelmanage")

    public String novelmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行NovelController.novelmanage

        logger.debug("NovelController.novelmanage ......");


        novelservice.novelmanage(request, session); //返回到小说管理页面

        return "novelmanage";

    }


    // 定义 novelview方法

    @RequestMapping(value = "novelview")

    public String novelview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行NovelController.novelview方法

        logger.debug("NovelController.novelview ......");


        novelservice.novelview(request, session);

        // 返回小说查看页面

        return "novelview";

    }


    // 定义 updatenovel方法

    @RequestMapping(value = "updatenovel")

    public String updatenovel(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志NovelController.updatenovel，表示正在执行该方法

        logger.debug("NovelController.updatenovel ......");


        novelservice.updatenovel(request, session, id); // 返回修改小说页面

        return "updatenovel";

    }


    // 定义updatenovelact处理小说修改

    @RequestMapping(value = "updatenovelact")

    public String updatenovelact(HttpServletRequest request, HttpServletResponse response, Novel novel, HttpSession session, MultipartFile picfile, MultipartFile uploadsfile) throws IOException {

        // 输出日志，表示正在执行当前方法NovelController.updatenovelact

        logger.debug("NovelController.updatenovelact ......");

        novelservice.updatenovelact(request, novel, session, picfile, uploadsfile);

        // 返回小说管理方法

        return "forward:/novelmanage.action";

    }


    // 定义deletenovel,处理删除小说

    @RequestMapping(value = "deletenovel")

    public String deletenovel(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelController.deletenovel方法

        logger.debug("NovelController.deletenovel ......");

        novelservice.deletenovel(request, session, id);

        // 返回小说管理方法

        return "forward:/novelmanage.action";

    }


    // 定义searchnovel方法，处理搜索操作

    @RequestMapping(value = "searchnovel")

    public String searchnovel(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行NovelController.searchnovel

        logger.debug("NovelController.searchnovel ......");


        novelservice.searchnovel(request, session, search); // 返回查询小说页面

        return "searchnovel";

    }


    // 定义NovelpinglunMapper

    @RequestMapping(value = "noveldetails")

    public String noveldetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为NovelController.noveldetails

        logger.debug("NovelController.noveldetails ......");


        novelservice.noveldetails(request, session, id); // 返回小说详情页面

        return "noveldetails";

    }


}

