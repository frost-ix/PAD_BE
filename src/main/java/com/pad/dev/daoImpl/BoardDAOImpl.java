package com.pad.dev.daoImpl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
	private final SqlSessionTemplate sqlSession;

	@Override
	public BoardVO getBoardOne(int boardID) {
		BoardVO board = null;
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
	public List<BoardVO> getThumbnailList(String cateID) {
		List<BoardVO> thumbnailList = null;
		try {
			if (cateID == null)
				thumbnailList = sqlSession.selectList("getThumbnailList");
			else
				thumbnailList = sqlSession.selectList("getThumbnailList", cateID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return thumbnailList;
	}

	@Override
	public int postBoardWrite(BoardImgCateVO boardVO) {
		int result = 0;
		try {
			result = sqlSession.insert("insertBoard", boardVO);
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}
}
