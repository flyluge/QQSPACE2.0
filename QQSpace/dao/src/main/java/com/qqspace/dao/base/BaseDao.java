package com.qqspace.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/*
	 * 增
	 */
	void add(T t);
	/*
	 *删
	 */
	void delete(T t);
	/*
	 * 改
	 */
	void update(T t);
	/*
	 * 查询所有数量
	 */
	long findAllCount();
	/*
	 * 条件查询数量
	 */
	long findAllCount(DetachedCriteria criteria);
	/*
	 * 查询单个
	 */
	T findById(Serializable id);
	/*
	 * 查询所有
	 */
	List<T> findAll();
	/*
	 * 分页查询
	 */
	List<T> findByPage(Integer currPage,Integer pageSize);
	/*
	 * 条件分页查询 
	 */
	List<T> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize);
}
