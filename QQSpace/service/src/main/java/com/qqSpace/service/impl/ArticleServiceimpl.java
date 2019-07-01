package com.qqSpace.service.impl;

import java.util.List;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqspace.dao.ArticleDao;
import com.qqspace.dao.FriendDao;

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
	public List<Article> selfArticle(User user, Integer currPage, Integer pageSize) {
		return articleDao.findByUId(user.getUid(), (currPage-1)*pageSize, pageSize);
	}

	@Override
	public List<Article> allArticle(User user, Integer currPage, Integer pageSize) {
		
		return null;
	}
	
}
