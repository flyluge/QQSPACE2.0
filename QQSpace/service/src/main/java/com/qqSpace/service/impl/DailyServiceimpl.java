package com.qqSpace.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qqSpace.domain.Daily;
import com.qqSpace.service.DailyService;
import com.qqspace.dao.DailyDao;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月15日 下午4:59:37 
*/
public class DailyServiceimpl implements DailyService {
	private DailyDao dailyDao;

	public void setDailyDao(DailyDao dailyDao) {
		this.dailyDao = dailyDao;
	}

	public void save(Daily daily) {
		dailyDao.add(daily);
		
	}
	
	public List<Daily> findAll(Integer uid) {
		DetachedCriteria c=DetachedCriteria.forClass(Daily.class);
		c.add(Restrictions.eq("uid", uid));
		return dailyDao.find(c);
	}
	
	
}
