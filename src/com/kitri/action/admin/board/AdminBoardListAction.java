package com.kitri.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.service.AdminBoardServiceImpl;

public class AdminBoardListAction implements Action {

	private static Action adminBoardListAction;
	
	private AdminBoardListAction() {}
	
	static {
		adminBoardListAction = new AdminBoardListAction();
	}
		
	
	public static Action getAdminBoardListAction() {
		return adminBoardListAction;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardListDto> list = AdminBoardServiceImpl.getAdminBoardService().getBoardMenu();
		
		ServletContext application = request.getServletContext();
		application.setAttribute("boardmenu", list);
		
		return "/admin/board/boardmenu.jsp";

	}

}
