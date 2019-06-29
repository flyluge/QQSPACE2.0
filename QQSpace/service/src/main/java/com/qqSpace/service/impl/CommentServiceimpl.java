package com.qqSpace.service.impl;

import com.qqSpace.service.CommentService;
import com.qqspace.dao.CommentDao;

public class CommentServiceimpl implements CommentService {
	CommentDao commentDao;

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
}
