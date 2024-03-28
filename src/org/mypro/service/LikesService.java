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

import org.mypro.dao.LikesMapper;

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

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class LikesService implements LikesServiceImp {


    private static final Log logger = LogFactory.getLog(LikesService.class);

    @Autowired
    private LikesMapper likesdao;
// 定义noveldao参数  


    @Autowired
    private NovelMapper noveldao;
// 定义userdao参数  


    @Autowired
    private UserMapper userdao;


    //定义方法addlikes,响应控制层addlikes请求

    public void addlikes(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addlikes

        logger.debug("LikesService.addlikes ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有点赞数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有点赞数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    //定义useraddlikes方法，在点赞控制层中调用

    public void useraddlikes(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行LikesService.useraddlikes方法

        logger.debug("LikesService.useraddlikes ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有点赞数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有点赞数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    // 定义userupdatelikes方法

    public void userupdatelikes(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志LikesService.userupdatelikes

        logger.debug("LikesService.userupdatelikes ......");


        // 实例化点赞,使用likesdao的selectByPrimaryKey方法通过id查询点赞

        Likes likes = likesdao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有点赞数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有点赞数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询出的点赞信息保存到request中

        request.setAttribute("likes", likes);


    }


    //定义userlikesmanage方法

    public void userlikesmanage(HttpServletRequest request, HttpSession session) {

        //输出日志 ，表示当前正在执行方法为LikesService.userlikesmanage

        logger.debug("LikesService.userlikesmanage ......");


        //定义实体，从session中获取当前用户，赋值给

        User user = (User) session.getAttribute("userinfo");


        //实例化点赞类为example

        LikesExample example = new LikesExample();


        //实例化点赞Example类的criteria

        LikesExample.Criteria criteria = example.createCriteria();

        // 通过 criteria设置查询条件Userid为当前用户id

        criteria.andUseridEqualTo(user.getId());


        // 使用 likesdao.selectByExample(example)方法查询所有userid为当前用户id的点赞

        List likesall = likesdao.selectByExample(example);

        // 将查询的点赞数据保存到request中的 likesall参数中


        request.setAttribute("likesall", likesall);
    }


    //定义useraddlikesact，响应页面添加请求

    public void useraddlikesact(HttpServletRequest request, HttpSession session, Likes likes) throws IOException {

        //输出日志，表示当前正在执行方法为LikesService.useraddlikesact

        logger.debug("LikesService.useraddlikesact ......");

        //使用mybatis逆向工程所提供的insert方法添加点赞数据到数据库中

        likesdao.insert(likes);


        //将添加点赞成功的信息保存到request中，在页面中进行初始化

        request.setAttribute("message", "添加点赞成功");

    }


    //定义addlikesact方法

    public void addlikesact(HttpServletRequest request, HttpSession session, Likes likes) throws IOException {

        //输出当前方法日志，表示正在执行LikesService.addlikesact方法

        logger.debug("LikesService.addlikesact ......");

        //使用likesdao的insert方法将点赞添加到数据库中

        likesdao.insert(likes);


        //将添加点赞信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加点赞成功");

    }


    //定义likesmanage方法响应页面请求

    public void likesmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行LikesService.likesmanage

        logger.debug("LikesService.likesmanage ......");


        //实例化LikesExample类为example

        LikesExample example = new LikesExample();


        //使用  likesdao.selectByExample(example)方法获取所有的点赞数据

        List likesall = likesdao.selectByExample(example);


        //将所有的点赞数据保存到request中的likesall参数里

        request.setAttribute("likesall", likesall);


    }


    // 定义 likesview方法

    public void likesview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行LikesService.likesview方法

        logger.debug("LikesService.likesview ......");


        // 实例化LikesExample类

        LikesExample example = new LikesExample();


        // 使用likesdao的selectByExample方法查询点赞信息

        List likesall = likesdao.selectByExample(example);


        // 将查询的likesall保存到request中，记录为参数likesall

        request.setAttribute("likesall", likesall);


    }


    // 定义 updatelikes方法

    public void updatelikes(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志LikesController.updatelikes，表示正在执行该方法

        logger.debug("LikesController.updatelikes ......");


        // 定义点赞为biaoming，使用 likesdao的selectByPrimaryKey方法通过id查询数据

        Likes likes = likesdao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有点赞数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有点赞数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的点赞数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询的点赞保存到request中

        request.setAttribute("likes", likes);


    }


    // 定义updatelikesact处理点赞修改

    public void updatelikesact(HttpServletRequest request, Likes likes, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法LikesController.updatelikesact

        logger.debug("LikesController.updatelikesact ......");

        // 执行likesdao的updateByPrimaryKeySelective方法，将传入的点赞数据同步到数据库中

        likesdao.updateByPrimaryKeySelective(likes);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改点赞信息成功");


    }


    // 定义userupdatelikesact方法

    public void userupdatelikesact(HttpServletRequest request, Likes likes, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("LikesService.userupdatelikesact ......");

        // 调用likesdao的updateByPrimaryKeySelective方法修改传入的likes

        likesdao.updateByPrimaryKeySelective(likes);


        request.setAttribute("message", "修改点赞信息成功");


    }


    // 定义deletelikes,处理删除点赞

    public void deletelikes(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行LikesService.deletelikes方法

        logger.debug("LikesService.deletelikes ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化点赞example
            LikesExample example = new LikesExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化点赞criteria
            LikesExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的点赞id信息
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
            //调用点赞的dao类，执行批量删除操作
            likesdao.deleteByExample(example);
        } else {
            // 根据id调用likesdao的deleteByPrimaryKey方法，删除点赞


            likesdao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除点赞成功");


    }


    // 定义userdeletelikes方法

    public void userdeletelikes(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行LikesController.userdeletelikes方法

        logger.debug("LikesController.userdeletelikes ......");


        // 调用likesdao的deleteByPrimaryKey方法，传入id。删除id所对应的点赞

        likesdao.deleteByPrimaryKey(id);

        // 将删除点赞成功信息保存到request中


        request.setAttribute("message", "删除点赞成功");

    }


    // 定义searchlikes方法，处理搜索操作

    public void searchlikes(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行LikesService.searchlikes

        logger.debug("LikesService.searchlikes ......");


        // 实例化 LikesExample

        LikesExample example = new LikesExample();

        // 实例化 LikesExample的Criteria内部类

        LikesExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andNovelLike("%" + search + "%");

        }

        // 查询点赞结果

        List likesall = likesdao.selectByExample(example);

        // 将查询到的点赞 保存到request中进行保存

        request.setAttribute("likesall", likesall);

    }


    // 定义LikespinglunMapper

    public void likesdetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为LikesController.likesdetails

        logger.debug("LikesController.likesdetails ......");


        // 传入页面所传入的点赞id使用likesdao的selectByPrimaryKey方法进行查询

        Likes likes = likesdao.selectByPrimaryKey(id);

        // 将查询到的点赞保存到request中

        request.setAttribute("likes", likes);


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

