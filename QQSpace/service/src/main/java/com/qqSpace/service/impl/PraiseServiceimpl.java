package com.qqSpace.service.impl;

import com.qqSpace.domain.Praise;
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
			praise.setAid(aid);
			praise.setUid(uid);
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
