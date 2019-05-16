package com.oxy.dao;

import com.oxy.model.Singleselect;
import com.oxy.model.SingleselectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingleselectMapper {
    long countByExample(SingleselectExample example);

    int deleteByExample(SingleselectExample example);

    int deleteByPrimaryKey(Integer questionid);

    int insert(Singleselect record);

    int insertSelective(Singleselect record);

    List<Singleselect> selectByExample(SingleselectExample example);

    Singleselect selectByPrimaryKey(Integer questionid);

    int updateByExampleSelective(@Param("record") Singleselect record, @Param("example") SingleselectExample example);

    int updateByExample(@Param("record") Singleselect record, @Param("example") SingleselectExample example);

    int updateByPrimaryKeySelective(Singleselect record);

    int updateByPrimaryKey(Singleselect record);
}