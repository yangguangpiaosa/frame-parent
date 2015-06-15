package com.ibm.dst.frame.ssm.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ibm.dst.frame.ssm.common.annotation.Mapper;
import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.test.model.Employee;

@Mapper
public interface TestMapper {
	@Select("select emp_no empNo,emp_name empName,emp_salary empSalary,hiredate hiredate from employee")
	public List<Employee> getEmpList() throws BaseException;
}
