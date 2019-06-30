package com.qqspace.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqSpace.domain.Album;
import com.qqspace.dao.AlbumDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;
/**
 * 相册 dao实现类
 * @author Luge
 *
 */
public class AlbumDaoimpl extends BaseDaoimpl<Album> implements AlbumDao {
	
	public Album geta() {
		return (Album) this.getHibernateTemplate().find("from Album where userByUid.uid=1").get(0);
	}
	@Test
	public void test01() {
		@SuppressWarnings("resource")
		ApplicationContext a=new ClassPathXmlApplicationContext("classpath:applicationContext-datasource.xml");
		AlbumDao aa=(AlbumDao)a.getBean("albumDao");
		DetachedCriteria d = DetachedCriteria.forClass(Album.class);
		d.add(Restrictions.eq("uid", 1));
		List<Album> list = aa.findByPage(d, 0, 5);
		System.out.println(list.get(0).getImage());
	}
}
