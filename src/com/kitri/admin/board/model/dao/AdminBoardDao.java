package com.kitri.admin.board.model.dao;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;

public interface AdminBoardDao {

	List<BoardListDto> getBoardMenu();
}
