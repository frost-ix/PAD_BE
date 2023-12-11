package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.service.BoardService;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService {
	private final BoardDAO bm;

	@Override
	public BoardVO getBoardOne(int boardID) {
		log.info("게시판 호출");
		BoardVO board = bm.getBoardOne(boardID);
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		log.info("게시판 전체 호출");
		List<BoardVO> boardList = bm.getBoardList();
		return boardList;
	}

	@Override
	public List<BoardVO> getThumbnailList(String cateID) {
		log.info("썸네일 호출");
		List<BoardVO> thumbnailList = bm.getThumbnailList(cateID);
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
	public int postBoardWrite(BoardImgCateVO boardVO) {
		log.info("게시판 작성");
		int res = bm.postBoardWrite(boardVO);
		if (res == 1) {
			log.info("게시판 작성 성공");
			return 1;
		} else {
			log.info("게시판 작성 실패");
			return 0;
		}
	}
}
