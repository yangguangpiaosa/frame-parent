package com.ibm.dst.frame.ssm.system.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.dst.frame.ssm.common.base.action.BaseAction;
import com.ibm.dst.frame.ssm.system.service.AuthorityService;

@Scope("prototype")
@Controller
public class AuthorityAction extends BaseAction {

	private static final long serialVersionUID = -969186217995374019L;
	
	@Autowired
	@Qualifier("authorityService")
	private AuthorityService authorityService = null;

	@Override
	protected String dispatch() throws Exception {
		return null;
	}

}
