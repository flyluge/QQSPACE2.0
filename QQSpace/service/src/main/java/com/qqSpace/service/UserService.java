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
	 * @return user为空返回FALSE 用户名已存在返回ACCOUNT_EXIST
	 */
	int register(User user);
    /**
     * 验证用户 account 是否存在
     * @param account
     * @return 不存在返回false
     */
	boolean isExistAccount(String account);
	/**
	 * 更新用户信息
	 * @param newUser
	 * @param oldUser
	 * @return 
	 */
	int update(User newUser, User oldUser);
}
