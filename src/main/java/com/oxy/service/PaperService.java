package com.oxy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.oxy.dto.paper.PagePaperDTO;
import com.oxy.model.ExaminationPaper;
import com.oxy.model.SAQ;
import com.oxy.model.Singleselect;
import com.oxy.vo.paper.AutoGeneratingVO;
import com.oxy.vo.paper.PagePaperVO;
import com.oxy.vo.paper.SAQIdVO;
import com.oxy.vo.paper.SelectIdVO;

public interface PaperService {
	List<Singleselect> getSelect(String subject);
	
	List<SAQ> getSaq(String subject);
	
	void insert(AutoGeneratingVO vo);
	
	PageInfo<PagePaperDTO> page(PagePaperVO vo);
	
	void delete(int paperid);
	
	ExaminationPaper selectById(int paperid);
	
	List<Singleselect> getSelectById(String questionids);
	
	List<SAQ> getSAQById(String saqids);
	
	void deleteSelect(SelectIdVO vo);
	
	void deleteSAQ(SAQIdVO vo);
	
	void addSelect(SelectIdVO vo);
	
	void addSAQ(SAQIdVO vo);

	Object listOption(String subject);
}
