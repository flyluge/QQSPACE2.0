/** 
* @author 作者 :luge
* @version 创建时间：2019年6月30日 上午11:31:44 
*/
package com.qqSpace.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Album;
import com.qqSpace.service.AlbumService;
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
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	@Override
	public Album getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 删除相册  需要传入相册的id
	 */
	public void deleteAlbum() {
		albumService.deleteAlbum(album);
		write(true, "删除成功");
	}
}
