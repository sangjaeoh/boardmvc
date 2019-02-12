package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.reboard.*;

public class BoardActionFactory {

	private static Action reboardWriteAction;
	private static Action reboardListAction;
	private static Action reboardViewAction;
	private static Action reboardReplyAction;
	private static Action reboardModifyAction;
	private static Action reboardDeleteAction;

	static {
		reboardWriteAction = ReboardWriteAction.getReboardWriteAction();
		reboardListAction = ReboardListAction.getReboardListAction();
		reboardViewAction = ReboardViewAction.getReboardViewAction();
		reboardReplyAction = ReboardReplyAction.getReboardReplyAction();
		reboardModifyAction = ReboardModifyAction.getReboardModifyAction();
		reboardDeleteAction = ReboardDeleteAction.getReboardDeleteAction();
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

}
