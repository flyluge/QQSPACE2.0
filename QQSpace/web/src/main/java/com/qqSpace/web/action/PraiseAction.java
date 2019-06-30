package com.qqSpace.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.User;
import com.qqSpace.service.PraiseService;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 下午6:49:08 
*/
public class PraiseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PraiseService praiseService;
	private int aid;
	private int uid;
	
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
	
	public void praise() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			this.uid = user.getUid();
			if(praiseService.doPraise(uid, aid)) {
				write(true, "");
			} else {
				write(false, "");
			}
		}
	}
	public void cancel() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			this.uid = user.getUid();
			praiseService.doCanclePraise(uid, aid);
			write(true, "");
		}
	}
}
