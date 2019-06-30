package com.qqSpace.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.User;
import com.qqSpace.service.UserService;
import com.qqSpace.service.impl.UserServiceimpl;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 下午2:31:27 
*/
public class UserAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public void sessionuser() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			write(true , user);			
		} else {
			write(false , "用户未登录");						
		}
	}
	public void login() {
		if(user!=null) {
			User u = userService.login(user.getUseremail(), user.getUserpassword());
			if(u!=null) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("user", u);
				write(true, "登录成功");
			} else {
				write(false, "用户名或密码错误");
			}			
		} else {
			write(false, "用户信息不全");
		}
	}
	public void existAccount() {
		if(user!=null) {
			if(userService.isExistAccount(user.getUseremail())) {
				write(true, "用户名存在");
			} else {
				write(false, "用户名不存在");
			}			
		} else {
			write(false, "用户信息不全");
		}
	}
	public void register() {
		if(user!=null) {
			int note = userService.register(user);
			if(UserServiceimpl.ACCOUNT_EXIST == note||note == UserServiceimpl.FALSE) {
				write(false, "注册失败");
			} else if(note == UserServiceimpl.TRUE) {
				write(true, "注册成功");
			}
		} else {
			write(false, "用户信息不全");
		}
	}
	public void saveAlter() {
		User oldUser = (User) ActionContext.getContext().getSession().get("user");
		int note = userService.update(user, oldUser);
		if(UserServiceimpl.ACCOUNT_UNEXIST == note) {
			write(false, "注册账号禁止修改，修改失败");
		} else if(note == UserServiceimpl.TRUE) {
			write(true, "修改成功");
		} else if(note == UserServiceimpl.FALSE) {
			write(false, "修改失败");
		}
	}
	public void logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("user")!=null) {
			session.remove("user");
			write(true, "注销成功");
		} else {
			write(false, "用户未登录");
		}
	}
}
