package com.oxy.vo.itemBank;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.oxy.model.Singleselect;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UpdateSelectVO {
	private Integer questionid;
	@NotBlank
	private String question;
	@NotBlank
	private String choiceone;
	@NotBlank
	private String choicetwo;
	@NotBlank
	private String choicethree;
	@NotBlank
	private String choicefour;
	@NotBlank
	private String answer;
	@NotBlank
	private String subject;
	@NotBlank
	private String chapter;
	@NotNull
	private Integer difficulty;
	public Singleselect toSelect(){
		Singleselect select = new Singleselect();
		select.setQuestionid(questionid);
		select.setQuestion(question);
		select.setChoiceone(choiceone);
		select.setChoicetwo(choicetwo);
		select.setChoicethree(choicethree);
		select.setChoicefour(choicefour);
		select.setAnswer(answer);
		select.setSubject(subject);
		select.setChapter(chapter);
		select.setDifficulty(difficulty);
		return select;
	}
}
