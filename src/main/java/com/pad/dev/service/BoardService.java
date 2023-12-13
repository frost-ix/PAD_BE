package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardService {
	List<BoardImgVO> getMyBoardVO(int currentBoardID, String memID);

	int getMyBoardMax(String memID);

	BoardImgCateVO getBoardOne(BoardVO boardVO);

	List<BoardVO> getBoardList();

	int getBoardMax();

	List<BoardImgCateVO> getThumbnailList(BoardImgCateVO boardImgCateVO);

	int postBoard(BoardImgVO boardImgVO);

	int putBoard(BoardImgVO boardImgVO);

	List<BoardImgVO> getLatestBoard();

	int deleteBoard(BoardImgVO boardImgVO);

}