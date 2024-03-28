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

import org.mypro.dao.NovelpinglunMapper;

import org.mypro.entity.Novelpinglun;

import org.mypro.entity.NovelpinglunExample;

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

public class NovelpinglunService implements NovelpinglunServiceImp {


    private static final Log logger = LogFactory.getLog(NovelpinglunService.class);

    @Autowired
    private NovelpinglunMapper novelpinglundao;
// 定义noveldao参数  


    @Autowired
    private NovelMapper noveldao;
// 定义userdao参数  


    @Autowired
    private UserMapper userdao;


    //定义方法addnovelpinglun,响应控制层addnovelpinglun请求

    public void addnovelpinglun(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addnovelpinglun

        logger.debug("NovelpinglunService.addnovelpinglun ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有小说评论数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有小说评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    //定义useraddnovelpinglun方法，在小说评论控制层中调用

    public void useraddnovelpinglun(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行NovelpinglunService.useraddnovelpinglun方法

        logger.debug("NovelpinglunService.useraddnovelpinglun ......");

// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有小说评论数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有小说评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


    }


    // 定义userupdatenovelpinglun方法

    public void userupdatenovelpinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志NovelpinglunService.userupdatenovelpinglun

        logger.debug("NovelpinglunService.userupdatenovelpinglun ......");


        // 实例化小说评论,使用novelpinglundao的selectByPrimaryKey方法通过id查询小说评论

        Novelpinglun novelpinglun = novelpinglundao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有小说评论数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有小说评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询出的小说评论信息保存到request中

        request.setAttribute("novelpinglun", novelpinglun);


    }


    // 定义usernovelpinglunmanage方法

    public void usernovelpinglunmanage(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行方法NovelpinglunService.usernovelpinglunmanage

        logger.debug("NovelpinglunService.usernovelpinglunmanage ......");


        // 实例化为user,并从session中取出当前登录用户赋值，

        User user = (User) session.getAttribute("userinfo");


        // 实例化NovelpinglunExample为example

        NovelpinglunExample example = new NovelpinglunExample();


        // 实例化NovelpinglunExample的Criteria内部类为criteria

        NovelpinglunExample.Criteria criteria = example.createCriteria();

        // 定义查询条件的pinglunrenid为当前登录用户id

        criteria.andPinglunrenidEqualTo(user.getId());


        // 查询当前用户所有的 小说评论，保存到novelpinglunall中

        List novelpinglunall = novelpinglundao.selectByExample(example);


        // 将查询出的 小说评论保存到request中的novelpinglunall中

        request.setAttribute("novelpinglunall", novelpinglunall);

    }


    //定义useraddnovelpinglunact，响应页面添加请求

    public void useraddnovelpinglunact(HttpServletRequest request, HttpSession session, Novelpinglun novelpinglun) throws IOException {

        //输出日志，表示当前正在执行方法为NovelpinglunService.useraddnovelpinglunact

        logger.debug("NovelpinglunService.useraddnovelpinglunact ......");

        //使用mybatis逆向工程所提供的insert方法添加小说评论数据到数据库中

        novelpinglundao.insert(novelpinglun);


        //将添加小说评论成功的信息保存到request中，在页面中进行初始化

        request.setAttribute("message", "添加小说评论成功");

    }


    //定义addnovelpinglunact方法

    public void addnovelpinglunact(HttpServletRequest request, HttpSession session, Novelpinglun novelpinglun) throws IOException {

        //输出当前方法日志，表示正在执行NovelpinglunService.addnovelpinglunact方法

        logger.debug("NovelpinglunService.addnovelpinglunact ......");

        //使用novelpinglundao的insert方法将小说评论添加到数据库中

        novelpinglundao.insert(novelpinglun);


        //将添加小说评论信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加小说评论成功");

    }


    //定义novelpinglunmanage方法响应页面请求

    public void novelpinglunmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行NovelpinglunService.novelpinglunmanage

        logger.debug("NovelpinglunService.novelpinglunmanage ......");


        //实例化NovelpinglunExample类为example

        NovelpinglunExample example = new NovelpinglunExample();


        //使用  novelpinglundao.selectByExample(example)方法获取所有的小说评论数据

        List novelpinglunall = novelpinglundao.selectByExample(example);


        //将所有的小说评论数据保存到request中的novelpinglunall参数里

        request.setAttribute("novelpinglunall", novelpinglunall);


    }


    // 定义 novelpinglunview方法

    public void novelpinglunview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行NovelpinglunService.novelpinglunview方法

        logger.debug("NovelpinglunService.novelpinglunview ......");


        // 实例化NovelpinglunExample类

        NovelpinglunExample example = new NovelpinglunExample();


