package com.ibm.dst.frame.ssh.test.service.impl;

import org.springframework.stereotype.Component;

import com.ibm.dst.frame.ssh.test.service.Test;

@Component("test")
public class TestImpl implements Test {
	
	public void out() {
		System.out.println("=====================test...");
	}
	
}
