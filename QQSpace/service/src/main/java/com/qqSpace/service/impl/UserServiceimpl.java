package com.qqSpace.service.impl;

import com.qqSpace.service.UserService;
import com.qqspace.dao.UserDao;

public class UserServiceimpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
