package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
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

	public Article doPublish(User user, Article article) {
		if(user!=null && user.getUid()!=null && article!=null) {
			article.setUser(user);
			articleDao.add(article);
		}
		return article;
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
		if(pageSize==null) {
			pageSize=10;
		}
		page.setPageSize(pageSize);
		//设置查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.eq("user.uid", user.getUid()));
		criteria.addOrder(Order.desc("pubdate"));
		List<Article> articles = articleDao.findByPage(criteria, (currPage-1)*pageSize, pageSize);
		//设置总数量
		int totalcount=(int)articleDao.findAllCount(criteria);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pageSize;
		if(totalcount%pageSize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置page中的数据
		page.setPage(articles);
		return page;
	}
	/**
	 * 查找好友的说说
	 * 传入好友拥有者的id(user.uid)
	 */
	public PageBean<Article> allArticle(User user, Integer currPage, Integer pageSize) {
		PageBean<Article> page=new PageBean<Article>();
		//设置当前页
		if(currPage==null) {
			currPage=1;
		}
		page.setCurrpage(currPage);
		//设置页面大小
		if(pageSize==null) {
			pageSize=10;
		}
		page.setPageSize(pageSize);
		//查询用户的说说
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		
		//查询好友的说说
		Integer tuid=user.getUid();
		
		DetachedCriteria cf=DetachedCriteria.forClass(Friend.class);
		cf.add(Restrictions.eq("tuid", tuid));
		cf.add(Restrictions.eq("fstatus", 1));
		cf.setProjection(Property.forName("fuser.uid"));
		cf.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		criteria.add(Restrictions.or(Property.forName("user.uid").in(cf),Restrictions.eq("user.uid", user.getUid())));
		criteria.addOrder(Order.desc("pubdate"));
		List<Article> article = articleDao.findByPage(criteria, (currPage-1)*pageSize, pageSize);
		int totalcountx = (int) articleDao.findAllCount(criteria);
		//设置总数量
		int totalcount = totalcountx;
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=(totalcount)/pageSize;
		if(totalcount%pageSize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		page.setPage(article);
		return page;
	}

	@Override
	public Integer findCount(Integer uid) {
		// TODO Auto-generated method stub
		DetachedCriteria ca=DetachedCriteria.forClass(Article.class);
		ca.add(Restrictions.eq("user.uid", uid));
		return (int) articleDao.findAllCount(ca);
	}
	
}
