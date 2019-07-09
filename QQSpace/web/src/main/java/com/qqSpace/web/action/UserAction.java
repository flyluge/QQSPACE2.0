package com.qqSpace.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.User;
import com.qqSpace.service.UserService;
import com.qqSpace.service.impl.UserServiceimpl;
import com.qqSpace.util.UploadUtils;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年6月30日 下午2:31:27 
*/
public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	User user;
	UserService userService;
    private File file; //得到上传的文件
	private String fileContentType; //得到文件的类型
    private String fileFileName; //得到文件的名称
    
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void sessionuser() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			write(true , user);			
		} else {
			write(false , "用户未登录");						
		}
	}
	public String loginFrame() {
		return "loginFrame";
	}
	public String showinfo() {
		return "infoFrame";
	}
	public String login() {
		if(user!=null) {
			User u = userService.login(user.getUseremail(), user.getUserpassword());
			if(u!=null) {
				//将用户信息存在session中
				ActionContext.getContext().getSession().put("user", u);
				return "loginsuccess";
			} else {
				addFieldError("error", "用户名或密码错误");
			}			
		} else {
			addFieldError("error", "用户信息不全");
		}
		return "loginFrame";	
	}
	public void existAccount() {
		if(user!=null) {
			if(userService.isExistAccount(user.getUseremail())) {
				write(true, "用户名存在");
			} else {
				write(false, "用户名不存在");
			}			
		} else {
			write(false, "用户信息不全");
		}
	}
	public void register() {
		if(user!=null) {
			int note = userService.doRegister(user);
			if(UserServiceimpl.ACCOUNT_EXIST == note||note == UserServiceimpl.FALSE) {
				write(false, "注册失败");
			} else if(note == UserServiceimpl.TRUE) {
				write(true, "注册成功");
			}
		} else {
			write(false, "用户信息不全");
		}
	}
	public String saveAlter() {
		if(fileFileName!=null) {
			try {
				String path=ServletActionContext.getServletContext().getRealPath("/upload");
				//String path="D:/image";
				String uuidFileName=UploadUtils.getUUIDName(fileFileName);
				String realPath=UploadUtils.getPath(uuidFileName);
				String url=path+realPath+"/"+uuidFileName;
				FileUtils.copyFile(file, new File(url));
				user.setUserimg("upload"+realPath+"/"+uuidFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userService.updateUser(user);
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().put("user", user);
		return "updatesuccess";
	}
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		return "loginFrame";
	}
	/**
	 * 用未登录，执行该方法
	 */
	public void timeout() {
		write(false, "用户未登录,请求超时");
	}
}
