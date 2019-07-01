package com.qqSpace.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.ReMessageboard;
import com.qqSpace.service.ReMessageboardService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.ReMessageboardDao;
/**
 * ReMessageboardServiceimpl是留言回复的服务类
 * @author Luge
 *
 */
public class ReMessageboardServiceimpl implements ReMessageboardService {
	private ReMessageboardDao remessageboardDao;

	public void setRemessageboardDao(ReMessageboardDao remessageboardDao) {
		this.remessageboardDao = remessageboardDao;
	}

	/**
	 *  通过留言的id分页查找留言的回复
	 */
	@Override
	public PageBean<ReMessageboard> findReMessByTUidandMbid(Integer currpage,Integer pagesize,ReMessageboard reMessbd) {
		if(reMessbd.getMbid()==null) {
			return null;
		}
		PageBean<ReMessageboard> page=new PageBean<ReMessageboard>();
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
		int totalcount=(int)remessageboardDao.findAllCount();
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		DetachedCriteria c=DetachedCriteria.forClass(ReMessageboard.class);
		c.add(Restrictions.eq("mbid", reMessbd.getMbid()));
		List<ReMessageboard> list = remessageboardDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 通过rmid删除留言的回复
	 */
	@Override
	public void deleteReMess(ReMessageboard reMessbd) {
		ReMessageboard r = remessageboardDao.findById(reMessbd.getRmid());
		if(r!=null) {
			remessageboardDao.delete(r);
		}
	}
	/**
	 * 添加回复
	 */
	@Override
	public void addReMess(ReMessageboard reMessbd) {
		//设置当前时间
		reMessbd.setPubdate(new Timestamp(new Date().getTime()));
		remessageboardDao.add(reMessbd);
	}
}
