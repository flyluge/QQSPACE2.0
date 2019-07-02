package com.qqSpace.service;

import com.qqSpace.domain.User;
import com.qqSpace.util.PageBean;

public interface FriendService {
	/**
	 * 
	 * @param user
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	PageBean<User> findFriend(User user, Integer currPage, Integer pageSize);
	/**
	 * 判断是否为好友
	 * @param user1
	 * @param user2
	 * @return 是好友返回真
	 */
	boolean isFriend(User user1, User user2);

}
