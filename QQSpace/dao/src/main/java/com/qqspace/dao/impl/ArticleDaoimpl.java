package com.qqspace.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Article;
import com.qqspace.dao.ArticleDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;

public class ArticleDaoimpl extends BaseDaoimpl<Article> implements ArticleDao {

	@Override
	public List<Article> findByUId(Integer uid, Integer begin, Integer pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.eq("uid", uid));
		return findByPage(criteria, begin, pageSize);
	}


}
