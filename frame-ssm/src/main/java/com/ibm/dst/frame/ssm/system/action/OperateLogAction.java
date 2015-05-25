package com.ibm.dst.frame.ssm.system.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.dst.frame.ssm.common.base.action.BaseAction;
import com.ibm.dst.frame.ssm.system.service.OperateLogService;

@Scope("prototype")
@Controller
public class OperateLogAction extends BaseAction {

	private static final long serialVersionUID = 3303036158212453062L;
	
	@Autowired
	@Qualifier("operateLogService")
	private OperateLogService operateLogService = null;

	@Override
	protected String dispatch() throws Exception {
		return null;
	}

}
