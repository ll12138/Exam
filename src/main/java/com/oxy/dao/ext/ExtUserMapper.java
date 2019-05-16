package com.oxy.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.oxy.dto.user.PageUserDTO;
import com.oxy.model.User;

@Mapper
public interface ExtUserMapper {
	List<PageUserDTO> listPage(@Param("param") PageUserDTO pageUserDTO);

	void addUserList(List<User> list);

	void updateClass(@Param("classid")Integer classid);
}
