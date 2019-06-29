package com.qqSpace.service.impl;

import com.qqSpace.service.RecommentService;
import com.qqspace.dao.ReCommentDao;

public class RecommentServiceimpl implements RecommentService {
	private ReCommentDao recommentDao;

	public void setCommentDao(ReCommentDao recommentDao) {
		this.recommentDao = recommentDao;
	}
	
}
