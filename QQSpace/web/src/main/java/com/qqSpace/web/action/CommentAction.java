package com.qqSpace.web.action;

import com.qqSpace.service.CommentService;
import com.qqSpace.web.action.base.BaseAction;

public class CommentAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	

}
