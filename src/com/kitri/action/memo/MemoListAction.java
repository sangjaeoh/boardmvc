package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoListAction implements Action {

	
	private static MemoListAction memoListAction;
	private MemoListAction() {};
	static {
		memoListAction = new MemoListAction();
	}
	
	
	
	public static MemoListAction getMemoListAction() {
		return memoListAction;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "";
	}

}
