package com.kitri.board.model.service;

import java.util.List;

import com.kitri.board.medel.dao.MemoDaoImpl;
import com.kitri.board.model.MemoDto;

public class MemoServiceImpl implements MemoService {

	
	private static MemoServiceImpl memoServiceImpl;
	static {
		memoServiceImpl = new MemoServiceImpl();
	}
	private MemoServiceImpl() {}; 
	
	
	
	
	public static MemoServiceImpl getMemoServiceImpl() {
		return memoServiceImpl;
	}




	@Override
	public void writememo(MemoDto memoDto) {
		MemoDaoImpl.getMemoDaoImpl().writememo(memoDto);
	}

	@Override
	public List<MemoDto> listMemo(int seq) {		
		return MemoDaoImpl.getMemoDaoImpl().listMemo(seq);
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
	

	}

	@Override
	public void deleteMemo(int mseq) {
	

	}

}
