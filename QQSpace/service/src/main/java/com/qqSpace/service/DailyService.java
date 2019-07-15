package com.qqSpace.service;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月15日 下午4:58:20 
*/

import java.util.List;

import com.qqSpace.domain.Daily;

public interface DailyService {
	void save(Daily daily);
	List<Daily> findAll(Integer uid);
}
