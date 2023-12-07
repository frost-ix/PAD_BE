package com.pad.dev.service;

import java.util.List;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardService {
	List<BoardVO> getBoardList();

	void postBoardWrite(BoardVO boardVO);
}