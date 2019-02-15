package com.kitri.board.model.service;

import java.util.List;

import com.kitri.board.model.AlbumDto;


public interface AlbumService {

	int writeArticle(AlbumDto albumDto);
	List<AlbumDto> listArticle(int bcode, int pg, String key, String word);
	AlbumDto viewArticle(int seq);
	AlbumDto getArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	int deleteArticle(int seq);
	
}
