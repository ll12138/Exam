package com.oxy.dao.ext;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * @author lil1
 * @date 2019年4月15日 下午6:33:29
 * @Description 
 */
public interface ExtClassMapper {

	List<LinkedHashMap<String, Object>> getClassList(@Param("name")String name);


}
