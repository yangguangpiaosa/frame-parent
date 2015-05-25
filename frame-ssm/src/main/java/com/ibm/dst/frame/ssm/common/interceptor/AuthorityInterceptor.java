package com.ibm.dst.frame.ssm.common.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ibm.dst.frame.ssm.common.constants.Constants;
import com.ibm.dst.frame.ssm.system.service.AuthorityService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1859623758855499731L;
	
	@Autowired
	@Qualifier("authorityService")
	private AuthorityService authorityService = null;

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
		//@SuppressWarnings("rawtypes")
		//Map session = ai.getInvocationContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ai.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		//String userId = (String) session.get(Constants.SESSION_USER_ID);
		String uri = request.getRequestURI();
		
			/////////////////这里判断用户是否有操作权限///////////////////
			/*if (null != userId) {
				Object o = ai.getAction();
				if (o instanceof BaseAction) {
					BaseAction baseAction = (BaseAction) o;
					boolean isAuthority = baseAction.isAuthority();
					if (isAuthority) {
						return ai.invoke();
					} else {
						return "RoleError";
					}
				} else {
					return "Login";
				}
			} else {
				return ai.invoke();
			}*/
    	if(null == request.getParameter(Constants.PARAMETER_METHOD) || 
    			"".equals(request.getParameter(Constants.PARAMETER_METHOD))) {
    		if(!Constants.DEFAULT_CONTEXT_PATH.equals(uri) && 
    				!(Constants.DEFAULT_CONTEXT_PATH+"/").equals(uri)) {
	    		System.out.println("invalid path...");
	    		return "Error";
    		}
    	}
    	System.out.println("Hello,interceptor is coming~~~~~~~~~~~~~");
    	System.out.println("but I traced what you did~~~~~~~~~~haha......");
    	System.out.println("log or verify auth here...");
    	authorityService.hasAuthority();
    	System.out.println("auth passed......");
		return ai.invoke();
		
		/*if(!"/parsexml/system/loginAction".equals(uri)) {
		    
		} else {
		    return ai.invoke();
		}*/
    }

    @Override
    public void destroy() {
		super.destroy();
		Constants.LOGGER.info("--------------------Auth interceptor end.--------------------");
    }

    @Override
    public void init() {
		super.init();
		Constants.LOGGER.info("--------------------Auth interceptor start.--------------------");
    }

}
