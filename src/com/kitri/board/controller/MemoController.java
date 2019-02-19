package com.kitri.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.factory.BoardActionFactory;
import com.kitri.util.BoardConstance;


@WebServlet("/memo")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String list ="";
		
		response.setContentType("application/x-json;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		if("writememo".equals(act)) {
			list = BoardActionFactory.getMemoWriteAction().execute(request, response);			
		}else if("listmemo".equals(act)) {
			list = BoardActionFactory.getMemoListAction().execute(request, response);
		}else if("modifymemo".equals(act)) {
			list = BoardActionFactory.getMemoModifyAction().execute(request, response);
		}else if("deletememo".equals(act)) {
			list = BoardActionFactory.getMemoDeleteAction().execute(request, response);
		}
		out.println(list);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}
}
