package com.qqspace.dao.impl;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月29日 下午5:50:55 
*/
import java.util.List;

import com.qqSpace.domain.User;
import com.qqspace.dao.UserDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;


public class UserDaoimpl extends BaseDaoimpl<User> implements UserDao {

	@Override
	public User find(String userEmail, String userPassword) {
		List<?> users = (List<?>) this.getHibernateTemplate().find("from User where useremail = ?0 and userpassword = ?1", userEmail, userPassword);
		if(!users.isEmpty()) {
			return (User) users.get(0);
		}
		return null;
	}
	

}
