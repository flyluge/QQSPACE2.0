package com.qqSpace.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Messageboard;
import com.qqSpace.service.MessageBoardService;
import com.qqSpace.web.action.base.BaseAction;
/**
 * Messageboard是留言板操作类
 * @author Luge
 *
 */
public class MessageboardAction extends BaseAction implements ModelDriven<Messageboard>{
	private static final long serialVersionUID = 1L;
	private MessageBoardService messageBoardService;
	private Messageboard messbd=new Messageboard();
	public void setMessageBoardService(MessageBoardService messageBoardService) {
		this.messageBoardService = messageBoardService;
	}
	@Override
	public Messageboard getModel() {
		// TODO Auto-generated method stub
		return messbd;
	}

	/**
	 * 添加留言
	 */
	public void AddMessageBoard() {
		messageBoardService.addMessBd(messbd);
	}
	
}
