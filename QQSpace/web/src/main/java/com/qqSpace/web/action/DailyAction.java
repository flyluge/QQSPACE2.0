package com.qqSpace.web.action;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月15日 下午5:04:49 
*/

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.Daily;
import com.qqSpace.domain.User;
import com.qqSpace.service.DailyService;

public class DailyAction {
	private DailyService dailyService;
	private List<Daily> dailys;
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Daily> getDailys() {
		return dailys;
	}
	public void setDailys(List<Daily> dailys) {
		this.dailys = dailys;
	}
	public void setDailyService(DailyService dailyService) {
		this.dailyService = dailyService;
	}
	public String save() {
		Daily daily = new Daily();
		User user = (User) ActionContext.getContext().getSession().get("user");
		daily.setUid(user.getUid());
		daily.setContent(content);
		dailyService.save(daily);
		return "savesuccess";
	}
	public String show() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		dailys = dailyService.findAll(user.getUid());
		return "success";
	}
}
