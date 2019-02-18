package com.kitri.board.medel.dao;

import java.util.List;

import com.kitri.board.model.MemoDto;

public interface MemoDao {

	void writememo(MemoDto memoDto);
	List<MemoDto> listMemo(int seq);
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int mseq);
	
}
