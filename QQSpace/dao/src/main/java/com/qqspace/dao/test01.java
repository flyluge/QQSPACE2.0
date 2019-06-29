package com.qqspace.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqspace.dao.base.impl.BaseDaoimpl;

public class test01 extends BaseDaoimpl<User>{
	
	public User getUser() {
		List<?> list = this.getHibernateTemplate().find("from User");
		return (User) list.get(0);
	}
	@Test
	public void Test() {
		@SuppressWarnings("resource")
		ApplicationContext a=new ClassPathXmlApplicationContext("applicationContext-datasource.xml");
		test01 t=(test01) a.getBean("test01");
		User user = t.findById(1);
		Collection<Article> aa = user.getArticlesByUid();
		@SuppressWarnings("unused")
		Iterator<Article> iterator = aa.iterator();
		for (Article ar : aa) {
			System.out.println(ar.getContent());
		}
	}
}
