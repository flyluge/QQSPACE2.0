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
	public String addReMess() {
		reMessbdService.addReMess(reMessbd);
		return "addsuccess";
	}
	/**
	 * 删除回复
	 */
	public String deleteReMess() {
		reMessbdService.deleteReMess(reMessbd);
		return "deletesuccess";
	}
	/**
	 *  通过留言的mbid获取留言的回复
	 */
	public void findReMessByMbid(){
		PageBean<ReMessageboard> page=reMessbdService.findReMessByMbid(currpage,pagesize,reMessbd);
		if(page==null) {
			this.write(false, "文章不存在");
		}else {
			this.write(true,page);
		}
	}
	/**
	 * 通过留言发布者(uid)查看留言的回复
	 */
	public void findReMessByUid() {
		PageBean<ReMessageboard> page=reMessbdService.findReMessByUid(currpage,pagesize,reMessbd);
		if(page==null) {
			this.write(false, "用户登陆超时");
		}else {
			this.write(true,page);
		}
	}
}
