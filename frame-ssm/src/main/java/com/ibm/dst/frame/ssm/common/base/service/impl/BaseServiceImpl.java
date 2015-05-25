package com.ibm.dst.frame.ssm.common.base.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ibm.dst.frame.ssm.common.base.dao.BaseDao;
import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.model.OperateBean;
import com.ibm.dst.frame.ssm.common.base.service.BaseService;
import com.ibm.dst.frame.ssm.common.constants.Constants;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	protected static final Logger logger = Constants.LOGGER;
	//@Autowired
	//@Qualifier("baseDao")
	private BaseDao baseDao = null;

	public void operateLog(OperateBean operateBean) throws BaseException {
		baseDao.saveLog(operateBean);
	}

}
