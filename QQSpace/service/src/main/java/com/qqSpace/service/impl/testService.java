package com.qqSpace.service.impl;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 上午11:47:58 
*/

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqSpace.service.UserService;
import com.qqspace.dao.impl.UserDaoimpl;

public class testService {
	@Test
	public void testUserService() {
		ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
		UserService udi = (UserService) a.getBean("userService");
		System.out.println(udi.login("110@qq.com", "123456"));
	}
}
