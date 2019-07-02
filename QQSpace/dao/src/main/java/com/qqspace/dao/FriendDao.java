package com.qqspace.dao;

import java.util.List;

import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqspace.dao.base.BaseDao;
/**
 *   用户好友的接口
 *   说说增删改查
 * @author Luge
 *
 */
public interface FriendDao extends BaseDao<Friend> {
	/**
	 * 查找用户的好友
	 * @param tuid 用户的id
	 * @return 返回用户tuid的好友列表
	 */
	List<Friend> findByUid(Integer tuid);
	/**
	 * 查询好友的状态
	 */
	Friend find(Integer tuid, Integer fuid);
	/**
	 * 通过状态查询好友请求
	 * @param status
	 * @return 没有值返回null
	 */
	List<Friend> findByStatus(Integer uid, Integer status);
}
