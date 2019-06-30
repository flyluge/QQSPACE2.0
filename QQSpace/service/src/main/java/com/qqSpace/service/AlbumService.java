package com.qqSpace.service;

import com.qqSpace.domain.Album;
import com.qqSpace.util.PageBean;

public interface AlbumService {

	void deleteAlbum(Album album);

	void addAlbum(Album album);

	PageBean<Album> findAlbumByPage(Integer uid,Integer currpage, Integer pagesize);

}
