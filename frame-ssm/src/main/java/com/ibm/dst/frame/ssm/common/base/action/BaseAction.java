package com.ibm.dst.frame.ssm.common.base.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibm.dst.frame.ssm.common.base.exception.BaseException;
import com.ibm.dst.frame.ssm.common.base.model.OperateBean;
import com.ibm.dst.frame.ssm.common.base.service.BaseService;
import com.ibm.dst.frame.ssm.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public abstract class BaseAction extends ActionSupport implements BaseInterface {

	private static final long serialVersionUID = -1455720862175292694L;
	
	@Autowired
	@Qualifier("baseService")
	private BaseService baseService = null;
	// request params
	protected Map<String, Object> pMap;
	// request method
	protected String method;
	// context
	protected ActionContext context;
	// session
	protected Map<String, Object> session;
	// request
	protected HttpServletRequest request;
	// response
	protected HttpServletResponse response;
	// page tips
	protected String message = null;
	// log
	protected static final Logger logger = Constants.LOGGER;

	@Override
	public String execute() throws Exception {
		context = ActionContext.getContext();
		session = context.getSession();
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		method = request.getParameter(Constants.PARAMETER_METHOD);
		request.setAttribute(Constants.PARAMETER_METHOD, method);
		String path = request.getRequestURI();
		Constants.LOGGER.info("Request URL:" + path);
		/*
		 * ServletContext servletContext =
		 * ServletActionContext.getServletContext(); if (servletContext != null)
		 * { ApplicationContext ctx =
		 * WebApplicationContextUtils.getRequiredWebApplicationContext
		 * (servletContext); if(ctx!=null){ this.baseService =
		 * (BaseService)ctx.getBean("common.baseService"); } }
		 */
		saveCondition(request);
		String dispatch = dispatch();
		return (null==dispatch||"".equals(dispatch))?"Error":dispatch;
	}

	protected abstract String dispatch() throws Exception;

	private void saveCondition(HttpServletRequest request) {
		// find all params in form
		Enumeration<String> params = request.getParameterNames();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String value = null;
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			if (paramName.startsWith(Constants.PARAMETER_SIGN)) {
				value = request.getParameter(paramName).trim();
				request.setAttribute(paramName, value);
				paramsMap.put(paramName, value);
			}
		}
		pMap = paramsMap;
	}

	protected void operateLog(String operateInfo, String operateClass,
			String operateMethod, String operateParamsDes) {

		OperateBean operateBean = new OperateBean();
		operateBean.setOperateUser(null == session.get("userId") ? "1"
				: (String) session.get("userId"));
		operateBean.setOperateInfo(operateInfo);
		operateBean.setOperateClass(operateClass);
		operateBean.setOperateMethod(operateMethod);
		operateBean.setOperateParamsDes(operateParamsDes);

		try {
			baseService.operateLog(operateBean);
		    Constants.LOGGER.info("Log done！");
		} catch (BaseException e) {
			Constants.LOGGER.error("Log error！");
		}
	}

	protected String getRemoteIp() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public boolean isAuthority() {
		boolean isAccess = false;

		context = ActionContext.getContext();
		session = context.getSession();
		request = ServletActionContext.getRequest();
		// saveCondition(request);
		if (null == pMap) {
			pMap = new HashMap<String, Object>();
		}
		pMap.put("userId", session.get(Constants.SESSION_USER_ID));
		pMap.put("requestUri",request.getRequestURI() + "?m=" + request.getParameter(Constants.PARAMETER_METHOD));

		/////try {
			/////isAccess = ("0".equals(baseService.isAuthority(pMap)))?false:true;
		/////Constants.SLF_INFO_LOGGER.info("判断用户权限成功！");
			operateLog("判断用户对请求路径是否有权限访问", this.getClass().getName(),
					"isAuthority",
					"参数：用户ID：" + session.get(Constants.SESSION_USER_ID)
							+ "请求路径：" + request.getRequestURI());
		/////} catch (BaseException e) {
		/////Constants.SLF_ERROR_LOGGER.error("判读用户权限失败！");
		/////}

		return isAccess;
	}

	protected String getMethod(String requestMethod) {
		String realMethod = "";

		/////try {
			/////realMethod = baseService.getMethod(requestMethod);
		/////Constants.SLF_INFO_LOGGER.info("获取真实请求method成功！");
			operateLog("获取真实请求method", this.getClass().getName(), "getMethod",
					"参数：请求method:" + requestMethod);
		/////Constants.SLF_INFO_LOGGER.info("真实请求方法为：" + realMethod);
		/////} catch (BaseException e) {
		/////Constants.SLF_ERROR_LOGGER.error("获取真实请求method失败！");
		/////}

		return realMethod;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
