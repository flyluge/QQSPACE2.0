package com.qqSpace.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Album;
import com.qqSpace.service.AlbumService;
import com.qqSpace.util.PageBean;
import com.qqspace.dao.AlbumDao;
/**
 * AlbumServiceimpl使相册的服务类
 * @author Luge
 *
 */
public class AlbumServiceimpl implements AlbumService {
	private AlbumDao albumDao;
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	/**
	 * 删除相册
	 */
	@Override
	public void deleteAlbum(Album album) {
		albumDao.delete(album);
	}
	/**
	 * 添加相册
	 */
	@Override
	public void addAlbum(Album album) {
		album.setPubdate(new Timestamp(new Date().getTime()));
		albumDao.add(album);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageBean<Album> findAlbumByPage(Integer uid,Integer currpage, Integer pagesize) {
		if(uid==null) {
			return null;
		}
		PageBean<Album> page=new PageBean<Album>();
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
		DetachedCriteria c=DetachedCriteria.forClass(Album.class);
		c.add(Restrictions.eq("uid", uid));
		int totalcount=(int)albumDao.findAllCount(c);
		page.setTotalcount(totalcount);
		//设置总页数
		int totalpage=totalcount/pagesize;
		if(totalcount%pagesize>0) {
			totalpage++;
		}
		page.setTotalpage(totalpage);
		//设置内容
		List<Album> list = albumDao.findByPage(c,(currpage-1)*pagesize, pagesize);
		page.setPage(list);
		return page;
	}
}
