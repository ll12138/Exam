package com.oxy.service;

import com.github.pagehelper.PageInfo;
import com.oxy.dto.itemBank.PageSelectDTO;
import com.oxy.vo.itemBank.AddSelectVO;
import com.oxy.vo.itemBank.PageSelectVO;
import com.oxy.vo.itemBank.UpdateSelectVO;

public interface SelectService {
	void insert(AddSelectVO vo);
	
	PageInfo<PageSelectDTO> page( PageSelectVO req);
	
	void update(UpdateSelectVO req);
	
	void delete(int questionid);
}
