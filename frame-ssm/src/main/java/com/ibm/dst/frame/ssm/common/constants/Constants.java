package com.ibm.dst.frame.ssm.common.constants;

import org.apache.log4j.Logger;

public abstract class Constants {
    
	/**数学常量*/
	public static final double PI = java.lang.Math.PI;//圆周率3.14159
	public static final double E  = java.lang.Math.E; //自然对数2.71828
	
    /**日期格式*/
    public static final String DATE_FORMAT  = "yyyy-MM-dd";
    public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:m:ss";
    
    /**文件操作*/
    public static final String CONTENT_TYPE         = "text/html;charset=utf-8";
    public static final String DEFAULT_APP_NAME     = "ssm";
    public static final String DEFAULT_CONTEXT_PATH = "/ssm";
    public static final int    FILE_MAX_SIZE        = 2*1024*1024;//导入文件最大阀值2M
    
    /**页面参数键值*/
    public static final String PARAMETER_SIGN   = "p_";//用于SQL条件参数
    public static final String PARAMETER_METHOD = "op";//用于对应action的method
    
    /**分页常数-每页显示多少条记录*/
    public static final int ITEM_COUNT = 10;
    
    /**日志记录 log4j*/
    public static final Logger LOGGER = Logger.getRootLogger();//记录日志
    //public static final Logger INFO_LOGGER  = Logger.getLogger("infoLogger");//信息
    //public static final Logger WARN_LOGGER  = Logger.getLogger("warnLogger");//警告
    //public static final Logger ERROR_LOGGER = Logger.getLogger("errorLogger");//错误
    //public static final Logger FATAL_LOGGER = Logger.getLogger("fatalLogger");//严重
    
    /**日志记录 slf4j*/
    //public static final org.slf4j.Logger SLF_INFO_LOGGER  = org.slf4j.LoggerFactory.getLogger("infoLogger");//信息
    //public static final org.slf4j.Logger SLF_WARN_LOGGER  = org.slf4j.LoggerFactory.getLogger("warnLogger");//警告
    //public static final org.slf4j.Logger SLF_ERROR_LOGGER = org.slf4j.LoggerFactory.getLogger("errorLogger");//错误
    //public static final org.slf4j.Logger SLF_FATAL_LOGGER = org.slf4j.LoggerFactory.getLogger("fatalLogger");//严重
    
    /**SESSION属性*/
    public static final String SESSION_USER_ID   = "userId";
    public static final String SESSION_USER_NAME = "userName";
    public static final String SESSION_USER_PASS = "userPass";
    public static final String SESSION_REG_IP    = "regIp";
    
}
