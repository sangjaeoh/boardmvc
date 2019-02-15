package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.model.service.ReboardServiceImpl;
import com.kitri.member.model.MemberDto;

public class ReboardModifyAction implements Action {

	private ReboardModifyAction() {}
	
	private static Action reboardModifyAction;
	
	static {
		reboardModifyAction = new ReboardModifyAction();
	}
	
	
	
	
	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}




	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			ReboardDto reboardDto = new ReboardDto();
			int seq = 0;			
			seq = Integer.parseInt(request.getParameter("seq"));
			request.setAttribute("seq", seq);
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setSeq(seq);
		
			seq = ReboardServiceImpl.getReboardService().modifyArticle(reboardDto);			
			
			return "/reboard/writeok.jsp";
		}		
		return "/index.jsp";

	}

}
