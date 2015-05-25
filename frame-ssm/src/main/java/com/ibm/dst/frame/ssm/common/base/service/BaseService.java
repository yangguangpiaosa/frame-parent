package com.ibm.dst.frame.ssm.common.base.service;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.model.OperateBean;

public interface BaseService {
    //将操作日志记入数据库
    public void operateLog(OperateBean operateBean) throws BaseException;
}
