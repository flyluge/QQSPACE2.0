package com.qqSpace.service.impl;

import com.qqSpace.domain.Messageboard;
import com.qqSpace.service.MessageBoardService;
import com.qqspace.dao.MessageboardDao;
/**
 * 留言板服务类
 * @author Luge
 *
 */
public class MessageboardServiceimpl implements MessageBoardService {
	private MessageboardDao messageboardDao;

	public void setMessageboardDao(MessageboardDao messageboardDao) {
		this.messageboardDao = messageboardDao;
	}
	/**
	 * 添加留言
	 */
	@Override
	public void addMessBd(Messageboard messbd) {
		messageboardDao.add(messbd);
	}
}
