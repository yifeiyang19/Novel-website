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

@Service

public class GonggaoService implements GonggaoServiceImp {


    private static final Log logger = LogFactory.getLog(GonggaoService.class);

    @Autowired
    private GonggaoMapper gonggaodao;


    //定义方法addgonggao,响应控制层addgonggao请求

    public void addgonggao(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addgonggao

        logger.debug("GonggaoService.addgonggao ......");


    }


    //定义addgonggaoact方法

    public void addgonggaoact(HttpServletRequest request, HttpSession session, Gonggao gonggao, MultipartFile picfile) throws IOException {

        //输出当前方法日志，表示正在执行GonggaoService.addgonggaoact方法

        logger.debug("GonggaoService.addgonggaoact ......");

// 判断图片文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的图片文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将gonggao的图片设置为pic的值  

            gonggao.setPic(pic);

        }


        //使用gonggaodao的insert方法将公告添加到数据库中

        gonggaodao.insert(gonggao);


        //将添加公告信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加公告成功");

    }


    //定义gonggaomanage方法响应页面请求

    public void gonggaomanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行GonggaoService.gonggaomanage

        logger.debug("GonggaoService.gonggaomanage ......");


        //实例化GonggaoExample类为example

        GonggaoExample example = new GonggaoExample();


        //使用  gonggaodao.selectByExample(example)方法获取所有的公告数据

        List gonggaoall = gonggaodao.selectByExample(example);


        //将所有的公告数据保存到request中的gonggaoall参数里

        request.setAttribute("gonggaoall", gonggaoall);


    }


    // 定义 gonggaoview方法

    public void gonggaoview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行GonggaoService.gonggaoview方法

        logger.debug("GonggaoService.gonggaoview ......");


        // 实例化GonggaoExample类

        GonggaoExample example = new GonggaoExample();


        // 使用gonggaodao的selectByExample方法查询公告信息

        List gonggaoall = gonggaodao.selectByExample(example);


        // 将查询的gonggaoall保存到request中，记录为参数gonggaoall

        request.setAttribute("gonggaoall", gonggaoall);


    }


    // 定义 updategonggao方法

    public void updategonggao(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志GonggaoController.updategonggao，表示正在执行该方法

        logger.debug("GonggaoController.updategonggao ......");


        // 定义公告为biaoming，使用 gonggaodao的selectByPrimaryKey方法通过id查询数据

        Gonggao gonggao = gonggaodao.selectByPrimaryKey(id);


        // 将查询的公告保存到request中

        request.setAttribute("gonggao", gonggao);


    }


    // 定义updategonggaoact处理公告修改

    public void updategonggaoact(HttpServletRequest request, Gonggao gonggao, HttpSession session, MultipartFile picfile) throws IOException {

        // 输出日志，表示正在执行当前方法GonggaoController.updategonggaoact

        logger.debug("GonggaoController.updategonggaoact ......");

// 判断图片文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的图片文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将gonggao的图片设置为pic的值  

            gonggao.setPic(pic);

        }


        // 执行gonggaodao的updateByPrimaryKeySelective方法，将传入的公告数据同步到数据库中

        gonggaodao.updateByPrimaryKeySelective(gonggao);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改公告信息成功");


    }


    // 定义deletegonggao,处理删除公告

    public void deletegonggao(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行GonggaoService.deletegonggao方法

        logger.debug("GonggaoService.deletegonggao ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化公告example
            GonggaoExample example = new GonggaoExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化公告criteria
            GonggaoExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的公告id信息
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
            //调用公告的dao类，执行批量删除操作
            gonggaodao.deleteByExample(example);
        } else {
            // 根据id调用gonggaodao的deleteByPrimaryKey方法，删除公告


            gonggaodao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除公告成功");


    }


    // 定义searchgonggao方法，处理搜索操作

    public void searchgonggao(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行GonggaoService.searchgonggao

        logger.debug("GonggaoService.searchgonggao ......");


        // 实例化 GonggaoExample

        GonggaoExample example = new GonggaoExample();

        // 实例化 GonggaoExample的Criteria内部类

        GonggaoExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andTitleLike("%" + search + "%");

        }

        // 查询公告结果

        List gonggaoall = gonggaodao.selectByExample(example);

        // 将查询到的公告 保存到request中进行保存

        request.setAttribute("gonggaoall", gonggaoall);

    }


    // 定义GonggaopinglunMapper

    public void gonggaodetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为GonggaoController.gonggaodetails

        logger.debug("GonggaoController.gonggaodetails ......");


        // 传入页面所传入的公告id使用gonggaodao的selectByPrimaryKey方法进行查询

        Gonggao gonggao = gonggaodao.selectByPrimaryKey(id);

        // 将查询到的公告保存到request中

        request.setAttribute("gonggao", gonggao);


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

