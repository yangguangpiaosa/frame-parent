package com.ibm.dst.frame.ssm.test.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.dst.frame.ssm.common.base.action.BaseAction;
import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.test.model.Employee;
import com.ibm.dst.frame.ssm.test.service.TestService;

@Scope("prototype")
@Controller
public class TestAction extends BaseAction {

	private static final long serialVersionUID = -5162657195840686191L;
	@Autowired
	@Qualifier("testService")
	private TestService testService = null;
	
	private List<Employee> empList = null;
	
	protected String dispatch() throws Exception {
		if("test".equals(super.method)) {
			return test();
		} else if("testMapper".equals(super.method)) {
			return testMapper();
		}
		return null;
	}

	public String test() {
		try {
			logger.info("Action.............");
			empList = testService.getEmpList();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		//HttpServletRequest request = ServletActionContext.getRequest();
		return "test";
	}
	
	public String testMapper() {
		try {
			logger.info("Action.............");
			empList = testService.getEmpListByMapper();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return "test";
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
}
