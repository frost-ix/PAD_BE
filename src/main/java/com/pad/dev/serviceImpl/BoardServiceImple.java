package com.pad.dev.serviceImpl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.service.BoardService;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.cateVO.CateVO;
import com.pad.dev.vo.imgVO.ImgVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService {
	private final BoardDAO bm;

	@Override
	public int getMyBoardMax(String memID) {
		log.info("내 게시판 최대 호출");
		int maxCount = bm.getMyBoardMax(memID);
		return maxCount;
	}

	@Override
	public List<BoardImgVO> getMyBoardVO(int currentBoardID, String memID) {
		log.info("내 게시판 호출");
		log.info("Now Session member id : " + memID);
		List<BoardImgVO> boardVO = bm.getMyBoardVO(currentBoardID, memID);
		if (boardVO != null) {
			boardVO.forEach(board -> {
				log.info(board);
			});
			return boardVO;
		} else {
			log.warn("게시글 없음");
			return null;
		}
		// return boardVO;
	}

	@Override
	public BoardImgCateVO getBoardOne(BoardVO boardVO) {
		log.info("게시판 호출");
		int boardID = boardVO.getBoardID();
		log.info(boardID);
		BoardImgCateVO board = bm.getBoardOne(boardID);
		log.info(board);
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		log.info("게시판 전체 호출");
		List<BoardVO> boardList = bm.getBoardList();
		return boardList;
	}

	@Override
	public int getBoardMax() {
		log.info("게시판 최대 호출");
		int maxCount = bm.getBoardMax();
		return maxCount;
	}

	@Override
	public List<BoardImgCateVO> getThumbnailList(BoardImgCateVO boardImgCateVO) {
		log.info("썸네일 호출");
		log.info(boardImgCateVO.getCateID());
		List<BoardImgCateVO> thumbnailList = bm.getThumbnailList(boardImgCateVO);
		if (thumbnailList != null) {
			thumbnailList.forEach(thumbnail -> {
				log.info(thumbnail);
			});
			return thumbnailList;
		} else {
			log.warn("게시글 없음");
			return null;
		}
	}

	@Override
	public int postBoard(BoardImgVO boardImgVO) {
		log.info("게시판 작성");
		int res = bm.postBoard(boardImgVO);
		int boardID = bm.getBoardID(boardImgVO.getBoardTitle());
		log.info(boardID);
		boardImgVO.setBoardID(boardID);
		log.info("insert : " + boardImgVO);
		res = bm.postBoardImg(boardImgVO);

		if (res == 1) {
			log.info("게시판 작성 성공");
			return 1;
		} else {
			log.warn("게시판 작성 실패");
			return 0;
		}
	}

	@Override
	public int putBoard(BoardImgVO boardImgVO) {
		log.info("게시판 수정");
		ImgVO imgVO = new ImgVO();
		imgVO.setBoardID(boardImgVO.getBoardID());
		int res = bm.putBoard(boardImgVO, imgVO);
		if (res == 1) {
			log.info("게시판 수정 성공");
			return res;
		} else {
			log.warn("게시판 수정 실패");
			return res;
		}
	}

	@Override
	public int deleteBoard(BoardImgVO boardImgVO) {
		log.info("게시판 삭제");
		int res = bm.deleteBoard(boardImgVO);
		if (res == 1) {
			log.info("게시판 삭제 성공");
			return 1;
		} else {
			log.warn("게시판 삭제 실패");
			return 0;
		}
	}

	public List<BoardImgVO> getLatestBoard() {
		return bm.getLatestBoard();
	}

	@Override
	public List<BoardImgVO> getCateBoard(BoardImgVO boardImgVO) {
		log.info("카테고리 필터링");
		return bm.getCateBoard(boardImgVO);
	}

	@Override
	public List<CateVO> getCategory() {
		return bm.getCategory();
	}
}
