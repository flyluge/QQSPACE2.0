package com.qqSpace.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Messageboard;
import com.qqSpace.domain.User;
import com.qqSpace.service.MessageBoardService;
import com.qqSpace.util.PageBean;
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
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
	public void setMessageBoardService(MessageBoardService messageBoardService) {
		this.messageBoardService = messageBoardService;
	}
	@Override
	public Messageboard getModel() {
		// TODO Auto-generated method stub
		return messbd;
	}
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * 添加留言
	 */
	public void AddMessageBoard() {
		messageBoardService.addMessBd(messbd);
		this.write(true, "添加成功");
	}
	/**
	 * 分页获取留言
	 */
	public void findMessBdByPage() {
		PageBean<Messageboard> page=messageBoardService.findMessBdByPage(currpage,pagesize,messbd);
		if(page==null) {
			this.write(true, "查看留言失败");
		}else {
			this.write(true, page);
		}
	}
	public void getSessionMess() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		messbd.setTuid(user.getUid());
		findMessBdByPage();
	}
	/**
	 * 删除留言
	 */
	public void deleteMessBd() {
		messageBoardService.deleteMessBd(messbd);
	}
}
