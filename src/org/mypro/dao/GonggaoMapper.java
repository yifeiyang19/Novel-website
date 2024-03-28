package org.mypro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Gonggao;
import org.mypro.entity.GonggaoExample;

public interface GonggaoMapper {
    long countByExample(GonggaoExample example);

    int deleteByExample(GonggaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gonggao record);

    int insertSelective(Gonggao record);

    List<Gonggao> selectByExample(GonggaoExample example);

    Gonggao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gonggao record, @Param("example") GonggaoExample example);

    int updateByExample(@Param("record") Gonggao record, @Param("example") GonggaoExample example);

    int updateByPrimaryKeySelective(Gonggao record);

    int updateByPrimaryKey(Gonggao record);
}