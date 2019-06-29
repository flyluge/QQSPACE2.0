package com.qqSpace.service.impl;

import com.qqSpace.service.MessageBoardService;
import com.qqspace.dao.MessageboardDao;

public class MessageboardServiceimpl implements MessageBoardService {
	private MessageboardDao messageboardDao;

	public void setMessageboardDao(MessageboardDao messageboardDao) {
		this.messageboardDao = messageboardDao;
	}
	
}
