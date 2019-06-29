package com.qqSpace.service.impl;

import com.qqSpace.service.AlbumService;
import com.qqspace.dao.AlbumDao;

public class AlbumServiceimpl implements AlbumService {
	private AlbumDao albumDao;
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
}
