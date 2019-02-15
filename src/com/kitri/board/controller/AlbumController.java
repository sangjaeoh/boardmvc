package com.kitri.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.util.*;

@WebServlet("/album")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		
		int bcode = Validator.notNumberToZero((request.getParameter("bcode")));
		int pg = Validator.notNumberToOne((request.getParameter("pg")));
		String key =  Validator.nullToBlank(request.getParameter("key"));
		String word = Validator.nullToBlank(request.getParameter("word"));

		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + URLEncoder.encode(word, BoardConstance.ENCODER);
		
		
		String path = "/index.jsp";
		if("mvwrite".equals(act)) {
			path ="/album/write.jsp" + queryString;
			PageMove.redirect(request, response, path);
			
		}else if("".equals(act)) {
			
		}else if("".equals(act)) {
			
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
