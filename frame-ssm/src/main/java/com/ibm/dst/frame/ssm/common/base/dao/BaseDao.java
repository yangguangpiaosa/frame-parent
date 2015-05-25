package com.ibm.dst.frame.ssm.common.base.dao;

import com.ibm.dst.frame.ssm.common.base.model.OperateBean;

public interface BaseDao extends BaseMapper {
	
	public void saveLog(OperateBean operateBean);
	
}
