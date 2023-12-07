package com.pad.dev.controller;

import java.util.List;
import com.pad.dev.vo.boardVO.BoardVO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.BoardServiceImple;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
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
	public String getBoardOne(String boardID) {
		return "boardOne";
	}

	/***
	 * <h2>R : read all boards</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          resource path : /board
	 */
	@GetMapping("")
	public List<BoardVO> getBoard() {
		System.out.println("Board list");
		List<BoardVO> boardList = bs.getBoardList();
		return boardList;
	}

	/***
	 * <h2>C : Create Board</h2>
	 * 
	 * @apiNote
	 *          resource path : /board/write
	 */
	@PostMapping("/write")
	public String postBoardWrite() {
		return "boardWrite";
	}

}
