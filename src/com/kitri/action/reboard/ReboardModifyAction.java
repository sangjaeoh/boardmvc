package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

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
		return "";

	}

}
