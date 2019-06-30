package com.qqSpace.web.action;

import com.qqSpace.domain.User;
import com.qqSpace.service.UserService;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 下午2:31:27 
*/
public class UserAction extends BaseAction{
	
	User user;
	UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void login() {
		User u = userService.login(user.getUseremail(), user.getUserpassword());
		if(u!=null) {
			write(true, u);
		} else {
			write(false, "用户名或密码错误");
		}
	}
	public void register() {
		
	}
	
}
