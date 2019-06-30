package com.qqSpace.service.impl;

import com.qqSpace.domain.Album;
import com.qqSpace.service.AlbumService;
import com.qqspace.dao.AlbumDao;

public class AlbumServiceimpl implements AlbumService {
	private AlbumDao albumDao;
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	@Override
	public void deleteAlbum(Album album) {
		albumDao.delete(album);
	}
}
