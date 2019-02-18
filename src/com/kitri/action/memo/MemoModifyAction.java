package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoModifyAction implements Action {

	
	private static MemoModifyAction memoModifyAction;
	private MemoModifyAction() {};
	static {
		memoModifyAction = new MemoModifyAction();
	}
	
	
	public static MemoModifyAction getMemoModifyAction() {
		return memoModifyAction;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "";

	}

}
