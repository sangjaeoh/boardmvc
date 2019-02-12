package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.admin.board.*;

public class AdminBoardActionFactory {

	private static Action adminBoardListAction;
	private static Action adminBoardMakeAction;
	private static Action adminCategoryMakeAction;
	
	static {
		adminBoardListAction = AdminBoardListAction.getAdminBoardListAction();
		adminBoardMakeAction = AdminBoardMakeAction.getAdminBoardMakeAction();
		adminCategoryMakeAction = AdminCategoryMakeAction.getAdminCategoryMakeAction();
		
	}

	public static Action getAdminBoardListAction() {
		return adminBoardListAction;
	}

	public static Action getAdminBoardMakeAction() {
		return adminBoardMakeAction;
	}

	public static Action getAdminCategoryMakeAction() {
		return adminCategoryMakeAction;
	}

}
