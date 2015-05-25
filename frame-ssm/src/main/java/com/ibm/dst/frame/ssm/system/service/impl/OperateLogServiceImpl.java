package com.ibm.dst.frame.ssm.system.service.impl;

import org.springframework.stereotype.Service;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.service.impl.BaseServiceImpl;
import com.ibm.dst.frame.ssm.system.service.OperateLogService;

@Service("operateLogService")
public class OperateLogServiceImpl extends BaseServiceImpl implements OperateLogService {

	public void log() throws BaseException {
		System.out.println("log...");
	}

}
