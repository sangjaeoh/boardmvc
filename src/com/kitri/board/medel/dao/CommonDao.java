package com.kitri.board.medel.dao;

import java.util.Map;

public interface CommonDao {
	int getNextSeq();
	void updateHit(int seq);
	
	int getNewArticleCount(int bcode);
	int getTotalArticleCount(Map<String, String> map);
}
