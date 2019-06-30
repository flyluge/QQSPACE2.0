package com.qqSpace.service;

import com.qqSpace.domain.User;

public interface UserService {
	/**
	 * 
	 * @param account
	 * @param password
	 * @return 登录成功返回用户信息，失败返回null
	 */
	User login(String account, String password);
	/**
	 * 
	 * @param user
	 * @return 
	 */
	boolean register(User user);
}
