package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.service.BoardService;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService {
	private final BoardDAO bm;

	@Override
	public List<BoardVO> getMyBoardVO(String memID) {
		log.info("내 게시판 호출");
		List<BoardVO> boardVO = bm.getMyBoardVO(memID);
		return boardVO;
	}

	@Override
	public int getMyBoardMax(String memID) {
		log.info("내 게시판 최대 호출");
		int maxCount = bm.getMyBoardMax(memID);
		return maxCount;
	}

	@Override
	public BoardImgCateVO getBoardOne(BoardVO boardVO) {
		log.info("게시판 호출");
		int boardID = boardVO.getBoardID();
		BoardImgCateVO board = bm.getBoardOne(boardID);
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
	public List<BoardVO> getThumbnailList(int currentBoardID) {
		log.info("썸네일 호출");
		log.info(currentBoardID);
		List<BoardVO> thumbnailList = bm.getThumbnailList(currentBoardID);
		if (thumbnailList != null) {
			thumbnailList.forEach(thumbnail -> {
				log.info(thumbnail);
			});
			return thumbnailList;
		} else {
			log.info("게시글 없음");
			return null;
		}
	}

	@Override
	public int postBoardWrite(BoardImgVO boardImgVO) {
		log.info("게시판 작성");
		boardImgVO.setCateID("S-001");
		boardImgVO.setImageType("content");
		boardImgVO.setImagePath("/");
		log.info(boardImgVO);
		int res = bm.postBoardWrite(boardImgVO);
		if (res == 1) {
			log.info("게시판 작성 성공");
			return 1;
		} else {
			log.info("게시판 작성 실패");
			return 0;
		}
	}
}
