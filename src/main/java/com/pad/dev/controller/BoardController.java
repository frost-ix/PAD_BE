package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
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
	public String getBoard() {
		return "board";
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
