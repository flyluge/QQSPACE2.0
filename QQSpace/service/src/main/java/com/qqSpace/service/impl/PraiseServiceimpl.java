package com.qqSpace.service.impl;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.Praise;
import com.qqSpace.domain.User;
import com.qqSpace.service.PraiseService;
import com.qqspace.dao.PraiseDao;

public class PraiseServiceimpl implements PraiseService {
	private PraiseDao praiseDao;

	public void setPraiseDao(PraiseDao praiseDao) {
		this.praiseDao = praiseDao;
	}

	public boolean doPraise(int uid, int aid) {
		if(praiseDao.findByUidAndAid(uid, aid) == null) {
			Praise praise = new Praise();
			Article article = new Article();
			User user = new User();
			article.setAid(aid);
			user.setUid(uid);
			praise.setArticleByAid(article);
			praise.setUserByUid(user);
			praiseDao.add(praise);
			return true;
		}
		return false;
	}

	public void doCanclePraise(int uid, int aid) {
		Praise praise = praiseDao.findByUidAndAid(uid, aid);
		if(praise!=null) {
			praiseDao.delete(praise);			
		}
	}

	

}
