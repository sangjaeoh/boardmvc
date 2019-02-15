package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.reboard.*;

public class BoardActionFactory {

//답변게시판
	private static Action reboardWriteAction;
	private static Action reboardListAction;
	private static Action reboardViewAction;
	private static Action reboardReplyAction;
	private static Action reboardModifyAction;
	private static Action reboardMoveModifyAction;
	private static Action reboardDeleteAction;
	private static Action reboardMoveReplyAction;


	static {
		
		
//답변게시판
		reboardWriteAction = ReboardWriteAction.getReboardWriteAction();
		reboardListAction = ReboardListAction.getReboardListAction();
		reboardViewAction = ReboardViewAction.getReboardViewAction();
		reboardReplyAction = ReboardReplyAction.getReboardReplyAction();
		reboardModifyAction = ReboardModifyAction.getReboardModifyAction();
		reboardMoveModifyAction = ReboardMoveModifyAction.getReboardMoveModifyAction();
		reboardDeleteAction = ReboardDeleteAction.getReboardDeleteAction();
		reboardMoveReplyAction = ReboardMoveReplyAction.getReboardMoveReplyAction();
		

	}
	
	


	public static Action getReboardMoveReplyAction() {
		return reboardMoveReplyAction;
	}

	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}

	public static Action getReboardListAction() {
		return reboardListAction;
	}

	public static Action getReboardViewAction() {
		return reboardViewAction;
	}

	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}

	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}

	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}

	public static Action getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}

}
