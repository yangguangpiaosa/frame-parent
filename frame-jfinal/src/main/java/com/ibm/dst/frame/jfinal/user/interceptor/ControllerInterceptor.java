package com.ibm.dst.frame.jfinal.user.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ControllerInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before Controller Interceptor...");
		inv.invoke();
		System.out.println("After Controller Interceptor...");
	}

}
