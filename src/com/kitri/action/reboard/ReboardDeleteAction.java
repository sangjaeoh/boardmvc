package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.service.ReboardServiceImpl;

public class ReboardDeleteAction implements Action {

	private ReboardDeleteAction() {}
	
	private static Action reboardDeleteAction;
	
	static {
		reboardDeleteAction = new ReboardDeleteAction();
	}
	
	
	
	
	
	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}





	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq")) ;
		int cnt = ReboardServiceImpl.getReboardService().deleteArticle(seq);
		if (cnt!=0) {
			
		}else {
			return "/index.jsp";
		}
		return "/reboard/view.jsp";	

	}

}
