package com.oxy.dao;

import com.oxy.model.Examination;
import com.oxy.model.ExaminationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExaminationMapper {
    long countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    int deleteByPrimaryKey(Integer examid);

    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectByExample(ExaminationExample example);

    Examination selectByPrimaryKey(Integer examid);

    int updateByExampleSelective(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByPrimaryKeySelective(Examination record);

    int updateByPrimaryKey(Examination record);
}