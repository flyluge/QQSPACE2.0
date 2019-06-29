package com.qqSpace.service.impl;

import com.qqSpace.service.ReMessageboardService;
import com.qqspace.dao.ReMessageboardDao;

public class ReMessageboardServiceimpl implements ReMessageboardService {
	private ReMessageboardDao messageboardDao;

	public void setMessageboardDao(ReMessageboardDao messageboardDao) {
		this.messageboardDao = messageboardDao;
	}
	
}
