package com.qqSpace.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqSpace.service.FriendService;
import com.qqSpace.service.UserService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.FriendDao;
import com.qqspace.dao.UserDao;

public class FriendServiceimpl implements FriendService {
	private FriendDao friendDao;
	private UserDao userDao;
	
	public static final Integer FRIEND_STATUS = 1;
	public static final Integer UNFRIEND_STATUS = 0;
	public static final Integer REQUEST_STATUS = 0;
	public static final Integer RESPONSE_STATUS = -1;
	public static final Integer UNREQUEST_STATUS = -1;
	public static final Integer AGREE_STATUS = 1;
	public static final Integer BEAGREE_STATUS = 2;
	public static final Integer REFUSE_STATUS = 3;
	public static final Integer BEREFUSE_STATUS = 4;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@SuppressWarnings("static-access")
	public PageBean<User> findFriends(User user, Integer currPage, Integer pageSize) {
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
		cf.add(Restrictions.eq("status", FRIEND_STATUS));
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

	public boolean isFriend(Integer uid, Integer fuid) {
		Friend f = friendDao.find(uid, fuid);
		if(f!=null && f.getFstatus()== FRIEND_STATUS){
			return true;
		} else if(uid == fuid) {
			return true;
		}
		return false;
	}

	@Override
	public User findFriend(Integer uid, Integer fuid) {
		Friend f = friendDao.find(uid, fuid);
		if(f!=null) {
			User user = userDao.findById(f.getFuid());
			user.setUserpassword(null);
			return user;
		}
		return null;
	}

	@Override
	public void doSendFriendReq(Integer uid1, Integer uid2) {
		if(userDao.findById(uid2)!=null) {
			Friend f1 = new Friend();
			//给用户uid1添加好友uid2
			f1.setTuid(uid1);
			f1.setFuid(uid2);
			f1.setRstatus(REQUEST_STATUS);
			f1.setFstatus(UNFRIEND_STATUS);
			friendDao.add(f1);
			//给用户uid2添加好友uid1
			Friend f2 = new Friend();
			f2.setTuid(uid2);
			f2.setFuid(uid1);
			f2.setRstatus(RESPONSE_STATUS);
			f2.setFstatus(UNFRIEND_STATUS);
			friendDao.add(f2);
		}
		
	}

	@SuppressWarnings("static-access")
	@Override
	public PageBean<Object> showReqList(Integer uid, Integer currPage, Integer pageSize) {
		if(userDao.findById(uid)!=null) {
			PageBean<Object> page=new PageBean<Object>();
			//设置当前页
			if(currPage==null) {
				currPage=1;
			}
			page.setCurrpage(currPage);
			//设置页面大小
			if(pageSize==null) {
				pageSize=10;
			}
			page.setPageSize(pageSize);
			//设置总数量
			DetachedCriteria cf = DetachedCriteria.forClass(Friend.class);
			cf.add(Restrictions.eq("tuid", uid));
			cf.add(Restrictions.eq("rstatus", RESPONSE_STATUS));
			int totalcount=(int)friendDao.findAllCount(cf);
			page.setTotalcount(totalcount);
			//设置总页数
			int totalpage=totalcount/pageSize;
			if(totalcount%pageSize>0) {
				totalpage++;
			}
			page.setTotalpage(totalpage);
			//获取数据
			cf.setProjection(Property.forName("fuid"));
			cf.setResultTransformer(cf.DISTINCT_ROOT_ENTITY);
			DetachedCriteria cu=DetachedCriteria.forClass(User.class);
			cu.add(Property.forName("uid").in(cf));
			List<User> userList = userDao.findByPage(cu, currPage, pageSize);
			Map<User, Integer> map = new HashMap<>();
			for(User user: userList) {
				map.put(user, status(user.getUid(), uid));
			}
			
			List<Object> list = new ArrayList<Object>();
			list.add(userList);
			list.add(map);
			page.setPage(list);
			return page;
		}
		return null;
	}

	public void doAffirmReq(Integer uid1, Integer uid2, Integer msg) {
		if(1 == msg) {
			Friend f1 = friendDao.find(uid1, uid2);
			f1.setFstatus(FRIEND_STATUS);
			f1.setRstatus(AGREE_STATUS);
			friendDao.update(f1);
			
			Friend f2 = friendDao.find(uid2, uid1);
			f2.setFstatus(FRIEND_STATUS);
			f2.setRstatus(BEAGREE_STATUS);
			friendDao.update(f2);
		} else if(0 == msg) {
			Friend f1 = friendDao.find(uid1, uid2);
			f1.setFstatus(UNFRIEND_STATUS);
			f1.setRstatus(REFUSE_STATUS);
			friendDao.update(f1);
			
			Friend f2 = friendDao.find(uid2, uid1);
			f2.setFstatus(UNFRIEND_STATUS);
			f2.setRstatus(BEREFUSE_STATUS);
			friendDao.update(f2);
		}
	}

	public Integer status(Integer uid1, Integer uid2) {
		Friend friend = friendDao.find(uid1, uid1);
		if(friend!=null) {
			return friend.getRstatus();
		}
		return -1;
	}
	
	

	
}
