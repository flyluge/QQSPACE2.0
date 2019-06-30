/** 
* @author 作者 :luge
* @version 创建时间：2019年6月30日 上午11:31:44 
*/
package com.qqSpace.web.action;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Album;
import com.qqSpace.service.AlbumService;
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

    public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	@Override
	public Album getModel() {
		// TODO Auto-generated method stub
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
	
	/**
	 * 删除相册  需要传入相册的id
	 */
	public void deleteAlbum() {
		albumService.deleteAlbum(album);
		write(true, "删除成功");
	}
	/**
	 * 增加相册 表单上传图片
	 */
	/*
	 * 		if(cmaf!=null) {
			//String path="D:/cmaf";
			String path=
			System.out.println(path);
			String uuidFileName=UploadUtils.getUUIDName(cmafFileName);
			String realPath=UploadUtils.getPath(uuidFileName);
			String url=path+realPath;
			File file=new File(url);
			if(!file.exists()) {
				file.mkdirs();
			}
			File cmafFile=new File(url+"/"+uuidFileName);
			FileUtils.copyFile(cmaf, cmafFile);
			customer.setCust_cmaf(url);
		}
	 * 
	 * 
	 */
	public void addAlbum(){
		try {
			System.out.println(fileContentType);
			System.out.println(fileFileName);
	        String path=ServletActionContext.getServletContext().getRealPath("/upload");
			System.out.println(path);
			String uuidFileName=UploadUtils.getUUIDName(fileFileName);
			String realPath=UploadUtils.getPath(uuidFileName);
			String url=path+realPath;
			File file=new File(url);
			if(!file.exists()) {
				file.mkdirs();
			}
			System.out.println(uuidFileName);
			File cmafFile=new File(url+"/"+uuidFileName);
			System.out.println(url+"/"+uuidFileName);
			FileUtils.copyFile(file, cmafFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
