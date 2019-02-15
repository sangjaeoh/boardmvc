package com.kitri.board.model.service;

import java.util.List;

import com.kitri.board.medel.dao.AlbumDaoImpl;
import com.kitri.board.medel.dao.CommonDaoImpl;
import com.kitri.board.model.AlbumDto;

public class AlbumServiceImpl implements AlbumService {

	
	private static AlbumServiceImpl albumServiceImpl;
	static {
		albumServiceImpl = new AlbumServiceImpl();
	}
	private AlbumServiceImpl() {}
	
	
	public static AlbumServiceImpl getAlbumServiceImpl() {
		return albumServiceImpl;
	}



	@Override
	public int writeArticle(AlbumDto albumDto) {
		int seq = CommonDaoImpl.getCommonDao().getNextSeq();
		albumDto.setSeq(seq);
		albumDto.setAseq(seq);		
		return AlbumDaoImpl.getAlbumDaoImpl().writeArticle(albumDto) != 0 ? seq : 0;
	
	}

	@Override
	public List<AlbumDto> listArticle(int bcode, int pg, String key, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlbumDto viewArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlbumDto getArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyArticle(AlbumDto albumDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
