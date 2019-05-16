package com.oxy.service;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.oxy.dto.itemBank.PageSaqDTO;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;
import com.oxy.vo.saq.ImportExcelVO;

public interface SAQService {
	PageInfo<PageSaqDTO> page(PageSaqVO req);
	void insert(AddSaqVO vo);
	void update(UpdateSaqVO vo);
	void delete(int saqid);
	void importExcel(MultipartFile file, ImportExcelVO vo);
}
