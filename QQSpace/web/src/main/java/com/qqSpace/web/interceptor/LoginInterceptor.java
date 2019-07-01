package com.qqSpace.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.qqSpace.domain.User;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月1日 下午1:21:00 
*/
public class LoginInterceptor extends MethodFilterInterceptor{

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			invocation.invoke();
		} else {
			return "用户未登录";
		}
		return "timeout";
		
	}

}
