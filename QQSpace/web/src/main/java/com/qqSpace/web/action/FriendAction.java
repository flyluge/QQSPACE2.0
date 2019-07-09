package com.qqSpace.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqSpace.service.FriendService;
import com.qqSpace.web.action.base.BaseAction;

public class FriendAction extends BaseAction implements ModelDriven<Friend>{

	private static final long serialVersionUID = 1L;
	private Friend friend=new Friend();
	private FriendService friendService;

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	@Override
	public Friend getModel() {
		// TODO Auto-generated method stub
		return friend;
	}
	/**
	 * 通过tuid
	 * 查询好友的数量
	 */
	public void findFCount() {
		Integer findFCount = friendService.findFCount(friend.getTuid());
		this.write(true, findFCount);
	}
	/**
	 * 通过tuid
	 * 获取所有的好友
	 */
	public void findAllFriends() {
		List<User> friends = friendService.findFriends(friend.getTuid());
		this.write(true, friends);
	}
	/**
	 * 通过tuid
	 * 获取好友请求的数量
	 */
	public void findFReqCount() {
		Integer findFReqCount = friendService.findFReqCount(friend.getTuid());
		this.write(true, findFReqCount);
	}
}
