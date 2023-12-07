package com.pad.dev.dao;

import java.util.List;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList();

	public int postBoardWrite(BoardVO boardVO);
}
