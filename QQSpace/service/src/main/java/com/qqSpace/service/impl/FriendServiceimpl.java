package com.qqSpace.service.impl;

import com.qqSpace.service.FriendService;
import com.qqspace.dao.FriendDao;

public class FriendServiceimpl implements FriendService {
	private FriendDao friendDao;

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}
	
}
