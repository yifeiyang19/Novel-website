package org.mypro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Postspinglun;
import org.mypro.entity.PostspinglunExample;

public interface PostspinglunMapper {
    long countByExample(PostspinglunExample example);

    int deleteByExample(PostspinglunExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Postspinglun record);

    int insertSelective(Postspinglun record);

    List<Postspinglun> selectByExample(PostspinglunExample example);

    Postspinglun selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Postspinglun record, @Param("example") PostspinglunExample example);

    int updateByExample(@Param("record") Postspinglun record, @Param("example") PostspinglunExample example);

    int updateByPrimaryKeySelective(Postspinglun record);

    int updateByPrimaryKey(Postspinglun record);
}