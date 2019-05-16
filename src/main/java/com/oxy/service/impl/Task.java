package com.oxy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oxy.dao.ext.ExtExamMapper;

/**
 * @author lil1
 * @date 2019年4月16日 下午3:23:28
 * @Description
 */
@Service
@EnableScheduling
public class Task {
	private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

	@Autowired
	private ExtExamMapper extMapper;

	/**
	 * @Description 每分钟定时执行修改考试安排的状态
	 */
	@Scheduled(cron = "0 * * * * ?")
	@Transactional
	public void callProcedure() {
		LOGGER.info("进入callProcedure方法,{}", "定时开始");
		try {
			extMapper.callProcedure();
			LOGGER.info("进入callProcedure方法,{}", "定时结束");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("进入callProcedure方法,{}", e);
		}

	}
}
