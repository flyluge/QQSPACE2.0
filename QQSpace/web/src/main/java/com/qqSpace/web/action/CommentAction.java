package com.qqSpace.web.action;

import com.qqSpace.domain.Comment;
import com.qqSpace.service.CommentService;
import com.qqSpace.util.PageBean;
import com.qqSpace.web.action.base.BaseAction;
/**
 *  CommentAction为评论的action
 * @author Luge
 *
 */
public class CommentAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	private Comment comment;
	private Integer currpage;//当前页
	private Integer pagesize;//页面大小
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public Integer getCurrpage() {
		return currpage;
	}
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	/**
	 *  通过说说的aid获取评论的内容
	 *  需要传入aid
	 */
	public void findCommentByAid() {
		PageBean<Comment> page=commentService.findCommentByAid(currpage,pagesize,comment);
		if(page==null) {
			this.write(false, "获取评论失败");
		}else {
			this.write(true, page);
		}
	}
	/**
	 *  通过发布评论的用户uid获取评论的内容
	 * 需要传入user.uid
	 */
	public void findCommentByUid() {
		PageBean<Comment> page=commentService.findCommentByUid(currpage,pagesize,comment);
		if(page==null) {
			this.write(false, "获取评论失败");
		}else {
			this.write(true, page);
		}
	}
	/**
	 * 添加评论 需要用户user.uid 说说aid 内容content 时间pubdate
 	 */
	public void addComment() {
		Comment c = commentService.addComment(comment);
		if(c!=null) {
			this.write(true, c);
		}else {
			this.write(false, "添加失败,非好友");
		}
	}
	/**
	 * 删除评论 需要评论的cid
	 */
	public void deleteComment() {
		commentService.deleteComment(comment);
		this.write(true, "删除成功");
	}
}
