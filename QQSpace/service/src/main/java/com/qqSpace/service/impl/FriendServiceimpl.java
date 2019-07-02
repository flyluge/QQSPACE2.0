package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqSpace.service.FriendService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.FriendDao;
import com.qqspace.dao.UserDao;

public class FriendServiceimpl implements FriendService {
	private FriendDao friendDao;
	private UserDao userDao;
	
	private static final Integer FRIEND_STATUS = 1;
	private static final Integer DEL_STATUS = 0;
	private static final Integer REQUEST_STATUS = 2;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@SuppressWarnings("static-access")
	public PageBean<User> findFriend(User user, Integer currPage, Integer pageSize) {
		PageBean<User> page=new PageBean<User>();
		//设置当前页
		if(currPage==null) {
			currPage=1;
		}
		page.setCurrpage(currPage);
		//设置页面大小
		if(pageSize==0||pageSize==null) {
			pageSize=10;
		}
		page.setPageSize(pageSize);
		//设置总数量
		DetachedCriteria cf = DetachedCriteria.forClass(Friend.class);
		cf.add(Restrictions.eq("tuid", user.getUid()));
		cf.add(Restrictions.eq("status", 1));
		int totalcount=(int)friendDao.findAllCount(cf);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pageSize;
		if(totalcount%pageSize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//查询好友的详细信息
		DetachedCriteria cu=DetachedCriteria.forClass(User.class);
		cf.setProjection(Property.forName("fuid"));
		cf.setResultTransformer(cf.DISTINCT_ROOT_ENTITY);
		cu.add(Property.forName("uid").in(cf));
		//
		page.setPage(userDao.findByPage(cu, (currPage-1)*pageSize, pageSize));
		return page;
	}
	public boolean isFriend(User user1, User user2) {
		Friend f = friendDao.find(user1.getUid(), user2.getUid());
		if(f!=null && f.getStatus()== FRIEND_STATUS){
			return true;
		}
		return false;
	}
}
