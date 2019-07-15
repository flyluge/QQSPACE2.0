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
	private Integer msg; 
	private Integer uid1;
	private Integer uid2;
	
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public void setUid1(Integer uid1) {
		this.uid1 = uid1;
	}
	public void setUid2(Integer uid2) {
		this.uid2 = uid2;
	}
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
	/**
	 * 获取发出请求的好友 需要传入tuid
	 */
	public void findReqFriend() {
		List<Friend> f=friendService.findReqFriends(friend.getTuid());
		this.write(true, f);
	}
	/**
	 * 发出好友请求
	 * @return
	 */
	public String addReq() {
		friendService.doSendFriendReq(uid1, uid2);
		return "addReqsuccess";
	}
	/**
	 * 同意好友请求
	 */
	public String agreeFriend() {
		friendService.doAffirmReq(uid1, uid2, msg);
		return "addReqsuccess";
	}
}