        // 使用novelpinglundao的selectByExample方法查询小说评论信息

        List novelpinglunall = novelpinglundao.selectByExample(example);


        // 将查询的novelpinglunall保存到request中，记录为参数novelpinglunall

        request.setAttribute("novelpinglunall", novelpinglunall);


    }


    // 定义 updatenovelpinglun方法

    public void updatenovelpinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志NovelpinglunController.updatenovelpinglun，表示正在执行该方法

        logger.debug("NovelpinglunController.updatenovelpinglun ......");


        // 定义小说评论为biaoming，使用 novelpinglundao的selectByPrimaryKey方法通过id查询数据

        Novelpinglun novelpinglun = novelpinglundao.selectByPrimaryKey(id);


// 定义 example1为 NovelExample的实例

        NovelExample example1 = new NovelExample();

// 定义novelall的List使用 noveldao的selectByExample方法查询所有小说评论数据

        List novelall = noveldao.selectByExample(example1);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("novelall", novelall);

// 定义 example2为 UserExample的实例

        UserExample example2 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有小说评论数据

        List userall = userdao.selectByExample(example2);

        // 将上面查询到的小说评论数据保存到request中，返回页面

        request.setAttribute("userall", userall);


        // 将查询的小说评论保存到request中

        request.setAttribute("novelpinglun", novelpinglun);


    }


    // 定义updatenovelpinglunact处理小说评论修改

    public void updatenovelpinglunact(HttpServletRequest request, Novelpinglun novelpinglun, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法NovelpinglunController.updatenovelpinglunact

        logger.debug("NovelpinglunController.updatenovelpinglunact ......");

        // 执行novelpinglundao的updateByPrimaryKeySelective方法，将传入的小说评论数据同步到数据库中

        novelpinglundao.updateByPrimaryKeySelective(novelpinglun);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改小说评论信息成功");


    }


    // 定义userupdatenovelpinglunact方法

    public void userupdatenovelpinglunact(HttpServletRequest request, Novelpinglun novelpinglun, HttpSession session) throws IOException {

        // 当执行此方法时，输出此日志

        logger.debug("NovelpinglunService.userupdatenovelpinglunact ......");

        // 调用novelpinglundao的updateByPrimaryKeySelective方法修改传入的novelpinglun

        novelpinglundao.updateByPrimaryKeySelective(novelpinglun);


        request.setAttribute("message", "修改小说评论信息成功");


    }


    // 定义deletenovelpinglun,处理删除小说评论

    public void deletenovelpinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelpinglunService.deletenovelpinglun方法

        logger.debug("NovelpinglunService.deletenovelpinglun ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化小说评论example
            NovelpinglunExample example = new NovelpinglunExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化小说评论criteria
            NovelpinglunExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的小说评论id信息
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
            //调用小说评论的dao类，执行批量删除操作
            novelpinglundao.deleteByExample(example);
        } else {
            // 根据id调用novelpinglundao的deleteByPrimaryKey方法，删除小说评论


            novelpinglundao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除小说评论成功");


    }


    // 定义userdeletenovelpinglun方法

    public void userdeletenovelpinglun(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelpinglunController.userdeletenovelpinglun方法

        logger.debug("NovelpinglunController.userdeletenovelpinglun ......");


        // 调用novelpinglundao的deleteByPrimaryKey方法，传入id。删除id所对应的小说评论

        novelpinglundao.deleteByPrimaryKey(id);

        // 将删除小说评论成功信息保存到request中


        request.setAttribute("message", "删除小说评论成功");

    }


    // 定义searchnovelpinglun方法，处理搜索操作

    public void searchnovelpinglun(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行NovelpinglunService.searchnovelpinglun

        logger.debug("NovelpinglunService.searchnovelpinglun ......");


        // 实例化 NovelpinglunExample

        NovelpinglunExample example = new NovelpinglunExample();

        // 实例化 NovelpinglunExample的Criteria内部类

        NovelpinglunExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andNovelLike("%" + search + "%");

        }

        // 查询小说评论结果

        List novelpinglunall = novelpinglundao.selectByExample(example);

        // 将查询到的小说评论 保存到request中进行保存

        request.setAttribute("novelpinglunall", novelpinglunall);

    }


    // 定义NovelpinglunpinglunMapper

    public void novelpinglundetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为NovelpinglunController.novelpinglundetails

        logger.debug("NovelpinglunController.novelpinglundetails ......");


        // 传入页面所传入的小说评论id使用novelpinglundao的selectByPrimaryKey方法进行查询

        Novelpinglun novelpinglun = novelpinglundao.selectByPrimaryKey(id);

        // 将查询到的小说评论保存到request中

        request.setAttribute("novelpinglun", novelpinglun);


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

