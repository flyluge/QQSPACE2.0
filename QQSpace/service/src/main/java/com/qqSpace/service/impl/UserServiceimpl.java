package com.qqSpace.service.impl;

import com.qqSpace.domain.User;
import com.qqSpace.service.UserService;
import com.qqspace.dao.UserDao;

public class UserServiceimpl implements UserService {
	private UserDao userDao;
	public static final int ACCOUNT_EXIST = 0;
	public static final int ACCOUNT_ERROR = 1; 
	public static final int PASSWORD_ERROR = 2; 
	public static final int TRUE = 3;
	public static final int FALSE = 4;
	public static final int ACCOUNT_UNEXIST = 5;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(String account, String password) {
		User user = userDao.find(account, password);
		return user;
	}
	public int register(User user) {
		if(user!=null) {
			if(!isExistAccount(user.getUseremail())) {
				userDao.add(user);
				return TRUE;
			} else {
				return ACCOUNT_EXIST;
			}
		}
		return FALSE;
	}
	public boolean isExistAccount(String account) {
		if(userDao.find(account)!=null) {
			return true;
		}
		return false;
	}

	public int update(User newUser, User oldUser) {
		if(newUser!=null && oldUser!=null) {
			if(isExistAccount(newUser.getUseremail())) {
				newUser.setUid(oldUser.getUid());
				userDao.update(newUser);
				return TRUE;
			} else {
				return ACCOUNT_UNEXIST;
			}
		}
		return FALSE;
	}
	
}
