package com.ibm.dst.frame.ssh.user.dao;

import java.util.List;

import com.ibm.dst.frame.ssh.user.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public User getUserById(String id);
	
	public boolean addUser(User user);
	
	public boolean editUser(User user);
	
	public boolean delUser(String id);
	
}
