package com.pad.dev.daoImpl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
	private final SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> getMyBoardVO(String memID) {
		List<BoardVO> boardVO = null;
		try {
			boardVO = sqlSession.selectList("getMyBoard", memID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return boardVO;
	}

	@Override
	public BoardImgCateVO getBoardOne(int boardID) {
		BoardImgCateVO board = null;
		try {
			board = sqlSession.selectOne("getBoardOne", boardID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = null;
		try {
			System.out.println(">> BoardDAO implements section");
			boardList = sqlSession.selectList("getBoardList");
			System.out.println(">> select list query clear");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(boardList);
		return boardList;
	}

	@Override
	public int getBoardMax() {
		int maxCount = 0;
		try {
			maxCount = sqlSession.selectOne("getBoardMax");
			System.out.println(maxCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return maxCount;
	}

	@Override
	public int getMyBoardMax(String memID) {
		int maxCount = 0;
		try {
			maxCount = sqlSession.selectOne("getMyBoardMax", memID);
			System.out.println(maxCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return maxCount;
	}

	@Override
	public List<BoardVO> getThumbnailList(int currentBoardID) {
		List<BoardVO> thumbnailList = null;
		try {
			if (currentBoardID == 0) {
				System.out.println("No boardID");
			} else
				thumbnailList = sqlSession.selectList("getThumbnailList", currentBoardID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return thumbnailList;
	}

	@Override
	public int postBoardWrite(BoardImgVO boardImgVO) {
		System.out.println(boardImgVO);
		int result = 0;
		try {
			result = sqlSession.insert("insertBoard", boardImgVO);
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}
}
