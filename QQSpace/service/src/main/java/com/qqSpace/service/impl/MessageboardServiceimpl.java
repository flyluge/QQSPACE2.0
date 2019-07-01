package com.qqSpace.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.qqSpace.domain.Messageboard;
import com.qqSpace.service.MessageBoardService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.MessageboardDao;
/**
 * 留言板服务类
 * @author Luge
 *
 */
public class MessageboardServiceimpl implements MessageBoardService {
	private MessageboardDao messageboardDao;

	public void setMessageboardDao(MessageboardDao messageboardDao) {
		this.messageboardDao = messageboardDao;
	}
	/**
	 * 添加留言
	 */
	@Override
	public void addMessBd(Messageboard messbd) {
		messbd.setPubdate(new Timestamp(new Date().getTime()));
		messageboardDao.add(messbd);
	}
	/**
	 * 分页获取留言
	 */
	@Override
	public PageBean<Messageboard> findMessBdByPage(Integer currpage,Integer pagesize,Messageboard messbd) {
		if(messbd.getTuid()==null) {
			return null;
		}
		PageBean<Messageboard> page=new PageBean<Messageboard>();
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
		c.add(Restrictions.eq("tuid", messbd.getTuid()));
		int totalcount=(int)messageboardDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<Messageboard> list = messageboardDao.findByPage(c, (currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
	/**
	 * 删除留言
	 */
	@Override
	public void deleteMessBd(Messageboard messbd) {
		Messageboard m = messageboardDao.findById(messbd.getMbid());
		if(m!=null) {
			messageboardDao.delete(m);
		}
	}
}
