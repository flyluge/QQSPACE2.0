package com.qqSpace.service;

import com.qqSpace.domain.ReMessageboard;
import com.qqSpace.util.PageBean;

public interface ReMessageboardService {

	PageBean<ReMessageboard> findReMessByTUidandMbid(Integer currpage,Integer pagesize,ReMessageboard reMessbd);

	void deleteReMess(ReMessageboard reMessbd);

	void addReMess(ReMessageboard reMessbd);

}
