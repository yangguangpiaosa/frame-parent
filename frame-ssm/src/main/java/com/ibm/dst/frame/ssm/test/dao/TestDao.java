package com.ibm.dst.frame.ssm.test.dao;

import java.util.List;

import com.ibm.dst.frame.ssm.common.base.dao.BaseMapper;
import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.test.model.Employee;

public interface TestDao extends BaseMapper {
	public List<Employee> getEmpList() throws BaseException;
}
