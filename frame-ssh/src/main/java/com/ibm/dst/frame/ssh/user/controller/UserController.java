package com.ibm.dst.frame.ssh.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.dst.frame.ssh.user.model.User;
import com.ibm.dst.frame.ssh.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService = null;
	
	@RequestMapping
	public String getUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("userList", users);
		return "user/users";
	}
	
	@RequestMapping("/{userId}")
	public String getUserById(@PathVariable("userId") String id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/user";
	}
	
	@RequestMapping("/toAdd")
	public String toAddUser(Model model) {
		model.addAttribute("user", new User());
		return "user/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/add";
		}
		if(userService.addUser(user)) {
			model.addAttribute("user", user);
			return "user/success";
		} else {
			model.addAttribute("message", "Add failed.");
			return "forward:/user";
		}
	}
	
	@RequestMapping("/{userId}/toEdit")
	public String toEditUser(@PathVariable("userId") String id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("userId", id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping(value="/{userId}/edit", method=RequestMethod.POST)
	public String editUser(@PathVariable("userId") String id, @Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userId", id);
			return "user/edit";
		}
		if(userService.editUser(user)) {
			model.addAttribute("user", user);
			return "user/success";
		} else {
			model.addAttribute("message", "Add failed.");
			return "forward:/user";
		}
	}
	
	@RequestMapping("/del")
	public String delUser(@RequestParam("userId") String id, Model model) {
		if(userService.delUser(id)) {
			model.addAttribute("message", "Delete success.");
			return "forward:/user";
		} else {
			model.addAttribute("message", "Delete failed.");
			return "forward:/user";
		}
	}
	
}
