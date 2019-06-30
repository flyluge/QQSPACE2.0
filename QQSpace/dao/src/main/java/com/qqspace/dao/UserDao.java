package com.qqspace.dao;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月29日 下午5:50:55 
*/
import com.qqSpace.domain.User;
import com.qqspace.dao.base.BaseDao;


public interface UserDao extends BaseDao<User>{
	/**
	 * 通过用户名密码查询用户
	 * @author YunLei
	 * @param userEmail
	 * @param userPassword
	 * @return 查不到返回 null
	 */
	User find(String userEmail, String userPassword);
	/**
	 * 通过用户名查询用户
	 * @param userEmail
	 * @return 查不到返回 null
	 */
	User find(String userEmail);
}
