package com.qqSpace.service.impl;

import com.qqSpace.service.RecommentService;
import com.qqspace.dao.ReCommentDao;

public class RecommentServiceimpl implements RecommentService {
	private ReCommentDao commentDao;

	public void setCommentDao(ReCommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
}
