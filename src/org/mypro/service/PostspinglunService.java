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

import org.mypro.dao.PostspinglunMapper;

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

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class PostspinglunService implements PostspinglunServiceImp {


    private static final Log logger = LogFactory.getLog(PostspinglunService.class);

    @Autowired
    private PostspinglunMapper postspinglundao;
// 定义postsdao参数  


    @Autowired
    private PostsMapper postsdao;
// 定义userdao参数  


    @Autowired
    private UserMapper userdao;


    //定义方法addpostspinglun,响应控制层addpostspinglun请求

    public void addpostspinglun(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addpostspinglun

        logger.debug("PostspinglunService.addpostspinglun ......");

// 定义 example1为 PostsExample的实例

        PostsExample example1 = new PostsExample();

// 定义postsall的List使用 postsdao的selectByExample方法查询所有帖子评论数据

        List postsall = postsdao.selectByExample(example1);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("postsall", postsall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有帖子评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    //定义useraddpostspinglun方法，在帖子评论控制层中调用

    public void useraddpostspinglun(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行PostspinglunService.useraddpostspinglun方法

        logger.debug("PostspinglunService.useraddpostspinglun ......");

// 定义 example1为 PostsExample的实例

        PostsExample example1 = new PostsExample();

// 定义postsall的List使用 postsdao的selectByExample方法查询所有帖子评论数据

        List postsall = postsdao.selectByExample(example1);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("postsall", postsall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有帖子评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    // 定义userupdatepostspinglun方法

    public void userupdatepostspinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志PostspinglunService.userupdatepostspinglun

        logger.debug("PostspinglunService.userupdatepostspinglun ......");


        // 实例化帖子评论,使用postspinglundao的selectByPrimaryKey方法通过id查询帖子评论

        Postspinglun postspinglun = postspinglundao.selectByPrimaryKey(id);


// 定义 example1为 PostsExample的实例

        PostsExample example1 = new PostsExample();

// 定义postsall的List使用 postsdao的selectByExample方法查询所有帖子评论数据

        List postsall = postsdao.selectByExample(example1);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("postsall", postsall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有帖子评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询出的帖子评论信息保存到request中

        request.setAttribute("postspinglun", postspinglun);


    }


    // 定义userpostspinglunmanage方法

    public void userpostspinglunmanage(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行方法PostspinglunService.userpostspinglunmanage

        logger.debug("PostspinglunService.userpostspinglunmanage ......");


        // 实例化为user,并从session中取出当前登录用户赋值，

        User user = (User) session.getAttribute("userinfo");


        // 实例化PostspinglunExample为example

        PostspinglunExample example = new PostspinglunExample();


        // 实例化PostspinglunExample的Criteria内部类为criteria

        PostspinglunExample.Criteria criteria = example.createCriteria();

        // 定义查询条件的pinglunrenid为当前登录用户id

        criteria.andPinglunrenidEqualTo(user.getId());


        // 查询当前用户所有的 帖子评论，保存到postspinglunall中

        List postspinglunall = postspinglundao.selectByExample(example);


        // 将查询出的 帖子评论保存到request中的postspinglunall中

        request.setAttribute("postspinglunall", postspinglunall);

    }


    //定义useraddpostspinglunact，响应页面添加请求

    public void useraddpostspinglunact(HttpServletRequest request, HttpSession session, Postspinglun postspinglun) throws IOException {

        //输出日志，表示当前正在执行方法为PostspinglunService.useraddpostspinglunact

        logger.debug("PostspinglunService.useraddpostspinglunact ......");

        //使用mybatis逆向工程所提供的insert方法添加帖子评论数据到数据库中

        postspinglundao.insert(postspinglun);


        //将添加帖子评论成功的信息保存到request中，在页面中进行初始化

        request.setAttribute("message", "添加帖子评论成功");

    }


    //定义addpostspinglunact方法

    public void addpostspinglunact(HttpServletRequest request, HttpSession session, Postspinglun postspinglun) throws IOException {

        //输出当前方法日志，表示正在执行PostspinglunService.addpostspinglunact方法

        logger.debug("PostspinglunService.addpostspinglunact ......");

        //使用postspinglundao的insert方法将帖子评论添加到数据库中

        postspinglundao.insert(postspinglun);


        //将添加帖子评论信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加帖子评论成功");

    }


    //定义postspinglunmanage方法响应页面请求

    public void postspinglunmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行PostspinglunService.postspinglunmanage

        logger.debug("PostspinglunService.postspinglunmanage ......");


        //实例化PostspinglunExample类为example

        PostspinglunExample example = new PostspinglunExample();


        //使用  postspinglundao.selectByExample(example)方法获取所有的帖子评论数据

        List postspinglunall = postspinglundao.selectByExample(example);


        //将所有的帖子评论数据保存到request中的postspinglunall参数里

        request.setAttribute("postspinglunall", postspinglunall);


    }


    // 定义 postspinglunview方法

    public void postspinglunview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行PostspinglunService.postspinglunview方法

        logger.debug("PostspinglunService.postspinglunview ......");


        // 实例化PostspinglunExample类

        PostspinglunExample example = new PostspinglunExample();


        // 使用postspinglundao的selectByExample方法查询帖子评论信息

        List postspinglunall = postspinglundao.selectByExample(example);


        // 将查询的postspinglunall保存到request中，记录为参数postspinglunall

        request.setAttribute("postspinglunall", postspinglunall);


    }


    // 定义 updatepostspinglun方法

    public void updatepostspinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志PostspinglunController.updatepostspinglun，表示正在执行该方法

        logger.debug("PostspinglunController.updatepostspinglun ......");


        // 定义帖子评论为biaoming，使用 postspinglundao的selectByPrimaryKey方法通过id查询数据

        Postspinglun postspinglun = postspinglundao.selectByPrimaryKey(id);


// 定义 example1为 PostsExample的实例

        PostsExample example1 = new PostsExample();

// 定义postsall的List使用 postsdao的selectByExample方法查询所有帖子评论数据

        List postsall = postsdao.selectByExample(example1);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("postsall", postsall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有帖子评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的帖子评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询的帖子评论保存到request中

        request.setAttribute("postspinglun", postspinglun);


    }


    // 定义updatepostspinglunact处理帖子评论修改

    public void updatepostspinglunact(HttpServletRequest request, Postspinglun postspinglun, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法PostspinglunController.updatepostspinglunact

        logger.debug("PostspinglunController.updatepostspinglunact ......");

        // 执行postspinglundao的updateByPrimaryKeySelective方法，将传入的帖子评论数据同步到数据库中

        postspinglundao.updateByPrimaryKeySelective(postspinglun);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改帖子评论信息成功");


    }


    // 定义userupdatepostspinglunact方法

    public void userupdatepostspinglunact(HttpServletRequest request, Postspinglun postspinglun, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("PostspinglunService.userupdatepostspinglunact ......");

        // 调用postspinglundao的updateByPrimaryKeySelective方法修改传入的postspinglun

        postspinglundao.updateByPrimaryKeySelective(postspinglun);


        request.setAttribute("message", "修改帖子评论信息成功");


    }


    // 定义deletepostspinglun,处理删除帖子评论

    public void deletepostspinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostspinglunService.deletepostspinglun方法

        logger.debug("PostspinglunService.deletepostspinglun ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化帖子评论example
            PostspinglunExample example = new PostspinglunExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化帖子评论criteria
            PostspinglunExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的帖子评论id信息
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
            //调用帖子评论的dao类，执行批量删除操作
            postspinglundao.deleteByExample(example);
        } else {
            // 根据id调用postspinglundao的deleteByPrimaryKey方法，删除帖子评论


            postspinglundao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除帖子评论成功");


    }


    // 定义userdeletepostspinglun方法

    public void userdeletepostspinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行PostspinglunController.userdeletepostspinglun方法

        logger.debug("PostspinglunController.userdeletepostspinglun ......");


        // 调用postspinglundao的deleteByPrimaryKey方法，传入id。删除id所对应的帖子评论

        postspinglundao.deleteByPrimaryKey(id);

        // 将删除帖子评论成功信息保存到request中


        request.setAttribute("message", "删除帖子评论成功");

    }


    // 定义searchpostspinglun方法，处理搜索操作

    public void searchpostspinglun(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行PostspinglunService.searchpostspinglun

        logger.debug("PostspinglunService.searchpostspinglun ......");


        // 实例化 PostspinglunExample

        PostspinglunExample example = new PostspinglunExample();

        // 实例化 PostspinglunExample的Criteria内部类

        PostspinglunExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andPostsLike("%" + search + "%");

        }

        // 查询帖子评论结果

        List postspinglunall = postspinglundao.selectByExample(example);

        // 将查询到的帖子评论 保存到request中进行保存

        request.setAttribute("postspinglunall", postspinglunall);

    }


    // 定义PostspinglunpinglunMapper

    public void postspinglundetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为PostspinglunController.postspinglundetails

        logger.debug("PostspinglunController.postspinglundetails ......");


        // 传入页面所传入的帖子评论id使用postspinglundao的selectByPrimaryKey方法进行查询

        Postspinglun postspinglun = postspinglundao.selectByPrimaryKey(id);

        // 将查询到的帖子评论保存到request中

        request.setAttribute("postspinglun", postspinglun);


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

