package com.oxy.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.oxy.vo.exam.PageGradeVO;
import com.oxy.vo.exam.SubmitExam;

/**
 * @author lil1
 * @date 2019年4月17日 上午10:27:42
 * @Description 
 */
public interface ExamService {

	void submitAnswer(SubmitExam vo);

	void downLoadGrade(Integer classId, String subject, String paperName, String examName, HttpServletResponse response, boolean isStudent);

	List<LinkedHashMap<String, Object>> getGradePage(PageGradeVO vo, boolean isPage);

	Map<String, Object> getPaperContent(Integer examId, Integer paperId, boolean isAnalyze);
	
	

}
