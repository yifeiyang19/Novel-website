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

import org.mypro.dao.NovelMapper;

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

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class NovelService implements NovelServiceImp {


    private static final Log logger = LogFactory.getLog(NovelService.class);

    @Autowired
    private NovelMapper noveldao;
    @Autowired
    private CollectMapper collectdao;
    @Autowired
    private LikesMapper likesdao;
    @Autowired
    private UserMapper userdao;

// 定义categorydao参数  


    @Autowired
    private CategoryMapper categorydao; // 定义NovelpinglunMapper


    @Autowired
    private NovelpinglunMapper novelpinglundao;


    public Map collectjson(HttpServletRequest request, HttpSession session, Collect collect) {
        Map result = new HashMap();

        CollectExample example = new CollectExample();

        CollectExample.Criteria criteria = example.createCriteria();

        criteria.andNovelidEqualTo(collect.getNovelid());

        criteria.andUseridEqualTo(collect.getUserid());

        Long collectnum = collectdao.countByExample(example);


        int type = Integer.parseInt(request.getParameter("type"));

        //新增收藏
        if (type == 1) {

            Novel novel = noveldao.selectByPrimaryKey(collect.getNovelid());
            User user = userdao.selectByPrimaryKey(collect.getUserid());

            collect.setNovel(novel.getName());
            collectdao.insert(collect);

            collectnum = Long.valueOf(1);

            result.put("message", "收藏成功");
        }

        //删除收藏
        if (type == 2) {

            collectdao.deleteByExample(example);

            collectnum = Long.valueOf(0);

            result.put("message", "取消收藏成功");
        }

        result.put("collectnum", collectnum);

        return result;
    }

    public Map likesjson(HttpServletRequest request, HttpSession session, Likes likes) {
        Map result = new HashMap();

        LikesExample example = new LikesExample();

        LikesExample.Criteria criteria = example.createCriteria();

        criteria.andNovelidEqualTo(likes.getNovelid());

        criteria.andUseridEqualTo(likes.getUserid());

        Long likesnum = likesdao.countByExample(example);


        int type = Integer.parseInt(request.getParameter("type"));

        //新增点赞
        if (type == 1) {

            Novel novel = noveldao.selectByPrimaryKey(likes.getNovelid());
            User user = userdao.selectByPrimaryKey(likes.getUserid());

            likes.setNovel(novel.getName());
            likesdao.insert(likes);

            likesnum = Long.valueOf(1);

            result.put("message", "点赞成功");
        }

        //删除点赞
        if (type == 2) {

            likesdao.deleteByExample(example);

            likesnum = Long.valueOf(0);

            result.put("message", "取消点赞成功");
        }

        result.put("likesnum", likesnum);

        return result;
    }


    //定义方法addnovel,响应控制层addnovel请求

    public void addnovel(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addnovel

        logger.debug("NovelService.addnovel ......");

// 定义 example1为 CategoryExample的实例

        CategoryExample example1 = new CategoryExample();

// 定义categoryall的List使用 categorydao的selectByExample方法查询所有小说数据

        List categoryall = categorydao.selectByExample(example1);

        // 将上面查询到的小说数据保存到request中，返回页面

        request.setAttribute("categoryall", categoryall);


    }


    //定义addnovelact方法

    public void addnovelact(HttpServletRequest request, HttpSession session, Novel novel, MultipartFile picfile, MultipartFile uploadsfile) throws IOException {

        //输出当前方法日志，表示正在执行NovelService.addnovelact方法

        logger.debug("NovelService.addnovelact ......");

// 判断封面文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的封面文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将novel的封面设置为pic的值  

            novel.setPic(pic);

        }


// 判断上传文件是否为空  

        if (!uploadsfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的上传文件上传到服务器，将返回的文件名保存到uploads参数中  

            String uploads = uploadUtile(uploadsfile, request);

// 将novel的上传设置为uploads的值  

            novel.setUploads(uploads);

        }


        //使用noveldao的insert方法将小说添加到数据库中

        noveldao.insert(novel);


        //将添加小说信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加小说成功");

    }


    //定义novelmanage方法响应页面请求

    public void novelmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行NovelService.novelmanage

        logger.debug("NovelService.novelmanage ......");


        //实例化NovelExample类为example

        NovelExample example = new NovelExample();


        //使用  noveldao.selectByExample(example)方法获取所有的小说数据

        List novelall = noveldao.selectByExample(example);


        //将所有的小说数据保存到request中的novelall参数里

        request.setAttribute("novelall", novelall);


    }


    // 定义 novelview方法

    public void novelview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行NovelService.novelview方法

        logger.debug("NovelService.novelview ......");


        // 实例化NovelExample类

        NovelExample example = new NovelExample();


        // 使用noveldao的selectByExample方法查询小说信息

        List novelall = noveldao.selectByExample(example);


        // 将查询的novelall保存到request中，记录为参数novelall

        request.setAttribute("novelall", novelall);


    }


    // 定义 updatenovel方法

    public void updatenovel(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志NovelController.updatenovel，表示正在执行该方法

        logger.debug("NovelController.updatenovel ......");


        // 定义小说为biaoming，使用 noveldao的selectByPrimaryKey方法通过id查询数据

        Novel novel = noveldao.selectByPrimaryKey(id);


// 定义 example1为 CategoryExample的实例

        CategoryExample example1 = new CategoryExample();

// 定义categoryall的List使用 categorydao的selectByExample方法查询所有小说数据

        List categoryall = categorydao.selectByExample(example1);

        // 将上面查询到的小说数据保存到request中，返回页面

        request.setAttribute("categoryall", categoryall);


        // 将查询的小说保存到request中

        request.setAttribute("novel", novel);


    }


    // 定义updatenovelact处理小说修改

    public void updatenovelact(HttpServletRequest request, Novel novel, HttpSession session, MultipartFile picfile, MultipartFile uploadsfile) throws IOException {

        // 输出日志，表示正在执行当前方法NovelController.updatenovelact

        logger.debug("NovelController.updatenovelact ......");

// 判断封面文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的封面文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将novel的封面设置为pic的值  

            novel.setPic(pic);

        }


