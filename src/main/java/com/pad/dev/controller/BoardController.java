package com.pad.dev.controller;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.boardVO.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.BoardServiceImple;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proxy/board")
public class BoardController {
	private final BoardServiceImple bs;

	@PostMapping("/myBoard")
	public List<BoardVO> getMyBoardVO(@RequestBody BoardImgVO boardImgVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int currentBoardID = boardImgVO.getCurrentBoardID();
		String member = (String) session.getAttribute("memID");
		List<BoardVO> boardVO = bs.getMyBoardVO(currentBoardID, member);
		return boardVO;
	}

	@PostMapping("/myBoardCount")
	public int getMyBoardMax(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String member = (String) session.getAttribute("memID");
		int maxCount = bs.getMyBoardMax(member);
		return maxCount;
	}

	/***
	 * <h2>R : read one board</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /board/{boardID}
	 *          </p>
	 * @param boardID : One board's article id.
	 */
	@PostMapping("/watch")
	public BoardImgCateVO getBoardOne(@RequestBody BoardVO boardVO) {
		BoardImgCateVO board = bs.getBoardOne(boardVO);
		return board;
	}

	/***
	 * <h2>R : read all boards</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          resource path : /board
	 */
	@PostMapping("")
	public List<BoardVO> getBoardList(@RequestBody BoardImgVO boardImgVO) {
		int currentBoardID = boardImgVO.getCurrentBoardID();
		System.out.println(currentBoardID);
		List<BoardVO> boardList = bs.getThumbnailList(currentBoardID);
		return boardList;
	}

	@PostMapping("count")
	public int getBoardMax() {
		int maxCount = bs.getBoardMax();
		return maxCount;
	}

	/***
	 * <h2>C : Create Board</h2>
	 * 
	 * @apiNote
	 *          resource path : /board/write
	 */
	@PostMapping("/Write")
	public int postBoardWrite(@RequestBody BoardImgVO boardVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(boardVO + " | " + session.getAttribute("Member"));
		boardVO.setMemID(session.getAttribute("memID").toString());
		return bs.postBoardWrite(boardVO);
	}

	@PostMapping("/Update")
	public int postBoardUpdate(@RequestBody BoardImgVO boardVO) {
		int boardID = bs.postBoardUpdate(boardVO);
		return boardID;
	}

	@PostMapping("/Delete")
	public int postBoardDelete(@RequestBody BoardImgVO boardVO) {
		int result = bs.postBoardDelete(boardVO);
		return result;
	}

}
