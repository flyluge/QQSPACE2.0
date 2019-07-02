package com.qqSpace.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.Comment;
import com.qqSpace.domain.User;
import com.qqSpace.service.CommentService;
import com.qqSpace.service.FriendService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.ArticleDao;
import com.qqspace.dao.CommentDao;
/**
 * 说说评论的服务类
 * @author Luge
 *
 */
public class CommentServiceimpl implements CommentService {
	CommentDao commentDao;
	ArticleDao articleDao;
	FriendService friendService;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
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
		DetachedCriteria c=DetachedCriteria.forClass(Comment.class);
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
		DetachedCriteria c=DetachedCriteria.forClass(Comment.class);
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
	/**
	 *  添加说说评论
	 *  需要comment.user.uid\ aid \content 
	 */
	@Override
	public boolean addComment(Comment comment) {
		
		//获取说说拥有者
		Article a = articleDao.findById(comment.getAid());
		User user1 = comment.getUser();
		Integer fid=a.getUid();
		//获取发布评论人的id
		User user2=new User();
		user2.setUid(fid);
		if(friendService.isFriend(user1, user2)) {
			comment.setPubdate(new Timestamp(new Date().getTime()));
			commentDao.add(comment);
			return true;
		}else {
			return false;
		}
	}
	
}
