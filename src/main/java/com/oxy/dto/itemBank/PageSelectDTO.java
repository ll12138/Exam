package com.oxy.dto.itemBank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageSelectDTO {
	private Integer questionid;
	private String question;
	private String choiceone;
	private String choicetwo;
	private String choicethree;
	private String choicefour;
	private String answer;
	private String subject;
	private String chapter;
	private Integer difficulty;
	private String createuser;
}
