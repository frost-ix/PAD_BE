package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.imgVO.ImgVO;

public interface BoardDAO {
	public List<BoardVO> getMyBoardVO(int currentBoardID, String memID);

	public int getMyBoardMax(String memID);

	public BoardImgCateVO getBoardOne(int boardID);

	public List<BoardVO> getBoardList();

	public int getBoardMax();

	public List<BoardImgCateVO> getThumbnailList(BoardImgCateVO boardImgCateVO);

	public int postBoardWrite(BoardImgVO boardImgVO);

	public int postBoardUpdate(BoardImgVO boardImgVO, ImgVO imgVO);

	public int postBoardDelete(BoardImgVO boardImgVO);
}
