package com.qqSpace.service.impl;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 上午11:47:58 
*/

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.service.FriendService;
import com.qqSpace.service.PraiseService;
import com.qqSpace.util.PageBean;

public class testService {
	@Test
	public void testUserService() {
		ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
		FriendService us = (FriendService) a.getBean("friendService");
		User user = new User();
		user.setUid(1);
		PageBean<User> list=us.findFriend(user, 1, 5);
		for (User t : list.getPage()) {
			System.out.println(t.getUid());
		}
		System.out.println(list.getTotalpage());
	}
}
