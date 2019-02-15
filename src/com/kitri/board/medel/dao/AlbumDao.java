package com.kitri.board.medel.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.AlbumDto;

public interface AlbumDao {

	
	int writeArticle(AlbumDto albumDto);
	List<AlbumDto> listArticle(Map<String, String> map);
	AlbumDto viewArticle(int seq);	
	AlbumDto getArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	int deleteArticle(int seq);
}
