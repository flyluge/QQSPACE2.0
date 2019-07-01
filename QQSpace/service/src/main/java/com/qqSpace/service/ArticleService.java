package com.qqSpace.service;

import java.util.List;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqSpace.util.PageBean;

public interface ArticleService {
	void doPublish(User user, Article article);
	
	void doDelete(Integer aid);
	/**
	 * 获取用户发布的说说
	 * @param user
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	PageBean<Article> selfArticle(User user, Integer currPage, Integer pageSize);
	/**
	 * 获取用户和其好友发布的说说
	 * @param user
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	PageBean<Article> allArticle(User user, Integer currPage, Integer pageSize);
}
