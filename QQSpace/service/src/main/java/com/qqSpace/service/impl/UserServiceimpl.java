package com.qqSpace.service.impl;

import com.qqSpace.domain.User;
import com.qqSpace.service.UserService;
import com.qqspace.dao.UserDao;

public class UserServiceimpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(String account, String password) {
		User user = userDao.find(account, password);
		return user;
	}
	public boolean register(User user) {
		if(userDao.find(user.getUseremail())==null) {
			userDao.add(user);
			return true;
		}
		return false;
	}

	
}
