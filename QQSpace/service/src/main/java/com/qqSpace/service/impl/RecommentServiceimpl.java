package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Comment;
import com.qqSpace.domain.ReComment;
import com.qqSpace.service.RecommentService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.ReCommentDao;

public class RecommentServiceimpl implements RecommentService {
	private ReCommentDao recommentDao;

	public void setRecommentDao(ReCommentDao recommentDao) {
		this.recommentDao = recommentDao;
	}
	/**
	 * 删除回复
	 */
	@Override
	public void deleteRecom(ReComment recomment) {
		ReComment r = recommentDao.findById(recomment.getRmid());
		if(r!=null) {
			recommentDao.delete(recomment);
		}
	}
	/**
	 * 通过评论cid查询
	 */
	@Override
	public PageBean<ReComment> findRecomByCid(Integer currpage,Integer pagesize,ReComment recomment) {
		if(recomment.getComment().getCid()==null) {
			return null;
		}
		PageBean<ReComment> page=new PageBean<ReComment>();
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
		DetachedCriteria c=DetachedCriteria.forClass(ReComment.class);
		c.add(Restrictions.eq("comment.cid", recomment.getComment().getCid()));
		int totalcount=(int)recommentDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<ReComment> list = recommentDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 通过用户uid查询
	 */
	@Override
	public PageBean<ReComment> findRecomByUid(Integer currpage,Integer pagesize,ReComment recomment) {
		if(recomment.getUser().getUid()==null) {
			return null;
		}
		PageBean<ReComment> page=new PageBean<ReComment>();
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
		DetachedCriteria c=DetachedCriteria.forClass(ReComment.class);
		c.add(Restrictions.eq("user.uid", recomment.getUser().getUid()));
		int totalcount=(int)recommentDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<ReComment> list = recommentDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 添加评论回复
	 */
	@Override
	public void addRecom(ReComment recomment) {
		recommentDao.add(recomment);
	}
	@Override
	public PageBean<ReComment> findRecomByThisUid(Integer currpage, Integer pagesize,Integer tuid) {
		if(tuid==null) {
			return null;
		}
		PageBean<ReComment> page=new PageBean<ReComment>();
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
		DetachedCriteria c1=DetachedCriteria.forClass(Comment.class);
		c1.add(Restrictions.eq("user.uid",tuid));
		c1.setProjection(Property.forName("cid"));
		c1.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		DetachedCriteria c2=DetachedCriteria.forClass(ReComment.class);
		c2.add(Property.forName("comment.cid").in(c1));
		
		int totalcount=(int)recommentDao.findAllCount(c2);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<ReComment> list = recommentDao.findByPage(c2, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
}
