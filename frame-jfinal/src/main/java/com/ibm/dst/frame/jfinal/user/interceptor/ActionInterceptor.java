package com.ibm.dst.frame.jfinal.user.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ActionInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before Action Interceptor...");
		inv.invoke();
		System.out.println("After Action Interceptor...");
	}

}
