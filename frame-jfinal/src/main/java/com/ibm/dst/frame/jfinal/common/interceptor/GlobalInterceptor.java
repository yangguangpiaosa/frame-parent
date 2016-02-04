package com.ibm.dst.frame.jfinal.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before Interceptor......");
		inv.invoke();
		System.out.println("After Interceptor......");
	}

}
