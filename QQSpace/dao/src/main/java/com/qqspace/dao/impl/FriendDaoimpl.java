package com.qqspace.dao.impl;

import java.util.List;

import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqspace.dao.FriendDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;

public class FriendDaoimpl extends BaseDaoimpl<Friend> implements FriendDao {

	@SuppressWarnings("unchecked")
	public List<Friend> findByUid(Integer tuid) {
		return (List<Friend>) this.getHibernateTemplate().find("from Friend where tuid = ?0", tuid);
	}

	public Friend find(Integer tuid, Integer fuid) {
		List<?> friends = (List<?>) this.getHibernateTemplate().find("from Friend where tuid = ?0", tuid);
		if(!friends.isEmpty()) {
			return (Friend) friends.get(0);
		}
		return null;
	}

}
