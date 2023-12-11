package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardDAO {
	public BoardVO getBoardOne(int boardID);

	public List<BoardVO> getBoardList();

	public List<BoardVO> getThumbnailList(String cateID);

	public int postBoardWrite(BoardImgVO boardImgVO);
}
