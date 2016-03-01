package com.ibm.dst.frame.jfinal.user.controller;

import com.ibm.dst.frame.jfinal.common.model.USER;
import com.ibm.dst.frame.jfinal.user.interceptor.ActionInterceptor;
import com.ibm.dst.frame.jfinal.user.interceptor.ControllerInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(ControllerInterceptor.class)
public class UserController extends Controller {
	
	@Before(ActionInterceptor.class)
	public void index() {
		/*USER user = new USER();
		user.setID(4);
		user.setNAME("ddd");
		user.save();*/
		renderText("User Controller...");
	}
	
	@Before(ActionInterceptor.class)
	public void upd() {
		USER user = new USER();
		user.setID(3);
		user.setNAME("333");
		user.update();
		redirect("/user");
	}
	
}
