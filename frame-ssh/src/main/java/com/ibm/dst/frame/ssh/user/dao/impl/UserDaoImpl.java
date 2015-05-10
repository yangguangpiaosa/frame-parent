package com.ibm.dst.frame.ssh.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.dst.frame.ssh.user.dao.UserDao;
import com.ibm.dst.frame.ssh.user.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User> ();
		User user1 = new User();
		user1.setId("1");
		user1.setName("Bob");
		user1.setAge(200);
		user1.setEmail("bob@cn.ibm.com");
		users.add(user1);
		User user2 = new User();
		user2.setId("2");
		user2.setName("Max");
		user2.setAge(22);
		user2.setEmail("max@cn.ibm.com");
		users.add(user2);
		return users;
	}

	@Override
	public User getUserById(String id) {
		User user = new User();
		user.setId("1");
		user.setName("Bob");
		user.setAge(200);
		user.setEmail("bob@cn.ibm.com");
		return user;
	}

	@Override
	public boolean addUser(User user) {
		return true;
	}

	@Override
	public boolean editUser(User user) {
		return true;
	}

	@Override
	public boolean delUser(String id) {
		return true;
	}

}
