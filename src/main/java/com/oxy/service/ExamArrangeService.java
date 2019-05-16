package com.oxy.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.exam.AddExamVO;
import com.oxy.vo.exam.PageExamVO;
import com.oxy.vo.exam.UpdateExamVO;

/**
 * @author lil1
 * @date 2019年4月16日 上午11:22:41
 * @Description 
 */
public interface ExamArrangeService {

	void addExam(AddExamVO vo);

	void updateExam(UpdateExamVO vo);

	void deleteExam(BaseDeleteVO vo);

	List<LinkedHashMap<String, Object>> getPage(PageExamVO vo);

}
