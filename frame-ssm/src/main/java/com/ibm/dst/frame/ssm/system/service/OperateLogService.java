package com.ibm.dst.frame.ssm.system.service;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.service.BaseService;

public interface OperateLogService extends BaseService {
	
	public void log() throws BaseException;
	
}
