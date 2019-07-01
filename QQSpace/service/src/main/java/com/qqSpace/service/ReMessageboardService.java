package com.qqSpace.service;

import com.qqSpace.domain.ReMessageboard;
import com.qqSpace.util.PageBean;

public interface ReMessageboardService {

	PageBean<ReMessageboard> findReMessByMbid(Integer currpage,Integer pagesize,ReMessageboard reMessbd);

	void deleteReMess(ReMessageboard reMessbd);

	void addReMess(ReMessageboard reMessbd);

	PageBean<ReMessageboard> findReMessByUid(Integer currpage, Integer pagesize, ReMessageboard reMessbd);

}
