/** 
* @author 作者 :luge
* @version 创建时间：2019年6月30日 上午11:52:04 
*/
package com.qqSpace.web.action.base;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
/**
 * BaseAction作为所有Action的父类
 * @author Luge
 *
 */
public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	/**
	 * 输出json字符串
	 * 格式为:{
				"message": true,
				"data": {
					"name": "小白兔",
					"password": "123"
				}
			 }
	 * @param success : true/false
	 * @param data : 数据区域
	 */
	public void write(boolean success,Object data) {
		try {
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html;charset=utf-8");
			HashMap<Object, Object> map=new HashMap<Object, Object>();
			map.put("message", success);
			map.put("data", data);
			String jsonString = JSON.toJSONString(map);
			resp.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
