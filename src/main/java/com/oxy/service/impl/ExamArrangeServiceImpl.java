package com.oxy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.oxy.constant.ExamConstant.ExamStatus;
import com.oxy.dao.ExaminationMapper;
import com.oxy.dao.ext.ExtExamMapper;
import com.oxy.model.Examination;
import com.oxy.service.ExamArrangeService;
import com.oxy.utils.AssertApp;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.exam.AddExamVO;
import com.oxy.vo.exam.PageExamVO;
import com.oxy.vo.exam.UpdateExamVO;

/**
 * @author lil1
 * @date 2019年4月16日 上午11:22:49
 * @Description
 */
@Service
public class ExamArrangeServiceImpl implements ExamArrangeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamArrangeServiceImpl.class);

	@Autowired
	private ExaminationMapper examMapper;
	@Autowired
	private ExtExamMapper extMapper;

	@Override
	@Transactional
	public void addExam(AddExamVO vo) {
		Examination exam = new Examination();
		if (new Date().after(vo.getBeginTime())) {
			throw new ServiceOperationException(-2, "开考时间异常");
		}

		if (vo.getBeginTime().after(vo.getEndTime())) {
			throw new ServiceOperationException(-2, "考试时间异常");
		}
		vo.toExam(vo, exam);
		examMapper.insert(exam);
	}

	@Override
	@Transactional
	public void updateExam(UpdateExamVO vo) {
		Examination exam0 = examMapper.selectByPrimaryKey(vo.getExamId());
		AssertApp.notNull(exam0, "当前无此记录");
		if (ExamStatus.ENDED.index.equals(exam0.getStatus()) || ExamStatus.GOING.index.equals(exam0.getStatus())) {
			throw new ServiceOperationException(-2, "当前考试已启动,不可更改");
		}
		Examination exam = new Examination();
		if (new Date().after(vo.getBeginTime())) {
			throw new ServiceOperationException(-2, "开考时间异常");
		}

		if (vo.getBeginTime().after(vo.getEndTime())) {
			throw new ServiceOperationException(-2, "考试时间异常");
		}
		exam.setExamid(vo.getExamId());
		vo.toExam(vo, exam);
		examMapper.updateByPrimaryKey(exam);
	}

	@Override
	@Transactional
	public void deleteExam(BaseDeleteVO vo) {
		// 进行中或已完成的考试不可删除
		for (Integer id : vo.getIds()) {
			Examination exam = examMapper.selectByPrimaryKey(id);
			AssertApp.notNull(exam, "当前无此记录");
			if (ExamStatus.ENDED.index.equals(exam.getStatus()) || ExamStatus.GOING.index.equals(exam.getStatus())) {
				throw new ServiceOperationException(-2, "当前考试已启动,不可删除");
			}
			examMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public List<LinkedHashMap<String, Object>> getPage(PageExamVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<LinkedHashMap<String, Object>> list = extMapper.getPage(vo);
		for (LinkedHashMap<String, Object> e : list) {
			@SuppressWarnings("unchecked")
			List<String> classIds = (List<String>) JSON.parse((String) e.get("classIds"));
			e.put("classIds", classIds);
		}
		LOGGER.info("getPage(),resp{}", JSON.toJSONString(list));
		return list;
	}

}
