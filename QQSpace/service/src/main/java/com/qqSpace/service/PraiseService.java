package com.qqSpace.service;

public interface PraiseService {
	/**
	 * 为某篇文章点赞
	 * @param praise
	 * @return 
	 */
	boolean doPraise(int uid, int aid);
	/**
	 * 取消对某篇文章的点赞
	 * @param praise
	 */
	void doCanclePraise(int uid, int aid);
}
