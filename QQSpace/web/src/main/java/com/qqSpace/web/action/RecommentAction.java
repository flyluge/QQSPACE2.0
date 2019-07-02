package com.qqSpace.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.ReComment;
import com.qqSpace.service.RecommentService;
import com.qqSpace.util.PageBean;
import com.qqSpace.web.action.base.BaseAction;

/**
 * RecommentAction是回复评论的类
 * @author Luge
 *
 */
public class RecommentAction extends BaseAction implements ModelDriven<ReComment>{

	private static final long serialVersionUID = 1L;
	private ReComment recomment=new ReComment();
	private RecommentService recomService;
	private Integer currpage;
	private Integer pagesize;
	private Integer tuid;//接受评论的人
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	public void setTuid(Integer tuid) {
		this.tuid = tuid;
	}
	@Override
	public ReComment getModel() {
		// TODO Auto-generated method stub
		return recomment;
	}
	public void setRecomService(RecommentService recomService) {
		this.recomService = recomService;
	}
	/**
	 *  添加回复
	 *  @param comment.cid:评论   user.uid:回复人
	 */
	public void addRecom() {
		recomService.addRecom(recomment);
		this.write(true, "添加成功");
	}
	/**
	 * 删除回复
	 * @param rmid:回复
	 */
	public void deleteRecom() {
		recomService.deleteRecom(recomment);
		this.write(true, "删除成功");
	}
	/**
	 *  通过评论id获取回复  分页
	 *  @param comment.cid
	 */
	public void findRecomByCid() {
		PageBean<ReComment> page=recomService.findRecomByCid(currpage,pagesize,recomment);
		if(page==null) {
			this.write(false, "查询失败");
		}else {
			this.write(true, page);
		}
	}
	/**
	 *  通过用户user.uid获取回复
	 */
	public void findRecomByUid() {
		PageBean<ReComment> page=recomService.findRecomByUid(currpage,pagesize,recomment);
		if(page==null) {
			this.write(false, "查询失败");
		}else {
			this.write(true, page);
		}
	}
	/**
	 *  获取用户收到的回复
	 *  通过commnet.user.uid获取
	 */
	public void findRecomByThisUid() {
		PageBean<ReComment> page=recomService.findRecomByThisUid(currpage,pagesize,tuid);
		if(page==null) {
			this.write(false, "查询失败");
		}else {
			this.write(true, page);
		}
	}
}
