package com.oxy.dto.itemBank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageSaqDTO {
	private Integer saqid;
	private String question;
	private String subject;
	private String chapter;
	private Integer difficulty;
	private String createuser;
	private String answer;
}
