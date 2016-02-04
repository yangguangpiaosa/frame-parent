package com.ibm.dst.frame.jfinal.common.config;

import com.ibm.dst.frame.jfinal.user.controller.UserController;
import com.jfinal.config.Routes;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("/user", UserController.class);
	}
	
}
