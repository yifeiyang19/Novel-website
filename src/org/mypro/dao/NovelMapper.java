package org.mypro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Novel;
import org.mypro.entity.NovelExample;

public interface NovelMapper {
    long countByExample(NovelExample example);

    int deleteByExample(NovelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Novel record);

    int insertSelective(Novel record);

    List<Novel> selectByExample(NovelExample example);

    Novel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Novel record, @Param("example") NovelExample example);

    int updateByExample(@Param("record") Novel record, @Param("example") NovelExample example);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKey(Novel record);
}