package com.oxy.vo.exam;

import javax.validation.constraints.NotNull;


import lombok.Data;

/**
 * @author lil1
 * @date 2019年4月16日 下午3:30:06
 * @Description 
 */
@Data
public class UpdateExamVO extends AddExamVO{
	@NotNull
	private Integer examId;

}
