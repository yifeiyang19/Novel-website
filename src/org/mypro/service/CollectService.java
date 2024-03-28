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

import org.mypro.dao.CollectMapper;

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

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class CollectService implements CollectServiceImp {


    private static final Log logger = LogFactory.getLog(CollectService.class);

    @Autowired
    private CollectMapper collectdao;
// 定义noveldao参数  


    @Autowired
    private NovelMapper noveldao;
// 定义userdao参数  


    @Autowired
    private UserMapper userdao;


    //定义方法addcollect,响应控制层addcollect请求

    public void addcollect(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addcollect

        logger.debug("CollectService.addcollect ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有收藏数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有收藏数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    //定义useraddcollect方法，在收藏控制层中调用

    public void useraddcollect(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行CollectService.useraddcollect方法

        logger.debug("CollectService.useraddcollect ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有收藏数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有收藏数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    // 定义userupdatecollect方法

    public void userupdatecollect(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志CollectService.userupdatecollect

        logger.debug("CollectService.userupdatecollect ......");


        // 实例化收藏,使用collectdao的selectByPrimaryKey方法通过id查询收藏

        Collect collect = collectdao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有收藏数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有收藏数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询出的收藏信息保存到request中

        request.setAttribute("collect", collect);


    }


    //定义usercollectmanage方法

    public void usercollectmanage(HttpServletRequest request, HttpSession session) {

        //输出日志 ，表示当前正在执行方法为CollectService.usercollectmanage

        logger.debug("CollectService.usercollectmanage ......");


        //定义实体，从session中获取当前用户，赋值给

        User user = (User) session.getAttribute("userinfo");


        //实例化收藏类为example

        CollectExample example = new CollectExample();


        //实例化收藏Example类的criteria

        CollectExample.Criteria criteria = example.createCriteria();

        // 通过 criteria设置查询条件Userid为当前用户id

        criteria.andUseridEqualTo(user.getId());


        // 使用 collectdao.selectByExample(example)方法查询所有userid为当前用户id的收藏

        List collectall = collectdao.selectByExample(example);

        // 将查询的收藏数据保存到request中的 collectall参数中


        request.setAttribute("collectall", collectall);
    }


    //定义useraddcollectact，响应页面添加请求

    public void useraddcollectact(HttpServletRequest request, HttpSession session, Collect collect) throws IOException {

        //输出日志，表示当前正在执行方法为CollectService.useraddcollectact

        logger.debug("CollectService.useraddcollectact ......");

        //使用mybatis逆向工程所提供的insert方法添加收藏数据到数据库中

        collectdao.insert(collect);


        //将添加收藏成功的信息保存到request中，在页面中进行初始化

        request.setAttribute("message", "添加收藏成功");

    }


    //定义addcollectact方法

    public void addcollectact(HttpServletRequest request, HttpSession session, Collect collect) throws IOException {

        //输出当前方法日志，表示正在执行CollectService.addcollectact方法

        logger.debug("CollectService.addcollectact ......");

        //使用collectdao的insert方法将收藏添加到数据库中

        collectdao.insert(collect);


        //将添加收藏信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加收藏成功");

    }


    //定义collectmanage方法响应页面请求

    public void collectmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行CollectService.collectmanage

        logger.debug("CollectService.collectmanage ......");


        //实例化CollectExample类为example

        CollectExample example = new CollectExample();


        //使用  collectdao.selectByExample(example)方法获取所有的收藏数据

        List collectall = collectdao.selectByExample(example);


        //将所有的收藏数据保存到request中的collectall参数里

        request.setAttribute("collectall", collectall);


    }


    // 定义 collectview方法

    public void collectview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行CollectService.collectview方法

        logger.debug("CollectService.collectview ......");


        // 实例化CollectExample类

        CollectExample example = new CollectExample();


        // 使用collectdao的selectByExample方法查询收藏信息

        List collectall = collectdao.selectByExample(example);


        // 将查询的collectall保存到request中，记录为参数collectall

        request.setAttribute("collectall", collectall);


    }


    // 定义 updatecollect方法

    public void updatecollect(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志CollectController.updatecollect，表示正在执行该方法

        logger.debug("CollectController.updatecollect ......");


        // 定义收藏为biaoming，使用 collectdao的selectByPrimaryKey方法通过id查询数据

        Collect collect = collectdao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有收藏数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有收藏数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的收藏数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询的收藏保存到request中

        request.setAttribute("collect", collect);


    }


    // 定义updatecollectact处理收藏修改

    public void updatecollectact(HttpServletRequest request, Collect collect, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法CollectController.updatecollectact

        logger.debug("CollectController.updatecollectact ......");

        // 执行collectdao的updateByPrimaryKeySelective方法，将传入的收藏数据同步到数据库中

        collectdao.updateByPrimaryKeySelective(collect);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改收藏信息成功");


    }


    // 定义userupdatecollectact方法

    public void userupdatecollectact(HttpServletRequest request, Collect collect, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("CollectService.userupdatecollectact ......");

        // 调用collectdao的updateByPrimaryKeySelective方法修改传入的collect

        collectdao.updateByPrimaryKeySelective(collect);


        request.setAttribute("message", "修改收藏信息成功");


    }


    // 定义deletecollect,处理删除收藏

    public void deletecollect(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CollectService.deletecollect方法

        logger.debug("CollectService.deletecollect ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化收藏example
            CollectExample example = new CollectExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化收藏criteria
            CollectExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的收藏id信息
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
            //调用收藏的dao类，执行批量删除操作
            collectdao.deleteByExample(example);
        } else {
            // 根据id调用collectdao的deleteByPrimaryKey方法，删除收藏


            collectdao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除收藏成功");


    }


    // 定义userdeletecollect方法

    public void userdeletecollect(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CollectController.userdeletecollect方法

        logger.debug("CollectController.userdeletecollect ......");


        // 调用collectdao的deleteByPrimaryKey方法，传入id。删除id所对应的收藏

        collectdao.deleteByPrimaryKey(id);

        // 将删除收藏成功信息保存到request中


        request.setAttribute("message", "删除收藏成功");

    }


    // 定义searchcollect方法，处理搜索操作

    public void searchcollect(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行CollectService.searchcollect

        logger.debug("CollectService.searchcollect ......");


        // 实例化 CollectExample

        CollectExample example = new CollectExample();

        // 实例化 CollectExample的Criteria内部类

        CollectExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andNovelLike("%" + search + "%");

        }

        // 查询收藏结果

        List collectall = collectdao.selectByExample(example);

        // 将查询到的收藏 保存到request中进行保存

        request.setAttribute("collectall", collectall);

    }


    // 定义CollectpinglunMapper

    public void collectdetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为CollectController.collectdetails

        logger.debug("CollectController.collectdetails ......");


        // 传入页面所传入的收藏id使用collectdao的selectByPrimaryKey方法进行查询

        Collect collect = collectdao.selectByPrimaryKey(id);

        // 将查询到的收藏保存到request中

        request.setAttribute("collect", collect);


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

