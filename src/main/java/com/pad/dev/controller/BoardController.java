package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/?={boardID}")
	public String getBoardOne() {
		return "boardOne";
	}

	@GetMapping("")
	public String getBoard() {
		return "board";
	}

}
