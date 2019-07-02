package com.qqSpace.service.impl;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 上午11:47:58 
*/

import java.util.List;
import java.util.Map;

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
		FriendService fs = (FriendService) a.getBean("friendService");
		//fs.doSendFriendReq(1, 3);
		PageBean<Object> page = fs.showReqList(2, 0, 10);
		List<User> listUser = (List<User>) page.getPage().get(0);
		Map<User, Integer> map = (Map<User, Integer>) page.getPage().get(1);
		for (User user : listUser) {
			System.out.println(user.getUseremail()+" "+map.get(user));
		}
		//fs.doAffirmReq(2, 1, 0);
	}
}
