package com.oxy.vo.itemBank;

import com.oxy.config.CurrentUser;
import com.oxy.model.SAQ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSaqVO {
	private Integer saqid;
	private String question;
	private String subject;
	private String chapter;
	private Integer difficulty;
	private String answer;
	
	public SAQ toSAQ(){
		SAQ saq = new SAQ();
		saq.setSaqid(saqid);
		saq.setQuestion(question);
		saq.setSubject(subject);
		saq.setChapter(chapter);
		saq.setDifficulty(difficulty);
		saq.setCreateuser(CurrentUser.getCurrentUserCode()+"");
		saq.setAnswer(answer);
		return saq;
	}
}
