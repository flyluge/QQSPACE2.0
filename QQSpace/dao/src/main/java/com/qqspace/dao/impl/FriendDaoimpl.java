package com.qqspace.dao.impl;

import java.util.List;

import com.qqSpace.domain.Friend;
import com.qqspace.dao.FriendDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;

public class FriendDaoimpl extends BaseDaoimpl<Friend> implements FriendDao {

	@Override
	public List<Friend> findByUid(Integer tuid) {
		return (List<Friend>) this.getHibernateTemplate().find("from Friend where tuid = ?0", tuid);
	}

}
