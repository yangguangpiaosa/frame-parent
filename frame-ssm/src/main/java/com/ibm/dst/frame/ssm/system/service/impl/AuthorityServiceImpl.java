package com.ibm.dst.frame.ssm.system.service.impl;

import org.springframework.stereotype.Service;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.service.impl.BaseServiceImpl;
import com.ibm.dst.frame.ssm.system.service.AuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl extends BaseServiceImpl implements AuthorityService {

	public void hasAuthority() throws BaseException {
		System.out.println("auth...");
	}

}
