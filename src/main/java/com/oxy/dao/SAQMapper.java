package com.oxy.dao;

import com.oxy.model.SAQ;
import com.oxy.model.SAQExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SAQMapper {
    long countByExample(SAQExample example);

    int deleteByExample(SAQExample example);

    int deleteByPrimaryKey(Integer saqid);

    int insert(SAQ record);

    int insertSelective(SAQ record);

    List<SAQ> selectByExample(SAQExample example);

    SAQ selectByPrimaryKey(Integer saqid);

    int updateByExampleSelective(@Param("record") SAQ record, @Param("example") SAQExample example);

    int updateByExample(@Param("record") SAQ record, @Param("example") SAQExample example);

    int updateByPrimaryKeySelective(SAQ record);

    int updateByPrimaryKey(SAQ record);
}