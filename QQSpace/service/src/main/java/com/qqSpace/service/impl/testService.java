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
import com.qqSpace.service.PraiseService;

public class testService {
	@Test
	public void testUserService() {
		ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
		ArticleService us = (ArticleService) a.getBean("articleService");
		User user = new User();
		user.setUid(2);
		List<Article> articles = us.selfArticle(user, 1, 5);
		System.out.println(articles.size());
	}
}
