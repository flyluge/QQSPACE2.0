package com.qqSpace.service.impl;

import com.qqSpace.service.ArticleService;
import com.qqspace.dao.ArticleDao;

public class ArticleServiceimpl implements ArticleService {
	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
}
