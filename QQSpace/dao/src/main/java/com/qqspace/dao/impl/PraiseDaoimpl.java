package com.qqspace.dao.impl;

import java.util.List;

import com.qqSpace.domain.Praise;
import com.qqspace.dao.PraiseDao;
import com.qqspace.dao.base.impl.BaseDaoimpl;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月29日 下午5:56:44 
*/
public class PraiseDaoimpl extends BaseDaoimpl<Praise> implements PraiseDao{

	public Praise findByUidAndAid(int uid, int aid) {
		List<?> praise = (List<?>) this.getHibernateTemplate().find("from Praise where uid = ?0 and aid = ?1", uid, aid);
		if(!praise.isEmpty()) {
			return (Praise) praise.get(0);
		}
		return null;
	}

}
