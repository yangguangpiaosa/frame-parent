package com.ibm.dst.frame.ssm.test.service;

import java.util.List;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.service.BaseService;
import com.ibm.dst.frame.ssm.test.model.Employee;

public interface TestService extends BaseService {
	public List<Employee> getEmpList() throws BaseException;
	public List<Employee> getEmpListByMapper() throws BaseException;
}
