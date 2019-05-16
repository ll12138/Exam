package com.oxy.dto.paper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagePaperDTO {
	private Integer paperid;
	private String name;
	private Integer totalselect;
	private Integer selectnum;
	private Integer selectscore;
	private Integer totalsaq;
	private Integer saqnum;
	private Integer saqscore;
	private Integer score;
	private String subject;
	private String createuser;
}
