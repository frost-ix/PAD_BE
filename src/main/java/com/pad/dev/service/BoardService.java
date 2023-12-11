package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardService {
	List<BoardVO> getMyBoardVO(String memID);

	int getMyBoardMax(String memID);

	BoardImgCateVO getBoardOne(BoardVO boardVO);

	List<BoardVO> getBoardList();

	int getBoardMax();

	List<BoardVO> getThumbnailList(int currentBoardID);

	int postBoardWrite(BoardImgVO boardImgVO);
}