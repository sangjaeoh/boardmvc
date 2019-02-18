package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.memo.*;
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

	//댓글
	private static Action memoWriteAction;
	private static Action memoModifyAction;
	private static Action memoListAction;
	private static Action memoDeleteAction;
	

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
		
//댓글
		memoWriteAction = MemoWriteAction.getMemoWriteAction();
		memoModifyAction = MemoModifyAction.getMemoModifyAction();
		memoListAction = MemoListAction.getMemoListAction();
		memoDeleteAction = MemoDeleteAction.getMemoDeleteAction();
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

	public static Action getMemoWriteAction() {
		return memoWriteAction;
	}

	public static Action getMemoModifyAction() {
		return memoModifyAction;
	}

	public static Action getMemoListAction() {
		return memoListAction;
	}

	public static Action getMemoDeleteAction() {
		return memoDeleteAction;
	}

	
	
}
