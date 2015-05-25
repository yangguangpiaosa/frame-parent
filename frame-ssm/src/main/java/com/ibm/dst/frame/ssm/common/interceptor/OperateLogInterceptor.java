package com.ibm.dst.frame.ssm.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ibm.dst.frame.ssm.common.constants.Constants;
import com.ibm.dst.frame.ssm.system.service.OperateLogService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OperateLogInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 508165221644307416L;
	
	@Autowired
	@Qualifier("operateLogService")
	private OperateLogService operateLogService = null;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		operateLogService.log();
		return ai.invoke();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		Constants.LOGGER.info("--------------------Log interceptor end.--------------------");
	}
	
	@Override
	public void init() {
		super.init();
		Constants.LOGGER.info("--------------------Log interceptor start.--------------------");
	}

}
