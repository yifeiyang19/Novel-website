package org.mypro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Posts;
import org.mypro.entity.PostsExample;

public interface PostsMapper {
    long countByExample(PostsExample example);

    int deleteByExample(PostsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Posts record);

    int insertSelective(Posts record);

    List<Posts> selectByExample(PostsExample example);

    Posts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Posts record, @Param("example") PostsExample example);

    int updateByExample(@Param("record") Posts record, @Param("example") PostsExample example);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKey(Posts record);
}