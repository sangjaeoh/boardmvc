package com.kitri.board.model.service;

import com.kitri.util.PageNavigation;

public interface CommonService {
	
	PageNavigation getPageNavigation(int bcode, int pg, String word , String key);

	
}
