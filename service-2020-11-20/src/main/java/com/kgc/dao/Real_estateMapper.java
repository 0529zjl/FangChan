package com.kgc.dao;

import org.apache.ibatis.annotations.Param;
import pojo.Real_estate;
import pojo.Real_estateExample;

import java.util.List;

public interface Real_estateMapper {
    int countByExample(Real_estateExample example);

    int deleteByExample(Real_estateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Real_estate record);

    int insertSelective(Real_estate record);

    List<Real_estate> selectByExample(Real_estateExample example);

    Real_estate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Real_estate record, @Param("example") Real_estateExample example);

    int updateByExample(@Param("record") Real_estate record, @Param("example") Real_estateExample example);

    int updateByPrimaryKeySelective(Real_estate record);

    int updateByPrimaryKey(Real_estate record);
}