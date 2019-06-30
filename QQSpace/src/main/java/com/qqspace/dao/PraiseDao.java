package com.qqspace.dao;

import com.qqSpace.domain.Praise;
import com.qqspace.dao.base.BaseDao;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月29日 下午5:50:55 
*/
public interface PraiseDao extends BaseDao<Praise>{
	/**
	 * 
	 * @param uid
	 * @param aid
	 * @return 查不到返回空
	 */
	Praise findByUidAndAid(int uid , int aid);
}
