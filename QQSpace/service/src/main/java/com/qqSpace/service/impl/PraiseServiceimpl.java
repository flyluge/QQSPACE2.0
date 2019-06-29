package com.qqSpace.service.impl;

import com.qqSpace.service.PraiseService;
import com.qqspace.dao.PraiseDao;

public class PraiseServiceimpl implements PraiseService {
	private PraiseDao praiseDao;

	public void setPraiseDao(PraiseDao praiseDao) {
		this.praiseDao = praiseDao;
	}
	
}
