package com.oxy.dao.ext;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oxy.model.UserAnswer;
import com.oxy.vo.exam.PageGradeVO;

/**
 * @author lil1
 * @date 2019年4月17日 上午11:36:58
 * @Description 
 */
public interface ExtAnswerMapper {

	void insertAnswer(@Param("list")List<UserAnswer> listAnswer);

	List<LinkedHashMap<String, Object>> getScoreList(@Param("vo")PageGradeVO vo, @Param("userId")Integer userId);

	List<LinkedHashMap<String, Object>> getSAQList(@Param("examId")Integer examId, @Param("paperId")Integer paperId,
			@Param("analyze")boolean isAnalyze, @Param("type")String index);
	
	List<LinkedHashMap<String, Object>> getSingleList(@Param("examId")Integer examId, @Param("paperId")Integer paperId,
			@Param("analyze")boolean isAnalyze, @Param("type")String index);

}
