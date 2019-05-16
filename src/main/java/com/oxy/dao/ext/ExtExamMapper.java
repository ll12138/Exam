package com.oxy.dao.ext;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oxy.vo.exam.PageExamVO;

/**
 * @author lil1
 * @date 2019年4月16日 下午3:03:49
 * @Description 
 */
public interface ExtExamMapper {

	void callProcedure();

	List<LinkedHashMap<String, Object>> getPage(@Param("vo")PageExamVO vo);

}
