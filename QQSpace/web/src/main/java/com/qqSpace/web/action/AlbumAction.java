/** 
* @author 作者 :luge
* @version 创建时间：2019年6月30日 上午11:31:44 
*/
package com.qqSpace.web.action;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Album;
import com.qqSpace.domain.User;
import com.qqSpace.service.AlbumService;
import com.qqSpace.util.PageBean;
import com.qqSpace.util.UploadUtils;
import com.qqSpace.web.action.base.BaseAction;

/**
 * AlbumAction类为相册相关操作类
 * @author Luge
 *
 */
public class AlbumAction extends BaseAction implements ModelDriven<Album>{
	
	private static final long serialVersionUID = 1L;
	
	private AlbumService albumService;
	private Album album=new Album();
    private File file; //得到上传的文件
    private String fileContentType; //得到文件的类型
    private String fileFileName; //得到文件的名称
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
    public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	@Override
	public Album getModel() {
		return album;
	}
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
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * 进入相册界面
	 */
	public String showAlbum() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			PageBean<Album> page=albumService.findAlbumByPage(user.getUid(), 1, 12);
			ActionContext.getContext().getValueStack().set("page", page);
			return "albumFrame";
		}else {
			write(false, "用户未登录");
			return NONE;
		}
	}
	/**
	 * 删除相册  
	 * 表单需要传入相册的id
	 */
	public String deleteAlbum() {
		albumService.deleteAlbum(album);
		return "deletesuccess";
	}
	/**
	 * 增加相册 表单上传图片
	 * 表单需要传入name为file的图片
	 */
	public String addAlbum(){
/*		User user1=new User();
		user1.setUid(1);
		ActionContext.getContext().getSession().put("user", user1);*/
		try {
			String path=ServletActionContext.getServletContext().getRealPath("/upload");
			//String path="D:/image";
			String uuidFileName=UploadUtils.getUUIDName(fileFileName);
			String realPath=UploadUtils.getPath(uuidFileName);
			String url=path+realPath+"/"+uuidFileName;
			FileUtils.copyFile(file, new File(url));
			User user=(User) ActionContext.getContext().getSession().get("user");
			Album album=new Album();
			album.setImage("upload"+realPath+"/"+uuidFileName);
			album.setUid(user.getUid());
			albumService.addAlbum(album);
			return "addsuccess";
		} catch (IOException e) {
			e.printStackTrace();
			return "addFail";
		}
	}
	/**
	 * 分页查询当前用户的相册
	 * 表单需要传入currpage pagesize
	 */
	public void findSessionAlbumByPage() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user==null) {
			this.write(false, "查看相册失败");
		}else {
			album.setUid(user.getUid());
			PageBean<Album> page=albumService.findAlbumByPage(album.getUid(),currpage,pagesize);
			if(page==null) {
				this.write(false, "查看相册失败");
			}else {
				this.write(true, page);
			}
		}
	}
	/**
	 * 分页查询所给uid对应用户的相册
	 * 表单需要传入uid currpage pagesize
	 */
	public void findAlbumByPage() {
		PageBean<Album> page=albumService.findAlbumByPage(album.getUid(),currpage,pagesize);
		if(page==null) {
			this.write(false, "查看相册失败");
		}else {
			this.write(true, page);
		}
	}
}
