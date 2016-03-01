package com.ibm.dst.frame.jfinal.common.controller;

import com.jfinal.core.Controller;

public class InitController extends Controller {
	
	public void index() {
		//renderText("Hello JFinal.");
		renderJsp("index.jsp");
	}
	
}
