package com.oxy.constant;

import java.util.LinkedHashMap;

import com.oxy.utils.AssertApp;
import com.oxy.utils.ServiceOperationException;

/**
 * @date 2019年4月12日 下午12:01:56
 * @Description 
 */
public class ExamConstant {
	/**
	 * @date 2019年4月12日下午3:20:04
	 * @Description 问题类型
	 */
	public enum QuestionType{
		SAQ("1","判断题"),
		SINGLE("2","选择题"),
		STUDENT("3","学生表");
		public static final String REG="1||2||3";
		public String index;
		public String name;

		QuestionType(String index, String name) {
			this.index = index;
			this.name = name;
		}
	}
	
	
	/**
	 * @date 2019年4月12日下午3:20:31
	 * @Description 问题难易程度
	 */
	public enum QuestionLevel{
		EASY(1,"简单"),
		NORMAL(2,"一般"),
		HARD(3,"困难");
		public static final String REG="1||2||3";
		public Integer index;
		public String name;

		QuestionLevel(Integer index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public static Integer getIndex(String name){
			if(AssertApp.isEmpty(name)){
				return null;
			}
			QuestionLevel[] levles = QuestionLevel.values();
			for(QuestionLevel lev:levles){
				if(lev.name.equals(name)){
					return lev.index;
				}
			}
			throw new ServiceOperationException(-2,"问题难易程度说明异常");
		}
	}
	
	
	/**
	 * @author lil1
	 * @date 2019年4月16日上午11:46:36
	 * @Description 考试状态
	 */
	public enum ExamStatus{
		NOT_BEGIN("1","未开始"),
		GOING("2","进行中"),
		ENDED("3","已结束");
		public static final String REG="1||2||3";
		public String index;
		public String name;

		ExamStatus(String index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public static LinkedHashMap<String, String> getContant(){
			LinkedHashMap<String, String> constant=new LinkedHashMap<String, String>();
			ExamStatus[] status = ExamStatus.values();
			for(ExamStatus s:status){
				constant.put(s.index, s.name);
			}
			return constant;
		}
	}
}
