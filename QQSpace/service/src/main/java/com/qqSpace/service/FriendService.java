package com.qqSpace.service;

import java.util.List;

import com.qqSpace.domain.User;
import com.qqSpace.util.PageBean;

public interface FriendService {
	/**
	 * 查询用户uid的好友fuid的信息
	 * @return fuid的user对象
	 */
	User findFriend(Integer uid, Integer fuid);
	/**
	 * 
	 * @param integer
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	PageBean<User> findFriends(Integer integer, Integer currPage, Integer pageSize);
	/**
	 * 判断是否为好友
	 * @param uid
	 * @param fuid
	 * @return 是好友返回真
	 */
	boolean isFriend(Integer uid, Integer fuid);
	/**
	 * 用户uid1给uid2发送好友请求
	 * @param uid1
	 * @param uid2
	 */
	void doSendFriendReq(Integer uid1, Integer uid2);
	/**
	 * 通过用户uid获取好友请求
	 * PageBean中的page中的第一个值List<User> 第二个值Map<User, Integer(用户uid1对User的确认状态)>
	 * @return 查不到返回null 查到返回map key为哪个好友发送的请求 value为uid是否同意了他的请求
	 */
	PageBean<Object> showReqList(Integer uid, Integer currPage, Integer pageSize);
	/**
	 * 用户uid1确认uid2的好友请求
	 * 
	 * @param uid1
	 * @param uid2
	 * @param msg 同意（1）还是拒绝(0)
	 */
	void doAffirmReq(Integer uid1, Integer uid2, Integer msg);
	/**
	 * 判断用户uid1对uid2（0已发送请求 1未同意 2同意 -1接受状态）
	 * @param uid1
	 * @param uid2
	 * @return 0已发送请求 1未同意 2同意 -1接受状态
	 */
	Integer status(Integer uid1, Integer uid2);
	Integer findFCount(Integer tuid);
	List<User> findFriends(Integer tuid);
	Integer findFReqCount(Integer tuid);
}
