package com.oxy.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oxy.dto.itemBank.PageSelectDTO;
import com.oxy.model.Singleselect;
@Mapper
public interface ExtSingleselectMapper {
	List<PageSelectDTO> listPage(@Param("param") PageSelectDTO pageSelectDTO);

	void addSingleList(@Param("lists")List<Singleselect> singleList, @Param("user")String userCode);
}
