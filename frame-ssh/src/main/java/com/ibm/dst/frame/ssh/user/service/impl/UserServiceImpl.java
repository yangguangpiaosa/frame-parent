package com.ibm.dst.frame.ssh.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dst.frame.ssh.user.dao.UserDao;
import com.ibm.dst.frame.ssh.user.model.User;
import com.ibm.dst.frame.ssh.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao = null;

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}

	@Override
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

}
