package com.qqSpace.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Messageboard;
import com.qqSpace.domain.ReMessageboard;
import com.qqSpace.domain.User;
import com.qqSpace.service.MessageBoardService;
import com.qqSpace.service.ReMessageboardService;
import com.qqSpace.service.UserService;
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
	private ReMessageboardService remessService;
	private UserService userService;
	private Messageboard messbd=new Messageboard();
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
	public void setMessageBoardService(MessageBoardService messageBoardService) {
		this.messageBoardService = messageBoardService;
	}
	
	public void setMessbd(Messageboard messbd) {
		this.messbd = messbd;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ReMessageboardService getRemessService() {
		return remessService;
	}

	public void setRemessService(ReMessageboardService remessService) {
		this.remessService = remessService;
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
	public String showFMessageboard() {
			PageBean<Messageboard> page = messageBoardService.findMessBdByPage(currpage, pagesize, messbd);
			page.setMap(new HashMap<Integer,List<ReMessageboard>>());
			for (Messageboard m : page.getPage()) {
				ReMessageboard reMessbd=new ReMessageboard();
				reMessbd.setMbid(m.getMbid());
				PageBean<ReMessageboard> pa = remessService.findReMessByMbid(1, 30, reMessbd);
				@SuppressWarnings("unchecked")
				Map<Integer,List<ReMessageboard>> map= (Map<Integer, List<ReMessageboard>>) page.getMap();
				map.put(m.getMbid(), pa.getPage());
			}
			User user=userService.findUserById(messbd.getTuid());
			ActionContext.getContext().getValueStack().set("selfuser", user);
			ActionContext.getContext().getValueStack().set("page", page);
		return "fmessageboardFrame";
	}
	public String showMessageboard() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			messbd.setTuid(user.getUid());
			PageBean<Messageboard> page = messageBoardService.findMessBdByPage(1, 10, messbd);
			page.setMap(new HashMap<Integer,List<ReMessageboard>>());
			for (Messageboard m : page.getPage()) {
				ReMessageboard reMessbd=new ReMessageboard();
				reMessbd.setMbid(m.getMbid());
				PageBean<ReMessageboard> pa = remessService.findReMessByMbid(1, 30, reMessbd);
				@SuppressWarnings("unchecked")
				Map<Integer,List<ReMessageboard>> map= (Map<Integer, List<ReMessageboard>>) page.getMap();
				map.put(m.getMbid(), pa.getPage());
			}
			ActionContext.getContext().getValueStack().set("page", page);
			return "messageboardFrame";
		}else {
			this.write(false,"请先登陆");
			return NONE;
		}
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
	public String deleteMessBd() {
		messageBoardService.deleteMessBd(messbd);
		return "deletesuccess";
	}
}
