package com.ibm.dst.frame.ssh.user.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ibm.dst.frame.ssh.common.dao.BaseDao;
import com.ibm.dst.frame.ssh.user.dao.UserDao;
import com.ibm.dst.frame.ssh.user.model.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session s = this.getSession();
		Transaction t = s.beginTransaction();
		List<User> users = s.createQuery("from User").list();
        t.commit();
        s.close();
		return users;
	}

	@Override
	public User getUserById(String id) {
		Session s = this.getSession();
		Transaction t = s.beginTransaction();
		User user = (User)s.createQuery("from User where id=:id").setParameter("id", id).uniqueResult();
        t.commit();
        s.close();
		return user;
	}

	@Override
	public boolean addUser(User user) {
		Session s = this.getSession();
		Transaction t = s.beginTransaction();
		s.save(user);
        t.commit();
        s.close();
		return true;
	}

	@Override
	public boolean editUser(User user) {
		Session s = this.getSession();
		Transaction t = s.beginTransaction();
		s.saveOrUpdate(user);
        t.commit();
        s.close();
		return true;
	}

	@Override
	public boolean delUser(String id) {
		Session s = this.getSession();
		Transaction t = s.beginTransaction();
		s.delete(s.load(User.class, id));
        t.commit();
        s.close();
		return true;
	}

}
