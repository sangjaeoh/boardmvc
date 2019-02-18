package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoDeleteAction implements Action {

	
	private static MemoDeleteAction memoDeleteAction;
	private MemoDeleteAction() {};
	static {
		memoDeleteAction = new MemoDeleteAction();
	}
	
	public static MemoDeleteAction getMemoDeleteAction() {
		return memoDeleteAction;
	}




	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "";
	}

}
