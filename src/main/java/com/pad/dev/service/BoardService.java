package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

public interface BoardService {
	BoardVO getBoardOne(int boardID);

	List<BoardVO> getBoardList();

	List<BoardVO> getThumbnailList(String cateID);

	int postBoardWrite(BoardImgVO boardImgVO);
}