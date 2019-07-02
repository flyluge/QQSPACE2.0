package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.Friend;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.ArticleDao;

public class ArticleServiceimpl implements ArticleService {
	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void doPublish(User user, Article article) {
		if(user!=null && user.getUid()!=null && article!=null) {
			article.setUid(user.getUid());
			articleDao.add(article);
		}
	}

	public void doDelete(Integer aid) {
		Article article = articleDao.findById(aid);
		if(article!=null) {
			articleDao.delete(article);
		}
	}
	public PageBean<Article> selfArticle(User user, Integer currPage, Integer pageSize) {
		PageBean<Article> page=new PageBean<Article>();
		//设置当前页
		if(currPage==null) {
			currPage=1;
		}
		page.setCurrpage(currPage);
		//设置页面大小
		if(pageSize==0||pageSize==null) {
			pageSize=10;
		}
		page.setPageSize(pageSize);
		//设置总数量
		DetachedCriteria criteria1 = DetachedCriteria.forClass(Article.class);
		criteria1.add(Restrictions.eq("uid", user.getUid()));
		int totalcount=(int)articleDao.findAllCount(criteria1);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pageSize;
		if(totalcount%pageSize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置查询条件
		DetachedCriteria criteria2 = DetachedCriteria.forClass(Article.class);
		criteria2.add(Restrictions.eq("uid", user.getUid()));
		List<Article> articles = articleDao.findByPage(criteria2, (currPage-1)*pageSize, pageSize);
		//设置page中的数据
		page.setPage(articles);
		return page;
	}
	/**
	 * 查找好友的说说
	 * 传入好友拥有者的id(user.uid)
	 */
	@SuppressWarnings("static-access")
	@Override
	public PageBean<Article> allArticle(User user, Integer currPage, Integer pageSize) {
		PageBean<Article> page=new PageBean<Article>();
		//设置当前页
		if(currPage==null) {
			currPage=1;
		}
		page.setCurrpage(currPage);
		//设置页面大小
		if(pageSize==0||pageSize==null) {
			pageSize=10;
		}
		page.setPageSize(pageSize);
		//设置总数量
		DetachedCriteria criteria1 = DetachedCriteria.forClass(Article.class);
		criteria1.add(Restrictions.eq("uid", user.getUid()));
		int totalcount=(int)articleDao.findAllCount(criteria1);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pageSize;
		if(totalcount%pageSize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//查询好友的说说
		Integer tuid=user.getUid();
		DetachedCriteria ca=DetachedCriteria.forClass(Article.class);
		DetachedCriteria cf=DetachedCriteria.forClass(Friend.class);
		cf.add(Restrictions.eq("tuid", tuid));
		cf.add(Restrictions.eq("status", 1));
		cf.setProjection(Property.forName("fuid"));
		cf.setResultTransformer(cf.DISTINCT_ROOT_ENTITY);
		ca.add(Property.forName("uid").in(cf));
		List<Article> friendArticle = articleDao.findByPage(ca, (currPage-1)*pageSize, pageSize);
		//查询用户的说说
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.eq("uid", user.getUid()));
		List<Article> selfArticles = articleDao.findByPage(criteria, (currPage-1)*pageSize, pageSize);
		//将friend合并到self
		selfArticles.addAll(friendArticle);
		
		page.setPage(selfArticles);
		return page;
	}
	
}
