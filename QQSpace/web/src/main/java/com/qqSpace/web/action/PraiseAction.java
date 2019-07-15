package com.qqSpace.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.User;
import com.qqSpace.service.PraiseService;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 Wangcheng
* @version 创建时间：2019年6月30日 下午6:49:08 
* 点赞功能
*/
public class PraiseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PraiseService praiseService;
	private int aid;//说说id
	private int uid;//用户id
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setPraiseService(PraiseService praiseService) {
		this.praiseService = praiseService;
	}
	/**
	 * 点赞
	 */
	public void praise() {
		User u = (User) ActionContext.getContext().getSession().get("user");
		if(u!=null) {
			this.uid = u.getUid();
			if(praiseService.doPraise(uid, aid)) {
				write(true, "");
			} else {
				write(false, "");
			}
		}
	}
	/**
	 * 取消点赞
	 */
	public void cancel() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			this.uid = user.getUid();
			praiseService.doCanclePraise(uid, aid);
			write(true, "");
		}
	}
}
