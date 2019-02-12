package com.kitri.admin.board.model.service;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.dao.AdminBoardDaoImpl;

public class AdminBoardServiceImpl implements AdminBoardService {

	private static AdminBoardService adminBoardService;
	
	private AdminBoardServiceImpl() {}
	
	static {
		adminBoardService = new AdminBoardServiceImpl();
	}
	
	
	
	public static AdminBoardService getAdminBoardService() {
		return adminBoardService;
	}


	@Override
	public List<BoardListDto> getBoardMenu() {
		
		return AdminBoardDaoImpl.getAdminBoardDao().getBoardMenu();
	}

}
