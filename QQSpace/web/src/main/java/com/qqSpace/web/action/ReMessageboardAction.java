package com.qqSpace.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.ReMessageboard;
import com.qqSpace.service.ReMessageboardService;
import com.qqSpace.util.PageBean;
import com.qqSpace.web.action.base.BaseAction;
/**
 * ReMessageboardAction是 回复留言 的action
 * @author Luge
 *
 */
public class ReMessageboardAction extends BaseAction implements ModelDriven<ReMessageboard>{
	
	private static final long serialVersionUID = 1L;
	private ReMessageboard reMessbd=new ReMessageboard();
    private ReMessageboardService reMessbdService;
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
	
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public ReMessageboardService getReMessbdService() {
		return reMessbdService;
	}
	public void setReMessbdService(ReMessageboardService reMessbdService) {
		this.reMessbdService = reMessbdService;
	}
	@Override
	public ReMessageboard getModel() {
		return reMessbd;
	}
	/**
	 * 添加回复
	 */
	public void addReMess() {
		reMessbdService.addReMess(reMessbd);
		this.write(true, "添加成功");
	}
	/**
	 * 删除回复
	 */
	public void deleteReMess() {
		reMessbdService.deleteReMess(reMessbd);
		this.write(true, "删除成功");
	}
	/**
	 *  通过留言的mbid获取留言的回复
	 */
	public void findReMessByTUidandMbid(){
		PageBean<ReMessageboard> page=reMessbdService.findReMessByTUidandMbid(currpage,pagesize,reMessbd);
		if(page==null) {
			this.write(false, "用户登陆超时");
		}else {
			this.write(true,page);
		}
	}

}
