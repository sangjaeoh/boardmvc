package com.kitri.board.medel.dao;

public interface CommonDao {
	int getNextSeq();
	void updateHit(int seq);
}
