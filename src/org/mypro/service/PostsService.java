package org.mypro.service;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.mypro.dao.PostsMapper;

import org.mypro.entity.Posts;

import org.mypro.entity.PostsExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.dao.PostspinglunMapper;
import org.mypro.entity.PostspinglunExample;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class PostsService implements PostsServiceImp {


    private static final Log logger = LogFactory.getLog(PostsService.class);

    @Autowired
    private PostsMapper postsdao; // 定义PostspinglunMapper


    @Autowired
    private PostspinglunMapper postspinglundao;


    //定义方法addposts,响应控制层addposts请求

    public void addposts(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addposts

        logger.debug("PostsService.addposts ......");


    }


    //定义addpostsact方法

    public void addpostsact(HttpServletRequest request, HttpSession session, Posts posts, MultipartFile picfile) throws IOException {

        //输出当前方法日志，表示正在执行PostsService.addpostsact方法

        logger.debug("PostsService.addpostsact ......");

// 判断图片文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的图片文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将posts的图片设置为pic的值  

            posts.setPic(pic);

        }


        //使用postsdao的insert方法将帖子添加到数据库中

        postsdao.insert(posts);


        //将添加帖子信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加帖子成功");

    }


    //定义postsmanage方法响应页面请求

    public void postsmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行PostsService.postsmanage

        logger.debug("PostsService.postsmanage ......");


        //实例化PostsExample类为example

        PostsExample example = new PostsExample();


        //使用  postsdao.selectByExample(example)方法获取所有的帖子数据

        List postsall = postsdao.selectByExample(example);


        //将所有的帖子数据保存到request中的postsall参数里

        request.setAttribute("postsall", postsall);


    }


    // 定义 postsview方法

    public void postsview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行PostsService.postsview方法

        logger.debug("PostsService.postsview ......");


        // 实例化PostsExample类

        PostsExample example = new PostsExample();


        // 使用postsdao的selectByExample方法查询帖子信息

        List postsall = postsdao.selectByExample(example);


        // 将查询的postsall保存到request中，记录为参数postsall

        request.setAttribute("postsall", postsall);


    }


    // 定义 updateposts方法

    public void updateposts(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志PostsController.updateposts，表示正在执行该方法

        logger.debug("PostsController.updateposts ......");


        // 定义帖子为biaoming，使用 postsdao的selectByPrimaryKey方法通过id查询数据

        Posts posts = postsdao.selectByPrimaryKey(id);


        // 将查询的帖子保存到request中

        request.setAttribute("posts", posts);


    }


    // 定义updatepostsact处理帖子修改

    public void updatepostsact(HttpServletRequest request, Posts posts, HttpSession session, MultipartFile picfile) throws IOException {

        // 输出日志，表示正在执行当前方法PostsController.updatepostsact

        logger.debug("PostsController.updatepostsact ......");

// 判断图片文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的图片文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将posts的图片设置为pic的值  

            posts.setPic(pic);

        }


        // 执行postsdao的updateByPrimaryKeySelective方法，将传入的帖子数据同步到数据库中

        postsdao.updateByPrimaryKeySelective(posts);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改帖子信息成功");


    }


    // 定义deleteposts,处理删除帖子

    public void deleteposts(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostsService.deleteposts方法

        logger.debug("PostsService.deleteposts ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化帖子example
            PostsExample example = new PostsExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化帖子criteria
            PostsExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的帖子id信息
            List<Integer> idlist = new ArrayList();
            //根据id分离出需要删除的数据id信息
            String[] idarr = ids.split(",");
            //将对应的id数据信息保存到数组中
            for (int i = 0; i < idarr.length; i++) {
                //取出对应的id信息，并转换成int类型
                idlist.add(Integer.parseInt(idarr[i]));
            }
            //传入需要删除的id数组信息
            criteria.andIdIn(idlist);
            //调用帖子的dao类，执行批量删除操作
            postsdao.deleteByExample(example);
        } else {
            // 根据id调用postsdao的deleteByPrimaryKey方法，删除帖子


            postsdao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除帖子成功");


    }


    // 定义searchposts方法，处理搜索操作

    public void searchposts(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行PostsService.searchposts

        logger.debug("PostsService.searchposts ......");


        // 实例化 PostsExample

        PostsExample example = new PostsExample();

        // 实例化 PostsExample的Criteria内部类

        PostsExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andTitleLike("%" + search + "%");

        }

        // 查询帖子结果

        List postsall = postsdao.selectByExample(example);

        // 将查询到的帖子 保存到request中进行保存

        request.setAttribute("postsall", postsall);

    }


    // 定义PostspinglunMapper

    public void postsdetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为PostsController.postsdetails

        logger.debug("PostsController.postsdetails ......");


        // 传入页面所传入的帖子id使用postsdao的selectByPrimaryKey方法进行查询

        Posts posts = postsdao.selectByPrimaryKey(id);

        // 将查询到的帖子保存到request中

        request.setAttribute("posts", posts);


        // 实例化PostspinglunExample

        PostspinglunExample example = new PostspinglunExample();
        PostspinglunExample.Criteria criteria = example.createCriteria();
        criteria.andPostsidEqualTo(id); // 使用postspinglundao的selectByExample方法查询postspinglunall

        List postspinglunall = postspinglundao.selectByExample(example);

        // 将postspinglunall保存到request中

        request.setAttribute("postspinglunall", postspinglunall);

    }


//	上传文件图片等

    public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {

        // 根据当前时间生成时间字符串

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

        String res = sdf.format(new Date());

        // uploads文件夹位置

        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");

        // 原始名称

        String originalFileName = file.getOriginalFilename();

        // 新文件名

        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));

        // 创建年月文件夹

        Calendar date = Calendar.getInstance();

        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));

        // 新文件

        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);

        // 判断目标文件所在目录是否存在

        if (!newFile.getParentFile().exists()) {

            // 如果目标文件所在的目录不存在，则创建父目录

            newFile.getParentFile().mkdirs();

        }

        System.out.println(newFile);

        // 将内存中的数据写入磁盘

        file.transferTo(newFile);

        // 完整的url

        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + newFileName;

        return fileUrl;

    }
}

