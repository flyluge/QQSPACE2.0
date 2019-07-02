package com.qqSpace.service;

import com.qqSpace.domain.ReComment;
import com.qqSpace.util.PageBean;

public interface RecommentService {
	/**
	 *  删除回复
	 * @param recomment带有回复的rmid
	 */
	void deleteRecom(ReComment recomment);
	/**
	 * 通过评论的id查询回复
	 * @param recomment带有评论的cid comment.cid
	 * @return
	 */
	PageBean<ReComment> findRecomByCid(Integer currpage,Integer pagesize,ReComment recomment);
	/**
	 * 
	 * @param recomment
	 * @return
	 */
	PageBean<ReComment> findRecomByUid(Integer currpage,Integer pagesize,ReComment recomment);
	/**
	 *  添加评论回复
	 * @param recomment  comment.cid:评论   user.uid:回复人
	 */
	void addRecom(ReComment recomment);
	/**
	 * 获取用户收到的回复
	 * @param currpage
	 * @param pagesize
	 * @param tuid 接受回复的人
	 * @return
	 */
	PageBean<ReComment> findRecomByThisUid(Integer currpage, Integer pagesize,Integer tuid);


}
