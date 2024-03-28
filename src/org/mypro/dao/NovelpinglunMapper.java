package org.mypro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Novelpinglun;
import org.mypro.entity.NovelpinglunExample;

public interface NovelpinglunMapper {
    long countByExample(NovelpinglunExample example);

    int deleteByExample(NovelpinglunExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Novelpinglun record);

    int insertSelective(Novelpinglun record);

    List<Novelpinglun> selectByExample(NovelpinglunExample example);

    Novelpinglun selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Novelpinglun record, @Param("example") NovelpinglunExample example);

    int updateByExample(@Param("record") Novelpinglun record, @Param("example") NovelpinglunExample example);

    int updateByPrimaryKeySelective(Novelpinglun record);

    int updateByPrimaryKey(Novelpinglun record);
}