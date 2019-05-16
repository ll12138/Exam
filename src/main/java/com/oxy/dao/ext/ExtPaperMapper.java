package com.oxy.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oxy.dto.paper.PagePaperDTO;
@Mapper
public interface ExtPaperMapper {
	List<PagePaperDTO> listPage(@Param("param") PagePaperDTO pagePaperDTO);
}
