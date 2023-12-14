package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.cateVO.CateVO;

public interface BoardService {
	List<BoardImgVO> getMyBoardList(BoardImgVO boardImgVO);

	int getMyBoardMax(String memID);

	BoardImgCateVO getBoardOne(BoardVO boardVO);

	List<BoardVO> getBoardList();

	int getBoardMax();

	List<BoardImgCateVO> getThumbnailList(BoardImgCateVO boardImgCateVO);

	int postBoard(BoardImgVO boardImgVO);

	int putBoard(BoardImgVO boardImgVO);

	List<BoardImgVO> getLatestBoard();

	int deleteBoard(BoardImgVO boardImgVO);

    List<BoardImgVO> getCateBoard(BoardImgVO boardImgVO);

    List<CateVO> getCategory();

}