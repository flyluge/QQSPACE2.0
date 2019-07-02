package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Comment;
import com.qqSpace.domain.Messageboard;
import com.qqSpace.service.CommentService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.CommentDao;
/**
 * 说说评论的服务类
 * @author Luge
 *
 */
public class CommentServiceimpl implements CommentService {
	CommentDao commentDao;

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	/**
	 * 通过id获取说说的评论 分页
	 */
	@Override
	public PageBean<Comment> findCommentByAid(Integer currpage, Integer pagesize, Comment comment) {
		if(comment.getAid()==null) {
			return null;
		}
		PageBean<Comment> page=new PageBean<Comment>();
		//设置当前页
		if(currpage==null) {
			currpage=1;
		}
		page.setCurrpage(currpage);
		//设置页面大小
		if(pagesize==null) {
			pagesize=10;
		}
		page.setPageSize(pagesize);
		//设置总数量
		DetachedCriteria c=DetachedCriteria.forClass(Messageboard.class);
		c.add(Restrictions.eq("aid", comment.getAid()));
		int totalcount=(int)commentDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<Comment> list = commentDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 通过uid获取评论
	 */
	@Override
	public PageBean<Comment> findCommentByUid(Integer currpage, Integer pagesize, Comment comment) {
		if(comment.getUser().getUid()==null) {
			return null;
		}
		PageBean<Comment> page=new PageBean<Comment>();
		//设置当前页
		if(currpage==null) {
			currpage=1;
		}
		page.setCurrpage(currpage);
		//设置页面大小
		if(pagesize==null) {
			pagesize=10;
		}
		page.setPageSize(pagesize);
		//设置总数量
		DetachedCriteria c=DetachedCriteria.forClass(Messageboard.class);
		c.add(Restrictions.eq("user.uid", comment.getUser().getUid()));
		int totalcount=(int)commentDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<Comment> list = commentDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 通过cid删除评论
	 */
	@Override
	public void deleteComment(Comment comment) {
		Comment c = commentDao.findById(comment.getCid());
		if(c!=null) {
			commentDao.delete(c);
		}
	}
	
}
