package com.qqSpace.service.impl;

import com.qqSpace.service.ReMessageboardService;
import com.qqspace.dao.ReMessageboardDao;

public class ReMessageboardServiceimpl implements ReMessageboardService {
	private ReMessageboardDao remessageboardDao;

	public void setMessageboardDao(ReMessageboardDao remessageboardDao) {
		this.remessageboardDao = remessageboardDao;
	}
	
}
