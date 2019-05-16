package com.oxy.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.classes.AddClassVO;
import com.oxy.vo.classes.UpdateClassVO;

/**
 * @author lil1
 * @date 2019年4月15日 下午6:16:20
 * @Description 
 */
public interface ClassService {

	void deleteClass(BaseDeleteVO vo);

	void addClass(AddClassVO vo);

	void UpdateClass(UpdateClassVO vo);

	List<LinkedHashMap<String, Object>> getClassList(String name, int pageNum, int pageSize);

}
