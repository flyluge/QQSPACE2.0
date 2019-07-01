package com.qqSpace.web.action;

import com.qqSpace.service.CommentService;
import com.qqSpace.web.action.base.BaseAction;
/**
 *  CommentAction为评论的action
 * @author Luge
 *
 */
public class CommentAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	/**
	 *  通过说说的aid获取评论的内容
	 */
	public void findCommentByAid() {
		
	}
	/**
	 *  通过发布评论的用户uid获取评论的内容
	 */
	public void findCommentByUid() {
		
	}
	/**
	 * 添加评论 需要用户uid 说说aid 内容content 时间pubdate
 	 */
	public void addComment() {
		
	}
	/**
	 * 删除评论 需要评论的aid
	 */
	public void deleteComment() {
		
	}
}
