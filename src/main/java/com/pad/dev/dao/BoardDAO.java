package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardDAO {
	public BoardImgCateVO getBoardOne(int boardID);

	public List<BoardVO> getBoardList();

	public int getBoardMax();

	public List<BoardVO> getThumbnailList(int currentBoardID);

	public int postBoardWrite(BoardImgVO boardImgVO);
}
