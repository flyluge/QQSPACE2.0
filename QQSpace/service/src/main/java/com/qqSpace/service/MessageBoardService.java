package com.qqSpace.service;

import com.qqSpace.domain.Messageboard;
import com.qqSpace.util.PageBean;

public interface MessageBoardService {

	void addMessBd(Messageboard messbd);

	PageBean<Messageboard> findMessBdByPage(Integer currpage,Integer pagesize,Messageboard messbd);

	void deleteMessBd(Messageboard messbd);

}
