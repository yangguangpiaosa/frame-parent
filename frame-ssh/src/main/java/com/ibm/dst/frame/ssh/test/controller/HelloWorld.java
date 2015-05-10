package com.ibm.dst.frame.ssh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.dst.frame.ssh.test.service.Test;

@Controller
public class HelloWorld {
	
	@Autowired
	private Test test = null;
	
	@RequestMapping("/helloworld")
    public String helloWorld(String name, Model model) {
		System.out.println("Hello " + name + " !");
		test.out();
        model.addAttribute("message", "Hello " + name + " !");
        return "test/helloworld";
    }
	
}
