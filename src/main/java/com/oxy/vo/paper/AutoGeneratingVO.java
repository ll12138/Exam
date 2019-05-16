package com.oxy.vo.paper;

import com.oxy.config.CurrentUser;
import com.oxy.model.ExaminationPaper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AutoGeneratingVO {
	private String name;
	private Integer totalselect;
	private Integer selectnum;
	private Integer selectscore;
	private Integer totalsaq;
	private Integer saqnum;
	private Integer saqscore;
	private String subject;
	private Integer score;
	private String questionids;
	private String saqids;
	
	public ExaminationPaper toAutoGenerating(){
		ExaminationPaper paper = new ExaminationPaper();
		paper.setName(name);
		paper.setTotalselect(totalselect);
		paper.setSelectnum(selectnum);
		paper.setSelectscore(selectscore);
		paper.setTotalsaq(totalsaq);
		paper.setSaqnum(saqnum);
		paper.setSaqscore(saqscore);
		paper.setSubject(subject);
		paper.setScore(score);
		paper.setQuestionids(questionids);
		paper.setSaqids(saqids);
		paper.setCreateuser(CurrentUser.getCurrentUserCode()+"");
		return paper;
				
	}
}
