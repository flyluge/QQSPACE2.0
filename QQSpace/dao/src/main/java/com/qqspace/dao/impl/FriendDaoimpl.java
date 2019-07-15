package com.qqspace.dao.impl;

import java.util.List;

import com.qqSpace.domain.Friend;
import com.qqspace.dao.FriendDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;

public class FriendDaoimpl extends BaseDaoimpl<Friend> implements FriendDao {

	@SuppressWarnings("unchecked")
	public List<Friend> findByUid(Integer tuid) {
		return (List<Friend>) this.getHibernateTemplate().find("from Friend where tuid = ?0", tuid);
	}

	public Friend find(Integer tuid, Integer fuid) {
		List<?> friends = (List<?>) this.getHibernateTemplate().find("from Friend where tuid = ?0 and fuser.uid = ?1", tuid, fuid);
		if(!friends.isEmpty()) {
			return (Friend) friends.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Friend> findByStatus(Integer uid, Integer status) {
		List<?> friends = (List<?>) this.getHibernateTemplate().find("from Friend where tuid=?0 and fstatus = ?1", uid, status);
		if(!friends.isEmpty()) {
			return (List<Friend>) friends;
		}
		return null;
	}

}
