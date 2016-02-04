package com.ibm.dst.frame.jfinal.user.controller;

import com.ibm.dst.frame.jfinal.user.interceptor.ActionInterceptor;
import com.ibm.dst.frame.jfinal.user.interceptor.ControllerInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(ControllerInterceptor.class)
public class UserController extends Controller {
	
	@Before(ActionInterceptor.class)
	public void index() {
		renderText("User Controller...");
	}
	
}
