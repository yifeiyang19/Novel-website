package org.mypro.front;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import org.mypro.dao.NovelMapper;

import org.mypro.entity.NovelExample;

import org.mypro.dao.CategoryMapper;

import org.mypro.entity.CategoryExample;

import org.mypro.dao.PostsMapper;

import org.mypro.entity.PostsExample;

import org.mypro.dao.GonggaoMapper;

import org.mypro.entity.GonggaoExample;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import java.util.Map;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class IndexController {

    private static final Log logger = LogFactory.getLog(IndexController.class);

    @Autowired
    private NovelMapper noveldao;

    @Autowired
    private CategoryMapper categorydao;

    @Autowired
    private PostsMapper postsdao;

    @Autowired
    private GonggaoMapper gonggaodao;

    @RequestMapping(value = "index")

    public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        logger.debug("IndexController.index ......");// 实例化NovelExample
        NovelExample example1 = new NovelExample();

// 实例化NovelExample内部类Criteria  
        NovelExample.Criteria criteria1 = example1.createCriteria();

// 查询所有小说保存到novelall1中  
        List novelall1 = noveldao.selectByExample(example1);

// 定义最新小说list  
        List novelzuixin6 = null;

// 如果所有的小说数量大于了 6 
        if (novelall1.size() > 6) {

// 截取novelall1中的前6位保存到最新小说list中 
            novelzuixin6 = novelall1.subList(novelall1.size() - 7, novelall1.size() - 1);

        } else {

// 将所有小说添加到最新小说list中 
            novelzuixin6 = novelall1;

        }

// 将最新小说list保存到request中 
        request.setAttribute("novelzuixin6", novelzuixin6);

// 实例化CategoryExample  
        CategoryExample example2 = new CategoryExample();

// 实例化CategoryExample内部类Criteria  
        CategoryExample.Criteria criteria2 = example2.createCriteria();

// 查询所有分类保存到categoryall2中  
        List categoryall2 = categorydao.selectByExample(example2);

// 定义最新分类list  
        List categoryzuixin6 = null;

// 如果所有的分类数量大于了 6 
        if (categoryall2.size() > 6) {

// 截取categoryall2中的前6位保存到最新分类list中 
            categoryzuixin6 = categoryall2.subList(categoryall2.size() - 7, categoryall2.size() - 1);

        } else {

// 将所有分类添加到最新分类list中 
            categoryzuixin6 = categoryall2;

        }

// 将最新分类list保存到request中 
        request.setAttribute("categoryzuixin6", categoryzuixin6);

// 实例化PostsExample  
        PostsExample example3 = new PostsExample();

// 实例化PostsExample内部类Criteria  
        PostsExample.Criteria criteria3 = example3.createCriteria();

// 查询所有帖子保存到postsall3中  
        List postsall3 = postsdao.selectByExample(example3);

// 定义最新帖子list  
        List postszuixin6 = null;

// 如果所有的帖子数量大于了 6 
        if (postsall3.size() > 6) {

// 截取postsall3中的前6位保存到最新帖子list中 
            postszuixin6 = postsall3.subList(postsall3.size() - 7, postsall3.size() - 1);

        } else {

// 将所有帖子添加到最新帖子list中 
            postszuixin6 = postsall3;

        }

// 将最新帖子list保存到request中 
        request.setAttribute("postszuixin6", postszuixin6);

// 实例化GonggaoExample  
        GonggaoExample example4 = new GonggaoExample();

// 实例化GonggaoExample内部类Criteria  
        GonggaoExample.Criteria criteria4 = example4.createCriteria();

// 查询所有公告保存到gonggaoall4中  
        List gonggaoall4 = gonggaodao.selectByExample(example4);

// 定义最新公告list  
        List gonggaozuixin6 = null;

// 如果所有的公告数量大于了 6 
        if (gonggaoall4.size() > 6) {

// 截取gonggaoall4中的前6位保存到最新公告list中 
            gonggaozuixin6 = gonggaoall4.subList(gonggaoall4.size() - 7, gonggaoall4.size() - 1);

        } else {

// 将所有公告添加到最新公告list中 
            gonggaozuixin6 = gonggaoall4;

        }

// 将最新公告list保存到request中 
        request.setAttribute("gonggaozuixin6", gonggaozuixin6);

        return "index";

    }

    // 上传文件图片等

    public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {

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

