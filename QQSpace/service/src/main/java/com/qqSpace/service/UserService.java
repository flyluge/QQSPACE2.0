package com.qqSpace.service;

import java.util.List;

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
	int doRegister(User user);
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
	int doUpdate(User newUser, User oldUser);
	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过id获取用户
	 */
	User findUserById(Integer uid);
	List<User> findFuzzyUser(String fuzzyname);
}
