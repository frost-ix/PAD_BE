package com.pad.dev.controller;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgCateVO;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/{boardID}")
	public BoardVO getBoardOne(int boardID) {
		BoardVO board = bs.getBoardOne(boardID);
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
	public List<BoardVO> getBoardList(@RequestBody String option) {
		List<BoardVO> boardList = bs.getThumbnailList(option);
		return boardList;
	}

	/***
	 * <h2>C : Create Board</h2>
	 * 
	 * @apiNote
	 *          resource path : /board/write
	 */
	@PostMapping("/Write")
	public int postBoardWrite(@RequestBody BoardImgCateVO boardVO) {
		return bs.postBoardWrite(boardVO);
	}
}
