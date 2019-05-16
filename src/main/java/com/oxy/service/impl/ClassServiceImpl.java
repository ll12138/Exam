package com.oxy.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.oxy.dao.ClassesMapper;
import com.oxy.dao.UserMapper;
import com.oxy.dao.ext.ExtClassMapper;
import com.oxy.dao.ext.ExtUserMapper;
import com.oxy.model.Classes;
import com.oxy.model.ClassesExample;
import com.oxy.model.User;
import com.oxy.model.UserExample;
import com.oxy.service.ClassService;
import com.oxy.utils.AssertApp;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.classes.AddClassVO;
import com.oxy.vo.classes.UpdateClassVO;

/**
 * @author lil1
 * @date 2019年4月15日 下午6:16:26
 * @Description
 */
@Service
public class ClassServiceImpl implements ClassService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassServiceImpl.class);
	@Autowired
	private ExtClassMapper extClassMapper;
	@Autowired
	private ClassesMapper classMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ExtUserMapper extUserMapper;

	@Override
	@Transactional
	public void deleteClass(BaseDeleteVO vo) {
		if (!AssertApp.isEmptyList(vo.getIds())) {
			// 删除班级
			// extClassMapper.deleteClass(vo.getIds());
			for (Integer id : vo.getIds()) {
				// 校验班级下是否有学生
				UserExample example = new UserExample();
				example.createCriteria().andClassidEqualTo(id);
				List<User> list = userMapper.selectByExample(example);
				if (!AssertApp.isEmptyList(list)) {
					throw new ServiceOperationException(-2, "该班级下有学生,不予删除");
				}
				classMapper.deleteByPrimaryKey(id);
			}

		}
	}

	@Override
	@Transactional
	public void addClass(AddClassVO vo) {
		// 校验重名
		ClassesExample example = new ClassesExample();
		example.createCriteria().andClassnameEqualTo(vo.getName());
		List<Classes> list = classMapper.selectByExample(example);
		if (!AssertApp.isEmptyList(list)) {
			throw new ServiceOperationException(-2, "班级重名");
		}
		Classes classes = new Classes();
		classes.setClassname(vo.getName());
		classMapper.insert(classes);
		if (!AssertApp.isEmptyList(vo.getUserIds())) {
			for (Integer id : vo.getUserIds()) {
				User user = new User();
				user.setUserid(id);
				user.setClassid(classes.getClassid());
				userMapper.updateByPrimaryKeySelective(user);
			}
		}

	}

	@Override
	public void UpdateClass(UpdateClassVO vo) {
		Classes classes = new Classes();
		classes.setClassid(vo.getClassid());
		classes.setClassname(vo.getName());
		classMapper.updateByPrimaryKeySelective(classes);
		if (!AssertApp.isEmptyList(vo.getUserIds())) {
			// 删除原来的班级-学生关系
			extUserMapper.updateClass(vo.getClassid());

			for (Integer id : vo.getUserIds()) {
				User user = new User();
				user.setUserid(id);
				user.setClassid(classes.getClassid());
				userMapper.updateByPrimaryKeySelective(user);
			}
		}

	}

	@Override
	public List<LinkedHashMap<String, Object>> getClassList(String name, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<LinkedHashMap<String, Object>> list = extClassMapper.getClassList(name);
		for (LinkedHashMap<String, Object> c : list) {
			String str = (String) c.get("studentIds");
			c.put("studentIds", str.split(","));
		}
		LOGGER.info("getClassList(),resp{}", JSON.toJSONString(list));
		return list;
	}

}
