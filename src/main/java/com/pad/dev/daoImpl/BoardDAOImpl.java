package com.pad.dev.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.imgVO.ImgVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
	private final SqlSession sqlSession;

	@Override
	public int getBoardID(String boardTitle) {
		int result = 0;
		try {
			result = sqlSession.selectOne("getBoardID", boardTitle);
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	@Override
	public BoardImgCateVO getBoardOne(int boardID) {
		BoardImgCateVO board = new BoardImgCateVO();
		try {
			System.out.println(boardID);
			board = sqlSession.selectOne("getBoardOne", boardID);
			List<ImgVO> imgLIst = sqlSession.selectList("getImgs", boardID);
			board.setImageVO(imgLIst);
			System.out.println(boardID);
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
		return board;
	}

	@Override
	public List<BoardImgCateVO> getThumbnailList(BoardImgCateVO boardImgCateVO) {
		List<BoardImgCateVO> thumbnailList = null;
		try {
			thumbnailList = sqlSession.selectList("getThumbnailList", boardImgCateVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return thumbnailList;
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
			System.out.println("Max Count : " + maxCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return maxCount;
	}

	@Override
	public List<BoardImgVO> getMyBoardVO(int currentBoardID, String memID) {
		List<BoardImgVO> boardVO = null;
		try {
			Map<String, Object> map = Map.of("currentBoardID", currentBoardID, "memID", memID);
			boardVO = sqlSession.selectList("getMyBoardList", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return boardVO;
	}

	@Override
	public int postBoard(BoardImgVO boardImgVO) {
		System.out.println(boardImgVO);
		int result = 0;
		try {
			result = sqlSession.insert("insertBoard", boardImgVO);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	@Override
	public int postBoardImg(BoardImgVO imageVO) {
		int result = 0;
		try {
			System.out.println("boardID : " + imageVO.getBoardID());
			result = sqlSession.insert("insertImage", imageVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public int putBoard(BoardImgVO boardImgVO, ImgVO imgVO) {
		int result = 0;
		try {
			int resultBoard = sqlSession.update("updateBoard", boardImgVO);
			int resultImg = sqlSession.update("updateImg", imgVO);
			result = resultBoard + resultImg / 2;
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	@Override
	public int deleteBoard(BoardImgVO boardImgVO) {
		int result = 0;
		try {
			result = sqlSession.delete("deleteBoard", boardImgVO);
			System.out.println("result: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}
}
