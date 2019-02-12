package com.kitri.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.factory.BoardActionFactory;
import com.kitri.util.*;

@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");		
		
		int bcode = Validator.notNumberToZero((request.getParameter("bcode")));
		int pg = Validator.notNumberToOne((request.getParameter("pg")));
		String key =  Validator.nullToBlank(request.getParameter("key"));
		String word = Validator.nullToBlank(request.getParameter("word"));

		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + word;
		
		
		String path = "/index.jsp";
		if("mvwrite".equals(act)) {
			path ="/reboard/write.jsp" + queryString;
			PageMove.redirect(request, response, path);
			
		}else if("writearticle".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
		}else if("viewarticle".equals(act)) {
			path = BoardActionFactory.getReboardViewAction().execute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
		}else if("listarticle".equals(act)) {
			path = BoardActionFactory.getReboardListAction().execute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
			
		}else if("".equals(act)) {
			
		}else if("".equals(act)) {
			
		}else{			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}
}
