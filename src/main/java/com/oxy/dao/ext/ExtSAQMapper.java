package com.oxy.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oxy.dto.itemBank.PageSaqDTO;
import com.oxy.model.SAQ;

@Mapper
public interface ExtSAQMapper {
	List<PageSaqDTO> listPage(@Param("param") PageSaqDTO pageSaqDTO);

	void addSaqList(@Param("lists")List<SAQ> saqList, @Param("user")String user);
}
