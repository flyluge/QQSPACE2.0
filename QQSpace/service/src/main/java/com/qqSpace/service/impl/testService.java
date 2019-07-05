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

import com.qqSpace.domain.Comment;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.service.CommentService;
import com.qqSpace.service.FriendService;
import com.qqSpace.service.PraiseService;
import com.qqSpace.util.PageBean;

public class testService {
	@Test
	public void testUserService() {
		@SuppressWarnings("resource")
		ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
		PraiseService fs = (PraiseService) a.getBean("praiseService");
		System.out.println(fs.findAllCount(1));;
//		Comment comment = new Comment();
//		comment.setAid(1);
//		fs.findCommentByAid(1, 10, comment);
//		System.out.println(fs.findCommentByAid(1, 10, comment).getPage().size());
		//fs.doSendFriendReq(1, 3);
//		PageBean<Object> page = fs.showReqList(2, 0, 10);
//		@SuppressWarnings("unchecked")
//		List<User> listUser = (List<User>) page.getPage().get(0);
//		@SuppressWarnings("unchecked")
//		Map<User, Integer> map = (Map<User, Integer>) page.getPage().get(1);
//		for (User user : listUser) {
//			System.out.println(user.getUseremail()+" "+map.get(user));
//		}
		//fs.doAffirmReq(2, 1, 0);
	}
}
