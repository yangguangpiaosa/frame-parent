package com.ibm.dst.frame.ssm.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.service.impl.BaseServiceImpl;
import com.ibm.dst.frame.ssm.test.dao.TestDao;
import com.ibm.dst.frame.ssm.test.dao.TestMapper;
import com.ibm.dst.frame.ssm.test.model.Employee;
import com.ibm.dst.frame.ssm.test.service.TestService;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl implements TestService {
	@Autowired
	@Qualifier("testDao")
	private TestDao testDao = null;
	
	@Autowired
	@Qualifier("testMapper")
	private TestMapper testMapper = null;

	public List<Employee> getEmpList() throws BaseException {
		logger.info("Service.............");
		return testDao.getEmpList();
	}

	public List<Employee> getEmpListByMapper() throws BaseException {
		logger.info("Service.............");
		return testMapper.getEmpList();
	}
	
}
