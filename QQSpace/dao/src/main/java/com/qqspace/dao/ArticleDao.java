package com.qqspace.dao;

import java.util.List;

import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqspace.dao.base.BaseDao;
/**
 *   用户说说的接口
 *   说说增删改查
 * @author Luge
 *
 */
public interface ArticleDao extends BaseDao<Article>{
	/**
	 * 获取用户发布的说说 每次获得共10条
	 * @param user
	 * @param begin 查寻起始位置
	 * @return
	 */
	List<Article> findByUId(Integer uid, Integer begin, Integer pageSize);
}