// 判断上传文件是否为空  

        if (!uploadsfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的上传文件上传到服务器，将返回的文件名保存到uploads参数中  

            String uploads = uploadUtile(uploadsfile, request);

// 将novel的上传设置为uploads的值  

            novel.setUploads(uploads);

        }


        // 执行noveldao的updateByPrimaryKeySelective方法，将传入的小说数据同步到数据库中

        noveldao.updateByPrimaryKeySelective(novel);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改小说信息成功");


    }


    // 定义deletenovel,处理删除小说

    public void deletenovel(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NovelService.deletenovel方法

        logger.debug("NovelService.deletenovel ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化小说example
            NovelExample example = new NovelExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化小说criteria
            NovelExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的小说id信息
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
            //调用小说的dao类，执行批量删除操作
            noveldao.deleteByExample(example);
        } else {
            // 根据id调用noveldao的deleteByPrimaryKey方法，删除小说


            noveldao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除小说成功");


    }


    // 定义searchnovel方法，处理搜索操作

    public void searchnovel(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行NovelService.searchnovel

        logger.debug("NovelService.searchnovel ......");


        // 实例化 NovelExample

        NovelExample example = new NovelExample();

        // 实例化 NovelExample的Criteria内部类

        NovelExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andNameLike("%" + search + "%");

        }

        // 查询小说结果

        List novelall = noveldao.selectByExample(example);

        // 将查询到的小说 保存到request中进行保存

        request.setAttribute("novelall", novelall);

    }


    // 定义NovelpinglunMapper

    public void noveldetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为NovelController.noveldetails

        logger.debug("NovelController.noveldetails ......");


        // 传入页面所传入的小说id使用noveldao的selectByPrimaryKey方法进行查询

        Novel novel = noveldao.selectByPrimaryKey(id);

        // 将查询到的小说保存到request中

        request.setAttribute("novel", novel);


        // 实例化NovelpinglunExample

        NovelpinglunExample example = new NovelpinglunExample();
        NovelpinglunExample.Criteria criteria = example.createCriteria();
        criteria.andNovelidEqualTo(id); // 使用novelpinglundao的selectByExample方法查询novelpinglunall

        List novelpinglunall = novelpinglundao.selectByExample(example);

        // 将novelpinglunall保存到request中

        request.setAttribute("novelpinglunall", novelpinglunall);

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

